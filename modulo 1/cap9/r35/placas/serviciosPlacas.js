validarEstructura=function(placa){
let mensaje ="";
tam=placa.length;
let correcto=true;

if (tam!=7 && tam!=8){
    mensaje=mensaje+" deber tener 7 u 8, \n";
    console.log(placa.charAt(0));
    correcto=false;
}

if (!esMayuscula(placa.charAt(0))){

    mensaje=mensaje+" el primer debe ser mayuscula, \n";
    console.log(placa.charAt(0));
    correcto=false;
}

if (! esMayuscula(placa.charAt(1))){
    mensaje=mensaje+" el segundo debe ser mayuscula, \n";
    correcto=false;
}

if ( !esMayuscula(placa.charAt(2))){
    mensaje=mensaje+" el tercer debe ser mayuscula, \n";
    correcto=false;
}


 if (! esGuion(placa.charAt(3))){
    mensaje=mensaje+" el cuarto debe ser guion, \n";
    correcto=false;
}

if (!esDigito(placa.charAt(4))){
    mensaje=mensaje+" el quinto debe ser diguito,\n ";
    correcto=false;
}
if (!esDigito(placa.charAt(5))){
    mensaje=mensaje+" el sexto debe ser diguito,\n ";
    correcto=false;
}
if (!esDigito(placa.charAt(6))){
    mensaje=mensaje+" el septimo debe ser diguito, \n";
    correcto=false;
}

    if (!esDigito(placa.charAt(7))==true && tam==8 ){
        mensaje=mensaje+" el octavo debe ser diguito, \n";
        correcto=false;
    }





mostrarTexto("lblError2",mensaje);

return correcto;
}


validarPlaca=function(){
placa=recuperarTexto("txtplaca")
    
    if (validarEstructura(placa)==true)
    {
    alert("ESTRUCTURA CORRECTA");
    obtenerProvincia(placa);
    obtenerTipo(placa);
    obtenerPicoPlaca(placa);
    }
    else
    {

        alert("ESTRUCTURA INCORRECTA");

   
    }

}

obtenerProvincia=function(placa){
    let letra=placa.charAt(0);


let provincia = "";

if (letra == 'A') {
    provincia = "Azuay";
} else if (letra == 'B') {
    provincia = "Bolívar";
} else if (letra == 'U') {
    provincia = "Cañar";
} else if (letra == 'C') {
    provincia = "Carchi";
} else if (letra == 'X') {
    provincia = "Cotopaxi";
} else if (letra == 'H') {
    provincia = "Chimborazo";
} else if (letra == 'O') {
    provincia = "El Oro";
} else if (letra == 'E') {
    provincia = "Esmeraldas";
} else if (letra == 'W') {
    provincia = "Galápagos";
} else if (letra == 'G') {
    provincia = "Guayas";
} else if (letra == 'I') {
    provincia = "Imbabura";
} else if (letra == 'L') {
    provincia = "Loja";
} else if (letra == 'R') {
    provincia = "Los Ríos";
} else if (letra == 'M') {
    provincia = "Manabí";
} else if (letra == 'V') {
    provincia = "Morona Santiago";
} else if (letra == 'N') {
    provincia = "Napo";
} else if (letra == 'S') {
    provincia = "Pastaza";
} else if (letra == 'P') {
    provincia = "Pichincha";
} else if (letra == 'Q') {
    provincia = "Orellana";
} else if (letra == 'K') {
    provincia = "Sucumbíos";
} else if (letra == 'T') {
    provincia = "Tungurahua";
} else if (letra == 'Z') {
    provincia = "Zamora Chinchipe";
} else if (letra == 'Y') {
    provincia = "Santa Elena";
} else if (letra == 'J') {
    provincia = "Santo Domingo de los Tsáchilas";
} else {
    provincia = "Provincia Desconocida"; as
}


mostrarTexto("lblProvincia", provincia);




}

obtenerTipo=function(placa){
let letra=placa.charAt(1);
let mensaje="";
if(letra == "A" || letra == "Z"){

    mensaje="Vehiculo comercial";
}

else if(letra == "E"){

    mensaje="Vehiculo gubernamental";
}

else if(letra == "X"){

    mensaje="Vehiculo uso oficial";
}

else if (letra == "S"){

    mensaje="Vehiculo gobierno provincial ";
}

else if(letra == "M"){

    mensaje="Vehiculo gobierno municipal ";
}
else{

    mensaje="Vehiculo particular ";
}

mostrarTexto("lblTipo", mensaje);

}

obtenerPicoPlaca=function(placa){
    let letra;
    let mensaje="";
    if(placa.length==7){
       letra =placa.charAt(6);
    }
  
    if(placa.length==8){
        letra =placa.charAt(7);
     }

   
   if(letra==1 || letra==2){

           mensaje="LUNES";
   }
   if(letra==3 || letra==4){

    mensaje="MARTES";
}
if(letra==5 || letra==6){

    mensaje="MIERCOLES";
}
if(letra==7 || letra==8){

    mensaje="JUEVES";
}
if(letra==9 || letra==0){

    mensaje="VIERNES";
}
      
   
mostrarTexto("lblPico", mensaje);
    

    
    }
limpiar=function() {


    
    placa=recuperarTexto("txtplaca")
    
    if (validarEstructura(placa)==true)
    {
     mostrarTexto("lblPico", " ");
    mostrarTexto("lblTipo", " ");
    mostrarTexto("lblProvincia", " ");
     mostrarTextoEnCaja("txtplaca", " ");
      

    }else{

        mostrarTexto("lblError2", " ");
    }
     

    }