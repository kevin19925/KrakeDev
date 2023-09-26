let puntos=0;
lanzamientos=5;

jugar=function(){
    let resultado;
    resultado=lanzarDado();
    console.log(resultado);
    
   mostrarCara(resultado);
   modificarLanzamientos();
   modificarPuntos(resultado);
  
}

modificarPuntos=function(n){
puntos+=n;
cambiarTexto("lblPuntos",puntos)

if(puntos>20){
    cambiarTexto("lblResultado","Ganaste")
    limpiar();
    
}
}

modificarLanzamientos=function(){
    lanzamientos--;
    cambiarTexto("lblLanzamintos",lanzamientos)
    if(lanzamientos==0){

        cambiarTexto("lblResultado","Game Over")
        limpiar();
        
    }

}

limpiar=function(){
puntos=0;
lanzamientos=5;
cambiarTexto("lblPuntos",puntos)
cambiarTexto("lblLanzamintos",lanzamientos)

}

mostrarCara=function (num) {
    if (num==1) {
        cambiarImagen("imgDado","dados1.png");
    } 
    else   if (num==2) {
        cambiarImagen("imgDado","dados2.png");
    } 
    else  if (num==3) {
        cambiarImagen("imgDado","dados3.png");
    } 
    else   if (num==4) {
        cambiarImagen("imgDado","dados4.png");
    } 
    else  if (num==5) {
        cambiarImagen("imgDado","dados5.png");

    } 
    else if (num==6 ){
        cambiarImagen("imgDado","dados6.png");
    } 
  
}


lanzarDado=function(){
    let aleatorio;
    let aleatorioMultiplicado;
    let aleatorioEntero;
    let valorDado;
    aleatorio=Math.random();
    aleatorioMultiplicado=aleatorio*6;
    aleatorioEntero=parseInt(aleatorioMultiplicado);
    valorDado=aleatorioEntero+1;
    return valorDado;
}