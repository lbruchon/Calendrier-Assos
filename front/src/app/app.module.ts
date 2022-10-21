import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { AddUserComponent } from './add-user/add-user.component';
import { ListUsersComponent } from './list-users/list-users.component';
import {FormsModule} from "@angular/forms";
import {ConnexionComponent} from "./connexion/connexion.component";
import { AccueilComponent } from './accueil/accueil.component';
import { CardEventComponent } from './components/card-event/card-event.component';
import { SuperAdminComponent } from './super-admin/super-admin.component';
import { CartEventAdminComponent } from './components/cart-event-admin/cart-event-admin.component';
import { AddAssoComponent } from './add-asso/add-asso.component';
import { AssoAdminComponent } from './asso-admin/asso-admin/asso-admin.component';
import { CardEventModifComponent } from './components/card-event-modif/card-event-modif/card-event-modif.component';

@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    ListUsersComponent,
    ConnexionComponent,
    AccueilComponent,
    CardEventComponent,
    SuperAdminComponent,
    CartEventAdminComponent,
    CardEventComponent,
    AddAssoComponent,
    AssoAdminComponent,
    CardEventModifComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
