let numToGuess = generateNum();


function checkGuess()
{
    let guessedNum = document.getElementById("guessField").value;
    //change the guess number to an array and store into a new variable
    let numToArr = Array.from(String(guessedNum),Number)
    console.log(guessedNum);
    console.log(numToArr);
    fillBoxes(guessedNum);
    
    for(let i=0;i<4;i++)
    {
        //if a number matches and is in the right position display green bg
        if(numToGuess[i]===numToArr[i])
        {
            document.getElementById("box"+(i+1)).style.backgroundColor = "green";
        }
         //if a number matches and is in the wrong position display yellow bg 
        else if((numToGuess[i]!==numToArr[i])&&numToGuess.includes(numToArr[i]))
        {
            document.getElementById("box"+(i+1)).style.backgroundColor  = "yellow";

        }
        //if a number doesn't match at all red bg 
        else
        {
            document.getElementById("box"+(i+1)).style.backgroundColor = "red";

        }

    }
    //if all the numbers are guessed correctly
    if(allGreen(numToArr))
    {
        alert("You guessed the number!");
    }
}

//fill boxes with the numbers entered by the guesses
function fillBoxes(guessedNum)
{
    document.getElementById("box1").innerText = Math.floor(Math.floor(guessedNum/1000));
    document.getElementById("box2").innerText = Math.floor(guessedNum%1000/100);
    document.getElementById("box3").innerText = Math.floor(guessedNum%100/10);
    document.getElementById("box4").innerText = Math.floor(guessedNum%10);

}

//if all the numbers are guessed correctly
function allGreen(numberArray)
{
    for(let i = 0;i<4;i++)
    {
        if(numberArray[i]!==numToGuess[i])
        {
            return false;
        }
    }

    return true;
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
    //console.log(numArr);
    //joins all elements of the array
    //let guessNum = numArr.join('');
    //changes the string to a number
    //guessNum = parseInt(guessNum);
    //return guessNum;
    return numArr;
}


//reset this game
function reset()
{
    numToGuess = generateNum();
}