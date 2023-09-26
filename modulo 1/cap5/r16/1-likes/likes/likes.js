let votosMinecraft=0;
let votosRoblox=0;

let valorMinecraft;
let valorRoblox;
sumarLikeMinecraft=function(){
valorMinecraft= document.getElementById("lblMinecraft");
votosMinecraft=parseInt(valorMinecraft.innerText)+1;
valorMinecraft.innerText=votosMinecraft;

}
sumarCorazonMinecraft=function(){
    valorMinecraft= document.getElementById("lblMinecraft");
    votosMinecraft=parseInt(valorMinecraft.innerText)+5;
    valorMinecraft.innerText=votosMinecraft;
}
restarLikeMinecraft=function(){
    valorMinecraft= document.getElementById("lblMinecraft");
    votosMinecraft=parseInt(valorMinecraft.innerText)-1;
    valorMinecraft.innerText=votosMinecraft;
}
sumarLikeRoblox=function(){
    valorRoblox= document.getElementById("lblRoblox");
    votosRoblox=parseInt(valorRoblox.innerText)+1;
    valorRoblox.innerText=votosRoblox;
}
sumarCorazonRoblox=function(){
    valorRoblox= document.getElementById("lblRoblox");
    votosRoblox=parseInt(valorRoblox.innerText)+5;
    valorRoblox.innerText=votosRoblox;
}
restarLikeRoblox=function(){
    valorRoblox= document.getElementById("lblRoblox");
    votosRoblox=parseInt(valorRoblox.innerText)-1;
    valorRoblox.innerText=votosRoblox;
}