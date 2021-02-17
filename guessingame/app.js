let numToGuess = generateNum();

checkGuess()
{
    //if a number matches and is in the right position display green bg
    //if a number matches and is in the wrong position display yellow bg 
    //if a number doesn't match at all red bg 

}



//generate a 4 digit number with all unique digits  
function generateNum()
{
   let newNum = Math.floor(Math.random()*(9999-1000))+1000;
   console.log(newNum);
   return newNum;
}


function reset()
{
    generateNum();
}