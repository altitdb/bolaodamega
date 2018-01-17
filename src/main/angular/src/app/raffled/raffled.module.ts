import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RaffledComponent } from './raffled.component';
import { MatTableModule } from "@angular/material/table";

@NgModule({
  imports: [
    CommonModule,
    MatTableModule
  ],
  declarations: [RaffledComponent],
  exports: [RaffledComponent]
})
export class RaffledModule { }
