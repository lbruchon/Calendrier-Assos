import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import { Association } from "src/models/association.model";

@Injectable({
    providedIn: 'root'
  })
  export class AssoService {
    private url: string;

    constructor(private http: HttpClient) {
        this.url = environment.url;
    }

    // getAssos(): Observable<Association[]> {
    //   console.log(this.http.get<Association[]>(`${this.url}/associations`+"Object Get dans le service"));
    //   // console.log(this.http.get<Association[]>(`${this.url}/associations`+"Object Get dans le service"));
    //   // console.log("Get association");
    //   return this.http.get<Association[]>(`${this.url}/associations`);
    // }

    getAssos() {
      return this.http.get<Association[]>(`${this.url}/associations`);
    }

  }