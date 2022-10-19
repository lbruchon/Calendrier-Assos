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
  }

  onSubmit(ngForm: NgForm) {

    let email = ngForm.form.value.memberEmail;
    let mdp = ngForm.form.value.memberMdp;

    this.memberService.getConnectedMember(email, mdp).subscribe(response =>
      {

        console.log(response)
        if (response == true){
          console.log("connected")
        }
        else console.log("not connected")
      }
    ) ;



    //setTimeout(()=>this.router.navigateByUrl('/'), 1000)
  }


}
