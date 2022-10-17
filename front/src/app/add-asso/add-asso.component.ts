import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Association} from "../../models/association.model";
import {AssociationService} from "../services/association.service";
import {NgForm} from "@angular/forms";
import {User} from "../../models/user.model";

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
    // let {nomAssociation: association_name, facebookLink: fblink, instagramLink: instalink} = ngForm.form.value;

    console.log("ngForm : " + ngForm.form.value);

    const association = new Association(
      null,
      ngForm.form.value.nomAssociation,
      ngForm.form.value.facebookLink,
      ngForm.form.value.instagramLink,
      null,
      null,
    )

    console.log(association)

    this.assoService.addAssociation(association).subscribe();
    //setTimeout(()=>this.router.navigateByUrl('/'), 1000)
  }
}
