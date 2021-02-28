import { Component, OnInit } from '@angular/core';
import { Board, TTTBoard } from '../tictactoe/Board'
import { Position } from '../tictactoe/Position';
import { Move } from '../tictactoe/Move';
import { Player, PlayerToken } from '../tictactoe/Player';


@Component({
  selector: 'game-board',
  templateUrl: './game-board.component.html',
  styleUrls: ['./game-board.component.css']
})
export class GameBoardComponent implements OnInit {

  board: Board = new TTTBoard();
  spotSelected: Position = null;
 
  constructor() { }

  ngOnInit(): void {
  }

  onSpotClicked(spot:Position):void{
    let spotAtPos: Player = this.board.tokenAt(spot);
    if(spotAtPos !==null)
    {
      if(this.board.isXturn || !this.board.isXturn)
      {
        this.spotSelected = spot;
      }
    }
    else
    {
     this.spotSelected = null; 
    }

  }

}
