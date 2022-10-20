import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/models/post.model';
import { PostService } from '../services/post.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {
posts : any;

  constructor( private postService : PostService, private router: Router) {
  }

  ngOnInit(): void {
    console.log("Page chargée")
      this.postService.getTreeNextMonthPosts().subscribe(response => this.posts = response)

  }
  ToPageConnect() {
    let url = "https://www.google.fr";
    this.router.navigate(['/connexion']);

}


}
