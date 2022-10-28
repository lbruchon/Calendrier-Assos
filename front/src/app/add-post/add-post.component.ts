import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {Post} from "../../models/post.model";

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.scss']
})
export class AddPostComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(ngForm: NgForm) {
    const post = new Post(
      null,
      ngForm.form.value.nomEvent,
      ngForm.form.value.lieuEvent,
      ngForm.form.value.lienEvent,
      ngForm.form.value.descriptionEvent,
      ngForm.form.value.dateEvent,
      //asso id à mettre
      //localStorage.getItem('currentMember'),
      ngForm.form.value.dateEvent,
      // tag id à mettre
      ngForm.form.value.dateEvent,
    )

  }

}
