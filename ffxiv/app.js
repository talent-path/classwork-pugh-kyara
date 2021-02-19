
// // character retrieving url (used to get character ID)

// const idURL = `https://xivapi.com/character/search?name=${charName}&server=${serverName}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`

// // lodestone url; plug in ID from searched character to get more info 

// const infoURL = `https://xivapi.com/character/${charID}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`

// //title url
// const titleURL = `https://xivapi.com/title/${titleID}`

//let charID = 18791259;    Daraxi
//let charID = 31646453;    Avalan


//return informtation about a specified character
const getCharacter = function()
{
    const charName = $("#searchChar").val();
    const serverName = $("#serverSelect option:selected").val();
    //get the ID of the character first
    $.get(`https://xivapi.com/character/search?name=${charName}&server=${serverName}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`,function(data,textStatus,jqXQR)
    {
        //print data to console
            console.log(data);
            console.log(textStatus);
            console.log(jqXQR);
            let charID = data.Results[0].ID;
        // //search the character ID on the lodestone url
        $.get(`https://xivapi.com/character/${charID}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`,function(data2,textStatus,jqXQR)
        {
            //display character name where element ID matches
            $("#charName").text(data2.Character.Name);
            //display server name where element ID matches
            $("#charServer").text(data2.Character.Server);
            //mini portrait
            let avaURL = data2.Character.Avatar;
            //big portrait
            let portraitURL = data2.Character.Portrait;

            //get player title
            let titleID = data2.Character.Title;
            $.get(`https://xivapi.com/title/${titleID}`, function(data3, textStatus, jqXQR)
            {
                //display character title where element ID matches
                if(data3.IsPrefix===1)
                {
                    $("#charTitlePrefix").text(data3.Name);
                    $("#charTitleSuffix").text("");
                }
                else if(data3.IsPrefix===0)
                {
                    $("#charTitlePrefix").text("");
                    $("#charTitleSuffix").text(data3.Name);

                }
            }
            );
            //put images in respective tags
            $("#charProfile").attr("src",avaURL); 
            $("#charPortrait").attr("src",portraitURL); 
            //print data to console
            console.log(data2);
            console.log(textStatus);
            console.log(jqXQR);
        }
        );
        
        
    }
    );
}


// //gets a title Name by the ID
// function getTitle(titleID)
// {
//     $.get(`https://xivapi.com/title/${titleID}`, function(data,textStatus,jqXQR)
//     {
//         if(data.IsPrefix===1)
//         {
//             $("#charTitlePrefix").text(data.Name);
//             $("#charTitleSuffix").text("");


//         }
//         else if(data.IsPrefix===0)
//         {
//             $("#charTitlePrefix").text("");
//             $("#charTitleSuffix").text(data.Name);

//         }
//         console.log(data.Name);
//     }
//     );
// }



//POPULATE MY SERVER SELECTION FROM JSON
// function populateList()
// {
//     const selectList = document.getElementById("serverSelect");
//     for()
//     {

//     }

// }





