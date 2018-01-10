import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatisticsComponent } from './statistics.component';
import { MatTableModule } from '@angular/material/table';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { StatisticsService } from "./statistics.service";

@NgModule({
  imports: [
    CommonModule,
    MatTableModule,
    HttpClientModule
  ],
  providers: [
    HttpClient,
    StatisticsService
  ],
  declarations: [StatisticsComponent],
  exports: [StatisticsComponent]
})
export class StatisticsModule { }
