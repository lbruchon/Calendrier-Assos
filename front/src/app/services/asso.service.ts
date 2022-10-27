import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Association} from "../../models/association.model";
import { Post } from "src/models/post.model";

@Injectable({
  providedIn: 'root'
})
export class AssoService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  addAssociation(association: Association): Observable<Association> {
    return this.http.post<Association>(`${this.url}/associations/add-asso`, association);
  }

  getAssos() {
    return this.http.get<Association[]>(`${this.url}/associations`);
  }

  getAsso(id: Number) {
    return this.http.get<Association>(`${this.url}/associations/edit-asso/${id}`);
  }

  getAllPostOfAnAssoByMemberId(id: Number){
    return this.http.get<Post>(`${this.url}/associations/AllPostOfOneAssoByIdMember/${id}`);
  }

  updateAssociation(association: Association): Observable<Association> {
    return this.http.put<Association>(`${this.url}/associations/${association.id}`, association);
  }

  deleteAssociation(id: Number): Observable<Association> {
    return this.http.delete<Association>(`${this.url}/associations/${id}`);
  }

}
