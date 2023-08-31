jugar=function(){

    let aleatorio=lanzarDado();
    cambiarTexto("lblNumero",aleatorio);
    if (aleatorio>=3) { 
        
        cambiarTexto("lblresultado","Mayor a 3 , Ganaste");
         
    } else {
        cambiarTexto("lblresultado","Menor a 3,erdiste");

        
    }
}
lanzarDado=function(){

    let aleatorio;
    aleatorio=(Math.random()*6)+1
    return parseInt(aleatorio);
}