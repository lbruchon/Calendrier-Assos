import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-asso-admin',
  templateUrl: './asso-admin.component.html',
  styleUrls: ['./asso-admin.component.scss']
})
export class AssoAdminComponent implements OnInit {
  posts : any;

  constructor(private postService : PostService ) {}

  ngOnInit(): void {
    console.log("Page chargée")
      this.postService.getTreeNextMonthPosts().subscribe(response => this.posts = response)

  }

}
