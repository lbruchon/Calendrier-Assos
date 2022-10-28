import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { Tag } from "src/models/tag.model";

@Injectable({
  providedIn: 'root'
})
export class TagService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  getTags(){
    return this.http.get<Tag[]>(`${this.url}/tags`)
  }

}
