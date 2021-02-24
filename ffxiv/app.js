//list of ffxiv servers to choose from
const servers = ["Adamantoise","Aegis","Alexander","Anima","Asura","Atomos","Bahamut","Balmung","Behemoth","Belias","Brynhildr","Cactuar","Carbuncle","Cerberus","Chocobo","Coeurl","Diabolos","Durandal","Excalibur","Exodus","Faerie","Famfrit","Fenrir","Garuda","Gilgamesh","Goblin","Gungnir","Hades","Hyperion","Ifrit","Ixion","Jenova","Kujata","Lamia","Leviathan","Lich","Louisoix","Malboro","Mandragora","Masamune","Mateus","Midgardsormr","Moogle","Odin","Omega","Pandaemonium","Phoenix","Ragnarok","Ramuh","Ridill","Sargatanas","Shinryu","Shiva","Siren","Tiamat","Titan","Tonberry","Typhon","Ultima","Ultros","Unicorn","Valefor","Yojimbo","Zalera","Zeromus","Zodiark","Spriggan","Twintania","HongYuHai","ShenYiZhiDi","LaNuoXiYa","HuanYingQunDao","MengYaChi","YuZhouHeYin","WoXianXiRan","ChenXiWangZuo","BaiYinXiang","BaiJinHuanXiang","ShenQuanHen","ChaoFengTing","LvRenZhanQiao","FuXiaoZhiJian","Longchaoshendian","MengYuBaoJing","ZiShuiZhanQiao","YanXia","JingYuZhuangYuan","MoDuNa","HaiMaoChaWu","RouFengHaiWan","HuPoYuan"]
populateList();
var junction_font = new FontFace('New', 'url(fonts/FinalFantasy-aa4m.ttf)')
// // character retrieving url (used to get character ID)
// const idURL = `https://xivapi.com/character/search?name=${charName}&server=${serverName}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`

// // lodestone url; plug in ID from searched character to get more info 
// const infoURL = `https://xivapi.com/character/${charID}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`

// //title url
// const titleURL = `https://xivapi.com/title/${titleID}`

//job icon url
// https://xivapi.com/cj/1/[jobname].png
//alt job icon url
//https://xivapi.com/cj/companion/[jobname].png


//mount image? url
//https://xivapi.com/[png url]
//Name 
//Icon

//let charID = 18791259;    Daraxi
//let charID = 31646453;    Avalan


//return informtation about a specified character
const getCharacter = function()
{
    const charName = $("#searchChar").val();
    const serverName = $("#serverSelect option:selected").val();
    $.when($.ajax(`https://xivapi.com/character/search?name=${charName}&server=${serverName}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`)).then(function(data){
        let charID = data.Results[0].ID;
        $.when($.ajax(`https://xivapi.com/character/${charID}&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`)).then(function(data2)
        {
            let titleID = data2.Character.Title
            $.when($.ajax(`https://xivapi.com/title/${titleID}`)).done(function(data3,textStatus,jqXQR)
            {
                //display character name where element ID matches
                $("#charName").text(data2.Character.Name);
                //display server name where element ID matches
                $("#charServer").text(data.Results[0].Server);
                $("currentClassText").show();
                $("#currClass").text(data2.Character.ActiveClassJob.UnlockedState.Name)
                //mini portrait
                let avaURL = data2.Character.Avatar;
                //big portrait
                let portraitURL = data2.Character.Portrait;
                //job icon
                jobClass = (data2.Character.ActiveClassJob.UnlockedState.Name).toLowerCase();
                jobClass = jobClass.replace(" ", '');
                let jobURL = `https://xivapi.com/cj/companion/${jobClass}.png`;
                $("#currClassIMG").attr("src",jobURL);
                //put images in respective tags
                $("#charProfile").attr("src",avaURL); 
                $("#charPortrait").attr("src",portraitURL); 
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
                //print data to console
                console.log(data);
                console.log(data2);
                console.log(data3);
                console.log(textStatus);
                console.log(jqXQR);
            });
        })
    })
}


let getMount = function()
{
    const mountID= $("#searchMount").val();

    $.get(`https://xivapi.com/mount/${mountID}?private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea`, function(data, textStatus, jqXQR)
    {
        mountURL = `https://xivapi.com${data.Icon}`
        $("#mountDesc").text(data.DescriptionEnhanced); 
        $("#mountPic").attr("src",mountURL);    
    }
    );


}

let getMount2 = function()
{
    const mountID= $("#searchMount").val();

    $.get(`https://xivapi.com/mount?columns=Name&private_key=054354dfd01b48cfb6d88493e6ba759952ec9f0201724b709622e3bad27bbeea
    `, function(data, textStatus, jqXQR)
    {
        mountURL = `https://xivapi.com${data.Icon}`
        $("#mountDesc").text(data.DescriptionEnhanced); 
        $("#mountPic").attr("src",mountURL);    
    }
    );


}


// POPULATE MY SERVER SELECTION FROM JSON
function populateList()
{
    const selectList = document.getElementById("serverSelect");
    for(let i = 0; i<servers.length;i++)
    {
        var option = document.createElement("option")
        option.textContent = servers[i];
        option.value = servers[i];
        selectList.appendChild(option);
    }

}





