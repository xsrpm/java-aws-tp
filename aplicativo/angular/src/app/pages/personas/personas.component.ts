import { Component, OnInit, ViewChild } from '@angular/core';
import { Persona } from 'src/app/_model/persona';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { PersonaService } from 'src/app/_service/persona.service';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css']
})
export class PersonasComponent implements OnInit {

  dataSource : MatTableDataSource<Persona>;
  displayedColumns = ['id','nombre','edad','sexo'];
  @ViewChild(MatSort,{static : true}) sort : MatSort;
  @ViewChild(MatPaginator,{static : true}) paginator : MatPaginator;
  
  title = 'personas';

  constructor(private personaService : PersonaService) { }

  ngOnInit() {
    this.personaService.listar().subscribe(data => {
      this.dataSource=new MatTableDataSource(data);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  filtrar(valor : string){
    this.dataSource.filter =valor.trim().toLowerCase();
  }

}
