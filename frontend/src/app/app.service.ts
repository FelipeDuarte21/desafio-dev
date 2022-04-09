import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Loja } from "./modelos/modelos.model";

@Injectable({providedIn: 'root'})
export class AppService{

    private baseURL: string = `${environment.apiURL}/sistema-cnab/api/v1`;

    constructor(
        private http: HttpClient
    ){}

    public uploadArquivo(arquivo: FormData): Observable<any>{
        return this.http.post(`${this.baseURL}/upload_base_dados`,arquivo);
    }

    public listarLojas():Observable<Loja[]>{
        return this.http.get<Loja[]>(`${this.baseURL}/lojas`);
    }

}