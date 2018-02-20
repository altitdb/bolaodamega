import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from "@angular/material/table";
import { RaffledService } from "./raffled.service";
import { Game } from "../model/models";

@Component({
  selector: 'app-raffled',
  templateUrl: './raffled.component.html',
  styleUrls: ['./raffled.component.scss']
})
export class RaffledComponent implements OnInit {

  displayedColumns = ['column01', 'column02', 'column03', 'column04', 'column05', 'column06', 'column07', 'column08', 'column09', 'column10'];
  dataSource = new MatTableDataSource<Element>(ELEMENT_DATA);
  game: Game = null;
  gameNumber: string;
  tenderNumber: number;
  raffledGame: number[] = [];
  constructor(private _raffledService: RaffledService) { }

  ngOnInit() {
    this._raffledService.findLastGame().subscribe(suc => {
      this.game = suc.game;
      this.tenderNumber = suc.tenderNumber;
      this.formatGameNumber();
    });
  }

  verify(number) {
    return this.raffledGame.includes(Number(number));
  }

  formatGameNumber() {
    this.gameNumber = this.game.number01 + ' - ' + this.game.number02 + ' - ' + this.game.number03 + ' - ' + this.game.number04 + ' - ' + this.game.number05 + ' - ' + this.game.number06;
    this.raffledGame = [];
    this.raffledGame.push(this.game.number01);
    this.raffledGame.push(this.game.number02);
    this.raffledGame.push(this.game.number03);
    this.raffledGame.push(this.game.number04);
    this.raffledGame.push(this.game.number05);
    this.raffledGame.push(this.game.number06);
  }

  previous(tenderNumber) {
    this._raffledService.findPreviousGame(tenderNumber).subscribe(suc => {
      this.game = suc.game;
      this.tenderNumber = suc.tenderNumber;
      this.formatGameNumber();
    });
  }

  next(tenderNumber) {
    this._raffledService.findNextGame(tenderNumber).subscribe(suc => {
      this.game = suc.game;
      this.tenderNumber = suc.tenderNumber;
      this.formatGameNumber();
    });
  }

}

export interface Element {
  column01: string;
  column02: string;
  column03: string;
  column04: string;
  column05: string;
  column06: string;
  column07: string;
  column08: string;
  column09: string;
  column10: string;
}

const ELEMENT_DATA: Element[] = [
  {column01: '01', column02: '02', column03: '03', column04: '04', column05: '05', column06: '06', column07: '07', column08: '08', column09: '09', column10: '10'},
  {column01: '11', column02: '12', column03: '13', column04: '14', column05: '15', column06: '16', column07: '17', column08: '18', column09: '19', column10: '20'},
  {column01: '21', column02: '22', column03: '23', column04: '24', column05: '25', column06: '26', column07: '27', column08: '28', column09: '29', column10: '30'},
  {column01: '31', column02: '32', column03: '33', column04: '34', column05: '35', column06: '36', column07: '37', column08: '38', column09: '39', column10: '40'},
  {column01: '41', column02: '42', column03: '43', column04: '44', column05: '45', column06: '46', column07: '47', column08: '48', column09: '49', column10: '50'},
  {column01: '51', column02: '52', column03: '53', column04: '54', column05: '55', column06: '56', column07: '57', column08: '58', column09: '59', column10: '60'}
];