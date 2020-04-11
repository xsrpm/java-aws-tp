import { Component, OnInit, ViewChild } from '@angular/core';
import { Preferencia } from 'src/app/_model/preferencia';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { PreferenciaService } from 'src/app/_service/preferencia.service';

@Component({
  selector: 'app-preferencias',
  templateUrl: './preferencias.component.html',
  styleUrls: ['./preferencias.component.css']
})
export class PreferenciasComponent implements OnInit {
  dataSource : MatTableDataSource<Preferencia>;
  displayedColumns = ['id','idPersona','lenguajeProgramacion'];
  @ViewChild(MatSort,{static : true}) sort : MatSort;
  @ViewChild(MatPaginator,{static : true}) paginator : MatPaginator;
  
  title = 'preferencias';

  constructor(private preferenciaService : PreferenciaService) { }

  ngOnInit() {
    this.preferenciaService.listar().subscribe(data => {
      this.dataSource=new MatTableDataSource(data);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  filtrar(valor : string){
    this.dataSource.filter =valor.trim().toLowerCase();
  }

}
