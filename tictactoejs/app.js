//X goes first
let player = 'X';
//initiating our array with all null
let arr = [null, null, null, null, null, null, null, null, null];


//pass in the button ID to choose a space
function chooseSpace(button) {
         //display the proper image depending on who went
    if(player === 'X') {
        button.style.background = "url('https://cdn.pixabay.com/photo/2012/04/12/20/12/x-30465_1280.png')";
        arr[Number(button.id)-1] = player;
        player = 'O';
    } else {
        button.style.background = "url('https://assets.ltkcontent.com/images/20093/3747.LetterO_0066f46bde.jpg')";
        arr[Number(button.id)-1] = player;
        player = 'X';
    }
    button.style.backgroundSize = "cover";
    button.disabled = true;


    //check for a player win
    if(arr.includes('X') || arr.includes('O')) {
        if(checkForWin()) {
            if(player === 'X') alert("Player 2 wins");
            else alert("Player 1 wins");
            disableButtons();
        }
    }
    if(!arr.includes(null))
    {
        alert("There's a tie!");
    }
    
}

//checking the win of all types
function checkForWin() {
    return checkRows() || checkColumns() || checkDiagonals();
}



function checkRows() {
    for(let i = 0; i < 9; i+=3) {
        if(arr[i] === arr[i+1] && arr[i+1] === arr[i+2] && arr[i] !== null) {
            return true;
        }
    }
    return false;
}

function checkColumns() {
    for(let i = 0; i < 3; i++) {
        if(arr[i] === arr[i+3] && arr[i+3] === arr[i+6] && arr[i] !== null) {
            return true;
        }
    }
    return false;
}

function checkDiagonals() {
    return ((arr[0] === arr[4] && arr[4] === arr[8] || arr[2] === arr[4] && arr[4] === arr[6]) &&  arr[4] !== null);
}

//disable all buttons after a win
function disableButtons() {
    for(let i = 1; i < 10; i++) {
        const button = document.getElementById(i);
        button.disabled = true;
    }
}

//enable buttons again
function enableButtons() 
{
    for(let i = 1; i<10;i++)
    {
        const button = document.getElementById(i);
        button.disabled = false;
        button.style.background = "none";
    }
}


function resetGame()
{
    player = 'X';
    //initiating our array with all null
    arr = [null, null, null, null, null, null, null, null, null];       
    enableButtons();
}
