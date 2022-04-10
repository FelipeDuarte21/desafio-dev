import { Component, Input, OnInit } from "@angular/core";
import { AppService } from "../app.service";
import { Loja } from "../modelos/modelos.model";
import { SpinnerService } from "../spinners/spinner.service";

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