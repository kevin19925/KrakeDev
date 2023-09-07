

    ////

    obtenerAleatorio = function(){

let entero=0;

entero=parseInt( (Math.random())*3)+1;


return entero;


    }

generarElemento=function(){

    let numero = obtenerAleatorio();
let mensaje="";
    if (numero==1){
mensaje="piedra";
    }
    else if (numero==2){
        mensaje="papel";
    }
    else{
        mensaje="tijera";

    }
    return mensaje; 
}

determinarGanador=function(jugador1,jugador2){

    if (jugador1 === jugador2) {
        return "Empate";
    } else if (
        (jugador1 === "piedra" && jugador2 === "tijera") ||
        (jugador1 === "papel" && jugador2 === "piedra") ||
        (jugador1 === "tijera" && jugador2 === "papel")
    ) {
        return "Jugador 1";
    } else {
        return "Jugador 2";

    }

}

generarRuta=function(nombre){

    
return "./imagenes/"+nombre+".png";
}




