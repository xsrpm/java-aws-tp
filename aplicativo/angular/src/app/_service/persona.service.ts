import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../_model/persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  url : string = `${environment.PERSONA_HOST}/api/personas/listar`;

  constructor(private http : HttpClient) { }

  listar(){
    return this.http.get<Persona[]>(this.url);
  }
}
