import { Component, Input, OnInit } from '@angular/core';
import {Output, EventEmitter } from '@angular/core';
import { TicTacToeGame } from '../tictactoe/tictactoe'


@Component({
  selector: 'game-square',
  templateUrl: './game-square.component.html',
  styleUrls: ['./game-square.component.css']
})
export class GameSquareComponent implements OnInit {

  imgSrc: string = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg=="
  @Output() spotClickEvent: EventEmitter<number> = new EventEmitter<number>();
  @Input() spot: number;
  @Input() squareInput: string;
  @Input() isXTurn : boolean;
  // this.imgSrc = "./assets/LetterX.png"
  // this.imgSrc = "./assets/LetterO.png"
  
  constructor() { }

  ngOnInit(): void {
  }

  onClick() : void
  {
    console.log(this.squareInput);
    if(this.squareInput === null)
    {
          if(this.isXTurn)
        {
          this.spotClickEvent.emit(this.spot)
          this.imgSrc = "./assets/LetterX.png"
        }
        else
        {
          this.spotClickEvent.emit(this.spot)
          this.imgSrc = "./assets/LetterO.png"
        }

      } 
    }  
}
