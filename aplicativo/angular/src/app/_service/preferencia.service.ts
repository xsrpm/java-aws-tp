import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Preferencia } from '../_model/preferencia';

@Injectable({
  providedIn: 'root'
})
export class PreferenciaService {

  url : string = `${environment.PREFERENCIA_HOST}/api/preferencias/listar`;

  constructor(private http : HttpClient) { }

  listar(){
    return this.http.get<Preferencia[]>(this.url);
  }
}
