import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

import { from, Observable, of, take, tap } from 'rxjs';
import { Post } from "src/models/post.model";
import { Tag } from "src/models/tag.model";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url: string;
private result: Post[] = []
  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  getPosts() {
    return this.http.get<Post[]>(`${this.url}/posts`)
  }

  getTreeNextMonthPosts() {
    return this.http.get<Post[]>(`${this.url}/posts/threeNextMonthPosts`)
  }

  getTagNameIdPost(id: Int16Array) {
    console.log(`${this.url}/posts/TagPost/${id}`);
    return this.http.get<Tag>(`${this.url}/posts/TagPost/${id}`);
  }

  deletePost(id: Number) : Observable<Post>{
    console.log("on delete", id)
    console.log(`${this.url}/posts/${id}`)
    return this.http.delete<Post>(`${this.url}/posts/${id}`);

  }

  updatePost(post: Post): Observable<Post> {
    return this.http.put<Post>(`${this.url}/posts/${post.id}`, post);
  }
}
