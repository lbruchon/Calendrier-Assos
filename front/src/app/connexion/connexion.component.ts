import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Member } from '../../models/member.model';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { MemberService } from '../services/member.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss'],
})
export class ConnexionComponent implements OnInit {
  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private memberService: MemberService
  ) {}

  ngOnInit() {
    var div = document.getElementById('incorrectCreds');
    div.textContent = '';
  }

  onSubmit(ngForm: NgForm) {
    let email = ngForm.form.value.memberEmail;
    let mdp = ngForm.form.value.memberMdp;

    this.memberService.getConnectedMember(email, mdp).subscribe((response) => {
      //connected

      if (response[0] == 'true') {
        console.log('premier ok');
        if (response[1] == 'true') {
          console.log('2 eme ok');
          // set admin variable in local storage
          localStorage.setItem('currentMember', JSON.stringify(response[2]));
          setTimeout(() => this.router.navigateByUrl('/super-admin'), 1000);
        } else {
          console.log('response 2 = ', response[2]);
          localStorage['number'] = response[2];
          console.log('response 2 LS = ',localStorage['number']);
          localStorage.setItem('currentMember', JSON.stringify(response[2]));
          setTimeout(() => this.router.navigateByUrl('/asso-admin'), 1000);
        }
      }
      // not connected
      else {
        console.log('permier Nok');
        var div = document.getElementById('incorrectCreds');
        div.textContent = 'Les identifiants saisis sont incorrects !';
      }
    });
  }
}
