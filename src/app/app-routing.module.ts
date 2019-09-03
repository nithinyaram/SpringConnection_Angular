import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent } from './Componets/user-form/user-form.component';
import { PreviewComponent } from './Componets/preview/preview.component';


const routes: Routes = [
  {path:'Home',component:UserFormComponent},
  {path:'Preview',component:PreviewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
