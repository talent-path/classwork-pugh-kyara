let numToGuess = generateNum();

function checkGuess()
{
    let guessedNum = document.getElementById("guessField").value;
    console.log(guessedNum);
    fillBoxes(guessedNum);
    
    //if a number matches and is in the right position display green bg

    document.getElementById("box1").style.backgroundColor = "green";

    //if a number matches and is in the wrong position display yellow bg 
    document.getElementById("box3").style.backgroundColor  = "yellow";

    //if a number doesn't match at all red bg 
    document.getElementById("box2").style.backgroundColor = "red";


}

//fill boxes with the numbers entered by the guesser
function fillBoxes(guessedNum)
{
    document.getElementById("box1").innerText = Math.floor(Math.floor(guessedNum/1000));
    document.getElementById("box2").innerText = Math.floor(guessedNum%1000/100);
    document.getElementById("box3").innerText = Math.floor(guessedNum%100/10);
    document.getElementById("box4").innerText = Math.floor(guessedNum%10);

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
    console.log(numArr);
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