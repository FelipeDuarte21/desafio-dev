import { Component, ElementRef, EventEmitter, Output, ViewChild } from "@angular/core";
import { AlertasService } from "../alertas/alertas.service";
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

    @ViewChild('inputFile')
    public inputFile: ElementRef;

    constructor(
        private appService: AppService,
        private spinnerService: SpinnerService,
        private alertaService: AlertasService
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
                    this.inputFile.nativeElement.value = '';
                    this.spinnerService.desativarSpinner();
                },
                error => {
                    this.inputFile.nativeElement.value = '';
                    this.spinnerService.desativarSpinner();
                    this.alertaService.alertaErro(error.error.message);
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
                this.eventoLoadArquivo.emit([]);
            }
        );

    }

}