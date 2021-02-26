import { Component, OnInit } from '@angular/core';
import { TicTacToeGame } from '../tictactoe/tictactoe'

@Component({
  selector: 'game-board',
  templateUrl: './game-board.component.html',
  styleUrls: ['./game-board.component.css']
})
export class GameBoardComponent implements OnInit {

  board: TicTacToeGame = new TicTacToeGame();

 
  constructor() { }

  ngOnInit(): void {
  }

  onSpotClicked(spot:number):void
  {
    console.log(spot);
    console.log(this.board.isXTurn);
    let someSpot = this.board.board[spot];
    //if the spot click is empty that is the new chosen spot
    if(!someSpot)
    {
        // this.board.board[spot] = this.board.isXTurn ? "X" : "O";
        this.board.chooseSpace(spot)    
    }  
  }

}
