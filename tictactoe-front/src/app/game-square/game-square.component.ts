import { Component, Input, OnInit } from '@angular/core';
import {Output, EventEmitter } from '@angular/core';
import { Board } from '../tictactoe/Board'
import { Position } from '../tictactoe/Position'
import { Player, PlayerToken } from '../tictactoe/Player'


@Component({
  selector: 'game-square',
  templateUrl: './game-square.component.html',
  styleUrls: ['./game-square.component.css']
})
export class GameSquareComponent implements OnInit {

  imgSrc: string = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg=="
  @Output() spotClickEvent: EventEmitter<Position> = new EventEmitter<Position>();
  @Input() row: number=0;
  @Input() col: number=0;
  @Input() tokenPiece : Player;
  // this.imgSrc = "./assets/LetterX.png"
  // this.imgSrc = "./assets/LetterO.png"
  
  constructor() { }

  ngOnInit(): void {
    if(this.tokenPiece===null)
    {
      this.imgSrc += "";
    }
    else{
      this.imgSrc = this.tokenPiece.isX ? "./assets/LetterX.png" : "./assets/LetterO.png";
    }
  }

  spotClicked() : void
  {
    this.spotClickEvent.emit(
      {
        row: this.row,
        col: this.col
      }
    )
  }
    
}
