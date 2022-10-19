//member.service.ts
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Member} from "../../models/member.model";
import {User} from "../../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

  getConnectedMember(email : String, mdp : String) {
    return this.http.get<any>(`${this.url}/members/connexion/${email}/${mdp}`);
  }
}
