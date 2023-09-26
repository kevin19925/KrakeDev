
convertirEnPesosMx=function(dolares){
   let pesos=dolares*17.99;
    return pesos.toFixed(2)
}

convertirEnEuros=function(dolares){
    let euros=dolares*0.92;
    return euros.toFixed(2)
}
convertirEnPesosColombianos=function(dolares){
    let pesos=dolares*4100.44;
    return pesos.toFixed(2)
}
mostrarPesosCol=function(){
let dolares=parseFloat(document.getElementById("txtdolares").value)
let pesos=convertirEnPesosColombianos(dolares);
cmpvalor=document.getElementById("lblValor");
cmpvalor.innerText=pesos;
let bandera =document.getElementById("imgBandera");
bandera.src="banderaColombia.png";
}
mostrarPesosMx=function(){
    let dolares=parseFloat(document.getElementById("txtdolares").value)
    let pesos=convertirEnPesosMx(dolares);
    cmpvalor=document.getElementById("lblValor");
    cmpvalor.innerText=pesos;
    let bandera =document.getElementById("imgBandera");
    bandera.src="banderaMx.png";
}
mostrarEuros=function(){
let dolares=parseFloat(document.getElementById("txtdolares").value)
let euros=convertirEnEuros(dolares);
cmpvalor=document.getElementById("lblValor");
cmpvalor.innerText=euros;
let bandera =document.getElementById("imgBandera");
bandera.src="unionEuropea.jpg";


}
