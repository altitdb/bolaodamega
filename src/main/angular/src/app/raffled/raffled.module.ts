import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RaffledComponent } from './raffled.component';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { RaffledService } from "./raffled.service";

@NgModule({
  imports: [
    CommonModule,
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
