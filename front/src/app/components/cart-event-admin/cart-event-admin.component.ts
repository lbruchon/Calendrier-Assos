import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AssoService } from 'src/app/services/asso.service';

@Component({
  selector: 'app-cart-event-admin',
  templateUrl: './cart-event-admin.component.html',
  styleUrls: ['./cart-event-admin.component.scss']
})
export class CartEventAdminComponent implements OnInit {

  @Input() asso: any;

  constructor(private assoService: AssoService, private router: Router){}

  ngOnInit() {
  }

  
  displayEditStyle = "none";
  displayDeleteStyle = "none";
  
  // Modal edit
  openEditPopup() {
    this.displayEditStyle = "block";
  }

  closeEditPopup() {
    this.displayEditStyle = "none";
  }

  // Modal delete
  openDeletePopup() {
    this.displayDeleteStyle = "block";
  }

  closeDeletePopup() {
    this.displayDeleteStyle = "none";
  }

  deleteAsso(id: Number) {
    this.displayDeleteStyle = "none";
    this.assoService.deleteAssociation(id).subscribe();
    setTimeout(()=>this.router.navigateByUrl('/super-admin'), 500);
  }

}