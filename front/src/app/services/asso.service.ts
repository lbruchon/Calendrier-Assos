import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Association} from "../../models/association.model";

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

  // A appeler lors du bouton edit dans le composant edit-asso
  // editAssociation(id: Number): Observable<Association> {
  //   return this.http.patch<Association>(`${this.url}/associations/${id}`, id);
  // }

  // A appeler lors du bouton edit dans le composant delete-asso
  deleteAssociation(id: Number): Observable<Association> {
    return this.http.delete<Association>(`${this.url}/associations/${id}`);
  }

}
