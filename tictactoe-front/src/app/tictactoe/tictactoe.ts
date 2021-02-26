export class TicTacToeGame {
    // X starts first
    player: string = "X";
    isXTurn: boolean = true;
    board: string[] = [];
    moveCount: number = 0;

        constructor(copyFrom?:TicTacToeGame)
        {
            //if there's a game to copt from copy it
            if(copyFrom){
                this.buildFrom(copyFrom);
            }
            //else initialize a new gameboard
            else
            {
                this.board=[];
                for(let i = 0; i<9;i++)
                {
                    this.board.push(null);
                }
            }

        }
        
        buildFrom( toCopy : TicTacToeGame ) {
        
            this.board = [];
            for(let i = 0; i<toCopy.board.length;i++)
            {
                this.board.push(...[toCopy.board[i]])
            }
          
        }
        
        chooseSpace(space: number): void {
            if(this.moveCount<10)
            {
            this.board[space] = this.player;
            this.moveCount++;
            this.isXTurn = !this.isXTurn;
            this.player = this.isXTurn ? "X": "O";
            }
            else{
                console.log("game is a tie!")
            }
        
        }
    }
