import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Entrypoints} from "./entrypoints";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class RestService {

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) {

  }

  private static extractData(res: Response) {
    return res || { };
  }

  signIn(): Observable<any> {
    return this.http.get(Entrypoints.SIGN_IN).pipe(
      map(RestService.extractData));
  }
}
