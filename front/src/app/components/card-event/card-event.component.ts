import { Component, Input, OnInit, Output } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-card-event',
  templateUrl: './card-event.component.html',
  styleUrls: ['./card-event.component.scss']
})
export class CardEventComponent implements OnInit {

  @Input() post :any;
  tag:any;

  constructor(private postService : PostService) { }

  ngOnInit(): void {

    this.tag =this.postService.getTagNameIdPost(this.post.id).subscribe(response => this.tag = response);


    }

    link() {
      console.log(this.post.postLink);
      let url = this.post.postLink;
      window.open(url, '_blank');
  }

}
