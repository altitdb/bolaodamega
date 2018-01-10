import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from "../../environments/environment";
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StatisticsService {

  private url = environment.url + '/api/statistics';
  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Array<Object>>(this.url);
  }
}
