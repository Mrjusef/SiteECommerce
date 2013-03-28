function tester(frm){
var Count = frm.elements['choix[]'].length;
var test   = false;
var i;
for(i = 0; i < Count; i++){
if(frm.elements['choix[]'][i].checked){
test = true;
break;
}
}

if(!test){
alert('Veuillez d\'abord effectuer une sélection dans la liste');
}
return test;
}


// croché et décroche tous les checkbox


function Check()
{
var i;
var Count = document.lister.elements['choix[]'].length;
if(document.lister.tous.checked==true){
for (i = 0; i < Count; i++)
document.lister.elements['choix[]'][i].checked = true ;

}else{

for (i = 0; i < Count; i++)
document.lister.elements['choix[]'][i].checked = false ;
}
}

// Colorier le td 

function colorier(quoi)
    {    if ( quoi.checked )
                quoi.parentNode.parentNode.style.backgroundColor="#C3D9E0";
        else    quoi.parentNode.parentNode.style.backgroundColor="transparent";
    }

//----------------------------------

function colorertous()
{
var i;
var Count = document.lister.elements['choix[]'].length;
if(document.lister.tous.checked==true){
for (i = 0; i < Count; i++)
document.lister.elements['choix[]'][i].parentNode.parentNode.style.backgroundColor="#C3D9E0";

}else{

for (i = 0; i < Count; i++)
document.lister.elements['choix[]'][i].parentNode.parentNode.style.backgroundColor="transparent";
}
}
