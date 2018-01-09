import { Component } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/of';
import { Observable } from 'rxjs/Observable';
import { DataSource } from "@angular/cdk/table";

export interface Data {}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Bolão da Mega';
  displayedColumns = ['description', 'value', 'lastUpdate'];
  data: Array<any>;
  dataSource: StatisticsDataSource;
  private apiUrl = 'http://localhost:8080/api/statistics';

  constructor(private http: Http) {
    this.getData();
  }

  getData() {
    return this.http.get(this.apiUrl).map(response => response.json())
      .subscribe(res => {
        this.data = res;
        this.dataSource = new StatisticsDataSource(this.data);
      });
  }

}

export class StatisticsDataSource extends DataSource<any> {

  constructor(private data: Data[]) {
    super();
  }

  connect(): Observable<Data[]> {
    return Observable.of(this.data);
  }

  disconnect() {}

}