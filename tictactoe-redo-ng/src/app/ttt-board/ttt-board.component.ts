import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ttt-board',
  templateUrl: './ttt-board.component.html',
  styleUrls: ['./ttt-board.component.css']
})
export class TttBoardComponent implements OnInit {

  isXTurn: boolean;
  board: string[];
  constructor() { }

  ngOnInit(): void {
  }


}
