import { Component, OnInit } from '@angular/core';
import { Board, TTTBoard } from '../tictactoe/Board'
import { Position } from '../tictactoe/Position';
import { Player } from '../tictactoe/Player';


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
    console.log(this.board.isXturn);
    let spotAtPos: Player = this.board.tokenAt(spot);
    //if the spot is empty makae thst the spot selected
    if(spotAtPos === null)
    {
      if(this.board.isXturn || !this.board.isXturn)
      {
        this.spotSelected = spot;
      }
    }
    //else there is another character there
    //we cannot choose that spot
    else
    {
      console.log("Cannot move to a spot that's taken!")
     this.spotSelected = null; 
    }
    //update the board
    this.board = this.board.chooseSpot(this.spotSelected);
    console.log(this.spotSelected);
    console.log(this.board.tokenAt(this.spotSelected));


    
  }

}
