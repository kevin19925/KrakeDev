calcularTasaInteres=function (IngresoAnual) {
    let ingreso;
    let tasa;
    ingreso=parseFloat(IngresoAnual);
    if(ingreso<300000){
tasa=;
    }
    else if(ingreso>=300000 && ingreso<500000){

tasa=ingreso*0.15;
    }
     else if(ingreso>=500000 && ingreso<1000000){

      tasa=ingreso*0.14;  
    }
    else if(ingreso>=1000000 && ingreso<2000000){

        tasa= ingreso*0.13;  
    }
    else if(ingreso>=2000000 ){

        tasa= ingreso*0.12 ; 
    }
    
    
    return tasa;

}


calcularCapacidadPago=function(edad,ingresos,egresos){

    let capacidad
if(edad>50 ){
    capacidad=(ingresos-egresos)*0.30;
}
else if(edad<30){
    capacidad=(ingresos-egresos)*0.40;

}
return capacidad;
}

// el valor es depues del descuento 
//es lo mismo valor =(precio* cantidad)-(precio* cantidad*0.2) 
//que valor=precio*cantidad*0.98

calcularDescuento=function(precio,cantidad){

    let valor;

    if(cantidad<3){
valor=precio*cantidad;
    }
    else if(cantidad>=3 && cantidad<=5){

    valor=(precio*cantidad)*0.98;
    }
    else if(cantidad>=6 && cantidad<=11){

        valor=(precio*cantidad)*0.97;
        }
        else if(cantidad>=12){

            valor=(precio*cantidad)*0.96;
            }

            return valor
}

determinarColesterolLDL=function (NivelDeCoresterol) {
    
    let nivel;
    let indicador;
    nivel=parseFloat(NivelDeCoresterol);

    if(nivel<100){
indicador="	Óptimo"
    }
    else if(nivel >=100 && nivel<=129){
        indicador="	Casi óptimo"
    }
    else if (nivel >=100 && nivel<=129){
        indicador="		Límite superior del rango normal"
    }
    else if (nivel >=160 && nivel<=189){
        indicador="			Alto"
    }

    else if (nivel >=190){
        indicador="		Muy alto"
    }

    return indicador;

}

validarClave=function (clave) {
    let valida=false;
    tam=clave.length;
    if (tam>=8 && tam<=16) {
        valida=true;
    } 
    return valida;
}

esMayuscula=function(caracter){
num=caracter.charCodeAt(1);
if(num>=65 && num<=90){

return true;
}

return false;
}

esDigito=function(caracter){
    num=caracter.charCodeAt(1);
    if(num>=48 && num<=57){
    
    return true;
    }
    
    return false;
    }

    darPermiso=function(nM,nF,nG){
        
        if(nM>90 || nF>90 ||nG>90){
        
        return true;
        }
        
        return false;
        }



        otorgarPermiso=function(nM,nF,nG){
            nM=parseFloat(nM);
            nF=parseFloat(nF);
            nG=parseFloat(nG);

            if((nM>90 || nF>90 )&& nG>80){
            
            return true;
            }
            
            return false;
            }

            dejarSalir=function(nM,nF,nG){
                nM=parseFloat(nM);
                nF=parseFloat(nF);
                nG=parseFloat(nG);
    
                if((nM>90 || nF>90 || nG>90)&& nF>nM){
                
                return true;
                }
                
                return false;
                }
