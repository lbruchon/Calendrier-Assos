import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Post } from 'src/models/post.model';
import { PostService } from '../services/post.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {
posts : Post[];
  constructor(private http: HttpClient, private postService : PostService) {
    this.posts=[];
  }

  ngOnInit(): void {
    console.log("Page chargée")



  }

}
