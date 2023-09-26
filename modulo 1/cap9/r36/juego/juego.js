let puntosPc=0;
let puntosJ=0

jugar=function(j1){
  let j2=  generarElemento();
 let ruta= generarRuta(j2);
   
alert("nervioso");
  mostrarImagen("imgSeleccion",ruta);
  let ganador=determinarGanador(j1,j2);
  mostrarTexto("lblResultado",ganador);
  if(ganador=="Jugador 1"){
    puntosJ++;
    mostrarTexto("lblJ",puntosJ);
  }
  else{
    puntosPc++;
    mostrarTexto("lblPc",puntosPc);
  }

  if(puntosJ==5){
    mostrarTexto("lblResultado1","GANADOR");

  }
  if(puntosPc==5){

    mostrarTexto("lblResultado1","PERDEDOR");
  }


 


}

limpiar=function(){
  mostrarTexto("lblPc"," ");
  mostrarTexto("lblJ"," ");
  mostrarTexto("lblResultado"," ");
  mostrarTexto("lblResultado1"," ");
 puntosJ=0;
 puntosPc=0;
}