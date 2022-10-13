import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Association} from "../../models/association.model";
import {AssociationService} from "../services/association.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-add-asso',
  templateUrl: './add-asso.component.html',
  styleUrls: ['./add-asso.component.scss']
})
export class AddAssoComponent implements OnInit {

  constructor(private httpClient: HttpClient, private router: Router, private assoService: AssociationService) {
  }

  ngOnInit() {
  }

  onSubmit(ngForm: NgForm) {
    let {nomAssociation: asso, facebookLink: fblink, instagramLink: instalink} = ngForm.form.value;

    console.log("nom asso : " + asso);

    //setTimeout(()=>this.router.navigateByUrl('/'), 1000)
  }

}
