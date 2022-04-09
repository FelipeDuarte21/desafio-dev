import { Component, Input, OnInit } from "@angular/core";
import { AppService } from "../app.service";
import { Loja } from "../modelos/modelos.model";

@Component({
    selector: 'lista',
    templateUrl: './lista.component.html',
    styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit{

    @Input() lojas: Loja[] = [];

    constructor(
        private appService: AppService
    ){}

    ngOnInit(): void {
        this.appService.listarLojas().subscribe(
            lojas => {
                this.lojas = lojas;
            },
            error => {
                console.log(error);
            }
        );
    }

}