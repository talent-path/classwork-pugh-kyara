let numToGuess = generateNum();

function checkGuess(guessedNum)
{
    
    //if a number matches and is in the right position display green bg
    //if a number matches and is in the wrong position display yellow bg 
    //if a number doesn't match at all red bg 

}

//fill boxes with the numbers entered by the guesser
function fillBoxes()
{

    
}

//if all the numbers are guessed correctly
function allGreen()
{

}


//generate a 4 digit number with all unique digits  
function generateNum()
{
    let numArr = [null, null, null, null];
    let newNum = Number.MIN_VALUE;
    let i = 0
    //until all nulls are gone
    while(numArr.includes(null))
    {
        //generate a number 1 through 9
        newNum = Math.floor(Math.random()*8)+1;
        //add that number if that digit isn't in the array
        if(!numArr.includes(newNum))
        {
            numArr[i]= newNum
            i++;
        }
    }
    //joins all elements of the array
    let guessNum = numArr.join('');
    //changes the string to a number
    guessNum = parseInt(guessNum);
    return guessNum;
}


//reset this game
function reset()
{
    numToGuess = generateNum();
}