import { Component, EventEmitter, Output } from "@angular/core";
import { AppService } from "../app.service";
import { Loja } from "../modelos/modelos.model";

@Component({
    selector: 'app-input',
    templateUrl: './input.component.html',
    styleUrls: ['./input.component.css']
})
export class InputComponent{

    @Output() eventoLoadArquivo: EventEmitter<Loja[]> = new EventEmitter;

    constructor(
        private appService: AppService
    ){}

    public onChangeFile(evento: any){

        if(evento.target.files && evento.target.files[0]){

            let formData = new FormData();

            let arquivo = evento.target.files[0];

            formData.append('arquivo',arquivo);

            this.appService.uploadArquivo(formData).subscribe(
                sucesso => {
                    
                    this.buscarListaDeLojas();

                },
                error => {
                    console.log(error);
                }
            );

        }
       
    }

    private buscarListaDeLojas(){

        this.appService.listarLojas().subscribe(
            lojas => {
                this.eventoLoadArquivo.emit(lojas);
            },
            error => {
                console.log(error);
            }
        );

    }

}