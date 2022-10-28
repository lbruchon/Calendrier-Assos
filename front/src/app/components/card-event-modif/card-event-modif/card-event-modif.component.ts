import { Component, Input, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-card-event-modif',
  templateUrl: './card-event-modif.component.html',
  styleUrls: ['./card-event-modif.component.scss']
})
export class CardEventModifComponent implements OnInit {
  @Input() post: any;
  tag: any;
  tagList : [];
  constructor(private postService: PostService) {}

  ngOnInit(): void {
    this.tag = this.postService
      .getTagNameIdPost(this.post.id)
      .subscribe((response) => (this.tag = response));
  }

  displayEditStyle = "none";
  displayChoixTag = "none";

  link() {
    console.log(this.post.postLink);
    let url = this.post.postLink;
    window.open(url, '_blank');
  }

  deleteThisPost(id: Number){
    console.log("on va suppr ", id);
    this.postService.deletePost(id).subscribe();
    window.location.reload();
  }

  onSubmit(ngForm: NgForm) {


  }

  closeEditPopup() {
    this.displayEditStyle = "none";
  }


  openEditPopup() {
    this.displayEditStyle = "block";
  }

}
