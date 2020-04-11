import { Component,OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { Persona } from './_model/persona';
import { PreferenciaService } from './_service/preferencia.service';
import { Preferencia } from './_model/preferencia';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  constructor() { }
}
