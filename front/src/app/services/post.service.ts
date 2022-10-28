import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Association} from "../../models/association.model";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  addPost(post: Post): Observable<Post> {

    return this.http.post<Post>(`${this.url}/posts/add-post`, association);
  }

  getPost() {
    return this.http.get<Post[]>(`${this.url}/associations`);
  }

}
