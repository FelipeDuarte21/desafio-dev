import { HttpClientModule } from '@angular/common/http';
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import ptBr from '@angular/common/locales/pt';
import { AppComponent } from './app.component';
import { InputComponent } from './input/input.component';
import { ListaComponent } from './lista/lista.component';
import { registerLocaleData } from '@angular/common';
import { CpfPipe } from './cpf.pipe';
import { SpinnerModule } from './spinners/spinner.module';

registerLocaleData(ptBr);

@NgModule({
	declarations: [
		AppComponent,
		InputComponent,
		ListaComponent,
		CpfPipe
	],
	imports: [
		BrowserModule,
		HttpClientModule,
		SpinnerModule
	],
	providers: [
		{
            provide: LOCALE_ID,
            useValue: 'pt' 
        },
        {
            provide: DEFAULT_CURRENCY_CODE,
            useValue: 'BRL'
        }
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
