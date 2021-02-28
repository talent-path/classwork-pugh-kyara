import { convertToParamMap } from "@angular/router";
import{Player, PlayerToken} from "./Player";
import{Position} from "./Position";
import{Move} from "./Move";

export interface Board{
    isXturn: boolean
    squares: Player[][];
    nineMoves: number;
    chooseSpot : (this: Board, toMake: Move) => Board;
    tokenAt: (spot: Position) => Player;
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

        //create a new board with 9 null spaces
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

    //copy a game that already exists
    buildFrom(toCopy:Board)
    {
        this.squares=[];
        for(let i=0; i< toCopy.squares.length;i++)
        {
            this.squares.push([...toCopy.squares[i]]);
        }
    }

    // player chooses a spot
    chooseSpot: (toMake:Move) => Board = toMake =>{
     let nextBoard: TTTBoard = new TTTBoard(this);

     if(this.nineMoves <10)
     {
         nextBoard.squares[toMake.to.row][toMake.to.col] = this.isXturn ? {token: PlayerToken.X, isX: true} : {token: PlayerToken.O, isX: false};
         nextBoard.isXturn = !this.isXturn;
     }
     else{
         console.log("The game is a tie!");
     }
     return nextBoard;   

    }

    tokenAt (spot: Position) : Player
    {
        return this.squares[spot.row][spot.col];

    }

} 