import { convertToParamMap } from "@angular/router";
import{Player, PlayerToken} from "./Player";
import{Position} from "./Position";

export interface Board{
    isXturn: boolean
    squares: Player[][];
    nineMoves: number;
    gameOver: boolean;
    chooseSpot : (this: Board, loc: Position) => Board;
    tokenAt: (spot: Position) => Player;
}

export class TTTBoard implements Board{
    isXturn: boolean=true;
    gameOver: boolean = false;
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
    chooseSpot: (loc:Position) => Board = loc =>{
     let nextBoard: TTTBoard = new TTTBoard(this);
     if(this.nineMoves < 10 )
     {
         nextBoard.squares[loc.row][loc.col] = this.isXturn ? {token: PlayerToken.X, isX: true} : {token: PlayerToken.O, isX: false};
         this.gameOver = nextBoard.hasWon();
         nextBoard.isXturn = !this.isXturn;
     }
     else{
         console.log("The game is a tie!");
     }
     return nextBoard;   

    }

    hasWon(): boolean
    {
        if(this.checkRows()||this.checkCols()||this.checkDiags())
        {
            return true;
        }
        else{
            return false;
        }
    }

    checkRows() : boolean
    {
        
        return false;
        
    }

    checkCols() : boolean {
    
        return false;

    }

    checkDiags() : boolean
    {
    
        return false;
    }

    tokenAt (spot: Position) : Player
    {
        return this.squares[spot.row][spot.col];

    }

} 