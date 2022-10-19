import { Component, Input, OnInit } from '@angular/core';
import { AssoService } from 'src/app/services/asso.service';
import { Association } from 'src/models/association.model';

@Component({
  selector: 'app-cart-event-admin',
  templateUrl: './cart-event-admin.component.html',
  styleUrls: ['./cart-event-admin.component.scss']
})
export class CartEventAdminComponent implements OnInit {

  @Input() asso: any;

  constructor(){}

  ngOnInit() {
  }

}
