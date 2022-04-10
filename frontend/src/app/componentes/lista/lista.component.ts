import { Component, Input, OnInit } from "@angular/core";
import { AppService } from "src/app/app.service";
import { SpinnerService } from "src/app/compartilhados/spinners/spinner.service";
import { Loja } from "src/app/modelos/modelos.model";



@Component({
    selector: 'lista',
    templateUrl: './lista.component.html',
    styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit{

    @Input() lojas: Loja[] = [];

    constructor(
        private appService: AppService,
        private spinnerService: SpinnerService
    ){}

    ngOnInit(): void {
        this.spinnerService.ativarSpinner();
        this.appService.listarLojas().subscribe(
            lojas => {
                this.lojas = lojas;
                this.spinnerService.desativarSpinner();
            },
            error => {
                console.log(error);
                this.spinnerService.desativarSpinner();
            }
        );
    }

}