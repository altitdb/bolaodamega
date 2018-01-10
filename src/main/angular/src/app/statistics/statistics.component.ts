import { Component, OnInit } from '@angular/core';
import { StatisticsService } from "./statistics.service";
import { MatTableDataSource } from "@angular/material/table";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.scss']
})
export class StatisticsComponent implements OnInit {

  displayedColumns = ['description', 'value', 'lastUpdate'];
  dataSource: MatTableDataSource<any>;

  constructor(private statisticsService: StatisticsService) {
  }

  ngOnInit() {
    this.statisticsService.getAll().subscribe(suc => {
      this.dataSource = new MatTableDataSource(suc);
    });
  }

}