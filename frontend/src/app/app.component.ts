import { Component } from '@angular/core';
import { Loja } from './modelos/modelos.model';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {

	public lojas: Loja[] = []
	
	onEventoLoadArquivo(lojas: Loja[]){
		this.lojas = lojas;
	}

}
