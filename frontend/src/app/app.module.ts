import { HttpClientModule } from '@angular/common/http';
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import ptBr from '@angular/common/locales/pt';
import { AppComponent } from './app.component';
import { InputComponent } from './componentes/input/input.component';

import { registerLocaleData } from '@angular/common';
import { CpfPipe } from './cpf.pipe';
import { SpinnerModule } from './compartilhados/spinners/spinner.module';
import { AlertasModule } from './compartilhados/alertas/alertas.module';
import { ListaComponent } from './componentes/lista/lista.component';

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
		SpinnerModule,
		AlertasModule
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
