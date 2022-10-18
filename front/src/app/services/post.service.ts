import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import { Post } from "src/models/post.model";
import { Tag } from "src/models/tag.model";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  // getPosts(): Array<Post> {
  //   let ListPosts :Array<Post>  = []

  //   fetch('http://localhost:8080/posts')
  //    .then(function(response) {
  //      return response.json();
  //    })
  //    .then(function(myJson) {
  //     const result = JSON.parse(
  //       JSON.stringify(Object.assign({}, myJson))
  //     )
  //     ListPosts=myJson

  //   console.log("list post ok")
  //    });
  //    console.log(ListPosts)
  //   return ListPosts
  // }



}
