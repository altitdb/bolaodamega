import { Injectable } from '@angular/core';
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RaffledService {

  private urlRaffledLast = environment.url + '/api/v1/raffled/last';
  private urlRaffledNext = environment.url + '/api/v1/raffled/next/';
  private urlRaffledPrevious = environment.url + '/api/v1/raffled/previous/';

  constructor(private _httpClient: HttpClient) { }

  findLastGame() {
    return this._httpClient.get<Raffled>(this.urlRaffledLast);
  }

  findPreviousGame(tenderNumber) {
    return this._httpClient.get<Raffled>(this.urlRaffledPrevious + tenderNumber);
  }

  findNextGame(tenderNumber) {
    return this._httpClient.get<Raffled>(this.urlRaffledNext + tenderNumber);
  }
}

export interface Raffled {
  tenderNumber: number;
  game: Game;
}

export interface Game {
  number01: number;
  number02: number;
  number03: number;
  number04: number;
  number05: number;
  number06: number;
}