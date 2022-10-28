import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AssoService } from 'src/app/services/asso.service';
import { Association } from 'src/models/association.model';

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


  onSubmit(ngForm: NgForm) {

    this.asso = new Association(
      this.asso.id,
      ngForm.form.value.nomAssociation,
      ngForm.form.value.facebookLink,
      ngForm.form.value.instagramLink,
      null,
      null,
    )

    console.log(this.asso)

    this.displayEditStyle = "none";
    this.assoService.updateAssociation(this.asso).subscribe();
    this.refreshPage()
  }


  deleteAsso(id: Number) {
    this.displayDeleteStyle = "none";
    this.assoService.deleteAssociation(id).subscribe();
    this.refreshPage()
  }

  refreshPage() {
    window.location.reload();
  }

}
