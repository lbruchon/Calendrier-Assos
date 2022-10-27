import { Component, OnInit } from '@angular/core';
import { AssoService } from 'src/app/services/asso.service';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-asso-admin',
  templateUrl: './asso-admin.component.html',
  styleUrls: ['./asso-admin.component.scss']
})
export class AssoAdminComponent implements OnInit {
  posts : any;

  constructor(private postService : PostService, private assoService : AssoService ) {}

  ngOnInit(): void {
    console.log("Page chargée")

      this.assoService.getAllPostOfAnAsso(4).subscribe(response => this.posts = response)

  }

}
