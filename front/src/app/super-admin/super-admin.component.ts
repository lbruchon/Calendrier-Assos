import { Component, OnInit } from '@angular/core';
import { AssoService } from '../services/asso.service';

@Component({
  selector: 'app-super-admin',
  templateUrl: './super-admin.component.html',
  styleUrls: ['./super-admin.component.scss']
})
export class SuperAdminComponent implements OnInit {

  assos: any;

  constructor(private assoService: AssoService) { 
  }

  ngOnInit() {
    this.assoService.getAssos().subscribe(response => this.assos = response);
  }

}