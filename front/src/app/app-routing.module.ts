import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddUserComponent} from "./add-user/add-user.component";
import {ListUsersComponent} from "./list-users/list-users.component";
import {ConnexionComponent} from "./connexion/connexion.component";
import { AccueilComponent } from './accueil/accueil.component';
import { SuperAdminComponent } from './super-admin/super-admin.component';
import {AddAssoComponent} from "./add-asso/add-asso.component";
import {AddPostComponent} from "./add-post/add-post.component";

const routes: Routes = [
  {path:'', component: ListUsersComponent},
  {path:'add-user', component: AddUserComponent},
  {path:'connexion', component: ConnexionComponent},
  {path:'index', component: AccueilComponent},
  {path:'super-admin', component: SuperAdminComponent},
  {path:'add-asso', component: AddAssoComponent},
  {path:'add-post', component: AddPostComponent},
];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
