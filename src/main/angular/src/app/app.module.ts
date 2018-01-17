import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StatisticsModule } from "./statistics/statistics.module";
import { RaffledModule } from "./raffled/raffled.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    StatisticsModule,
    RaffledModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }