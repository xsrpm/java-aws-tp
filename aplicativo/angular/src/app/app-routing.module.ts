import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PreferenciasComponent } from './pages/preferencias/preferencias.component';
import { PersonasComponent } from './pages/personas/personas.component';


const routes: Routes = [
  { path : 'personas', component : PersonasComponent},
  { path : 'preferencias', component : PreferenciasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
