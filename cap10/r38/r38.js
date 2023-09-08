cadena=function(){

let cadena= recuperarTexto("txtcadena");
let cadenaInv=invertirCadena(cadena);
mostrarTexto ("lblresultado",cadenaInv);
;

}

invertirCadena=function(cadena){

    let cadenar="";
for (let i = cadena.length-1 ; i >=0; i--) {
  
 cadenar+=cadena.charAt(i);
   
    
}
return cadenar;

}


mostrarTexto=function(idComponente,mensaje){
    let componente;
    componente=document.getElementById(idComponente);
    componente.innerText = mensaje;
}


recuperarTexto=function(idComponente){
    let componente;
    let valorIngresado;
    componente=document.getElementById(idComponente);
    valorIngresado=componente.value;
    return valorIngresado;
}