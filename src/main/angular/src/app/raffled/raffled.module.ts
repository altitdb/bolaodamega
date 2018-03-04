import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RaffledComponent } from './raffled.component';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RaffledService } from "./raffled.service";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FlexLayoutModule } from "@angular/flex-layout";

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatTableModule,
    MatButtonModule,
    MatCardModule
  ],
  providers: [
    RaffledService
  ],
  declarations: [RaffledComponent],
  exports: [RaffledComponent]
})
export class RaffledModule { }
