import { convertToParamMap } from "@angular/router";
import{Player} from "./Player";
import{Position} from "./Position";
import{Move} from "./Move";

export interface Board{
    isXturn: boolean
    squares: Player[][];
    nineMoves: number;
    chooseSpot : (this: Board, toMake: Move) => Board;
}

export class TTTBoard implements Board{
    isXturn: boolean=true;
    nineMoves: number=0;
    squares: Player[][];

    constructor(copyFrom?: TTTBoard)
    {
        if(copyFrom)
        {
            this.buildFrom(copyFrom);
        }
        //create a new board
        else{
            this.squares = [];
            for(let row = 0; row < 3; row++)
            {
                this.squares[row] = [];
                for(let col = 0; col < 3; col++)
                {
                    this.squares[row][col]=null;
                }
            }
        }

    }

    buildFrom(toCopy:Board)
    {
        this.squares=[];
        for(let i=0; i< toCopy.squares.length;i++)
        {
            this.squares.push([...toCopy.squares[i]]);
        }
    }

    chooseSpot: (toMake:Move) => Board = toMake =>{
     let nextBoard: TTTBoard = new TTTBoard(this);

     if(this.nineMoves <10)
     {
         nextBoard.squares
         nextBoard.isXturn = !this.isXturn;
     }
     return nextBoard;   

    }
} 