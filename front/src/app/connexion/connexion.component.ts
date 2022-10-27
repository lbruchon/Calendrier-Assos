import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {Member} from "../../models/member.model";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

import {MemberService} from "../services/member.service";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})

export class ConnexionComponent implements OnInit {

  constructor(private httpClient: HttpClient, private router: Router, private memberService: MemberService) {
  }

  ngOnInit() {
    var div = document.getElementById('incorrectCreds');
    div.textContent = "";
  }

  onSubmit(ngForm: NgForm) {

    let email = ngForm.form.value.memberEmail;
    let mdp = ngForm.form.value.memberMdp;

    this.memberService.getConnectedMember(email, mdp).subscribe(response => {
      //connected
        if (response[0] == "true") {
          if (response[1] == "true"){
            // set admin variable in local storage
            localStorage.setItem('currentMember', JSON.stringify(response[2]));
            setTimeout(()=>this.router.navigateByUrl('/super-admin'), 1000)
          } else {
            // set asso variable in local storage
            localStorage.setItem('currentMember', JSON.stringify(response[2]));
            setTimeout(()=>this.router.navigateByUrl('/association'), 1000)}
        }
        // not connected
        else {
          var div = document.getElementById('incorrectCreds');
          div.textContent = "Les identifiants saisis sont incorrects !";
        }
      }
    )
  }
}
