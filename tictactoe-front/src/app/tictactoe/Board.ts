import { convertToParamMap } from "@angular/router";
import{Player, PlayerToken} from "./Player";
import{Position} from "./Position";

export interface Board{
    isXturn: boolean
    squares: Player[][];
    nineMoves: number;
    chooseSpot : (this: Board, loc: Position) => Board;
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
    chooseSpot: (loc:Position) => Board = loc =>{
     let nextBoard: TTTBoard = new TTTBoard(this);

     if(this.nineMoves <10 || (this.squares[loc.row][loc.col]===null && !this.hasWon()) )
     {
         nextBoard.squares[loc.row][loc.col] = this.isXturn ? {token: PlayerToken.X, isX: true} : {token: PlayerToken.O, isX: false};
         nextBoard.hasWon();
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
        for(let i=0; i < 3; i++)
        {
            let rowTotal = this.squares[i][0].token + this.squares[i][1].token + this.squares[i][3].token;
            if(rowTotal===0 || rowTotal === 3)
            {
                return true;
            }
        }
        return false;
        
    }

    checkCols() : boolean {
        for(let i=0; i < 3; i++)
        {
            let colTotal = this.squares[0][1].token + this.squares[1][i].token + this.squares[2][i].token;
            if(colTotal===0 || colTotal === 3)
            {
                return true;
            }
        }
        return false;

    }

    checkDiags() : boolean
    {
        let diag1 = this.squares[0][0].token + this.squares[1][1].token + this.squares[2][2].token;
        let diag2 = this.squares[0][2].token + this.squares[1][1].token + this.squares[2][0].token;
        if(diag1===0||diag1===3||diag2===0||diag2===3)
        {
            return true;
        }
        return false;
    }

    tokenAt (spot: Position) : Player
    {
        return this.squares[spot.row][spot.col];

    }

} 