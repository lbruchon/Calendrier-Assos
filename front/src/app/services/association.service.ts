import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AssociationService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = environment.url;
  }

}
