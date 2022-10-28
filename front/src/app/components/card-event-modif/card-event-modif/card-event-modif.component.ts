import { Component, Input, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';
import { NgForm } from '@angular/forms';
import { TagService } from 'src/app/services/tag.service';
import { Post } from 'src/models/post.model';
import { Association } from 'src/models/association.model';

@Component({
  selector: 'app-card-event-modif',
  templateUrl: './card-event-modif.component.html',
  styleUrls: ['./card-event-modif.component.scss']
})
export class CardEventModifComponent implements OnInit {
  @Input() post: any;
  tag: any;
  tagList : any;
  NouveauPost :any;
  asso : any;
  idAsso : any ;
  constructor(private postService: PostService, private tagService: TagService) {}

  ngOnInit(): void {
    this.tag = this.postService
      .getTagNameIdPost(this.post.id)
      .subscribe((response) => (this.tag = response));
  }

  displayEditStyle = "none";
  displayChoixTag = "none";

  link() {

    let url = this.post.postLink;
    window.open(url, '_blank');
  }

  deleteThisPost(id: Number){

    this.postService.deletePost(id).subscribe();
    window.location.reload();
  }

  onSubmit(ngForm: NgForm) {
    console.log(+localStorage['number'] )
   this.idAsso =+localStorage['number']

    this.asso = new Association(
      this.idAsso,
      null,
      null,
      null,
      null,
      null,

    )

    console.log("nsm allez le id asso" + this.asso.id)


    this.NouveauPost = new Post(
      this.post.id,
      ngForm.form.value.postName,
      ngForm.form.value.postPlace,
      ngForm.form.value.postLink,
      ngForm.form.value.postDescription,
      ngForm.form.value.postDateEvent,
      this.asso,
      null,
    )

    this.displayEditStyle = "none";
    this.displayChoixTag= "block";
    this.tagService.getTags().subscribe(response => this.tagList = response)
  }

  closeChoixTagPopup() {
    this.displayChoixTag = "none";
  }

addTagToPost(){


  this.NouveauPost.tag =this.tag;
  this.postService.updatePost(this.NouveauPost).subscribe();
  this.closeChoixTagPopup()

}

  closeEditPopup() {
    this.displayEditStyle = "none";
  }


  openEditPopup() {
    this.displayEditStyle = "block";
  }

}
