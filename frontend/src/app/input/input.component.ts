import { Component, EventEmitter, Output } from "@angular/core";
import { AppService } from "../app.service";
import { Loja } from "../modelos/modelos.model";
import { SpinnerService } from "../spinners/spinner.service";

@Component({
    selector: 'app-input',
    templateUrl: './input.component.html',
    styleUrls: ['./input.component.css']
})
export class InputComponent{

    @Output() eventoLoadArquivo: EventEmitter<Loja[]> = new EventEmitter;

    constructor(
        private appService: AppService,
        private spinnerService: SpinnerService
    ){}

    public onChangeFile(evento: any){

        this.spinnerService.ativarSpinner();

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

        this.spinnerService.ativarSpinner();

        this.appService.listarLojas().subscribe(
            lojas => {
                this.eventoLoadArquivo.emit(lojas);
                this.spinnerService.desativarSpinner();
            },
            error => {
                console.log(error);
            }
        );

    }

}