import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddUserComponent} from "./add-user/add-user.component";
import {ListUsersComponent} from "./list-users/list-users.component";
import {ConnexionComponent} from "./connexion/connexion.component";
import { SuperAdminComponent } from './super-admin/super-admin.component';

const routes: Routes = [
  {path:'', component: ListUsersComponent},
  {path:'add-user', component: AddUserComponent},
  {path:'connexion', component: ConnexionComponent},
  {path:'super-admin', component: SuperAdminComponent
}
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
