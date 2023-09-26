
mostrarImagen=function(idComponente,rutaImagen){
    let componente;
    componente=document.getElementById(idComponente);
    componente.src =  rutaImagen;
}

mostrarTextoEnCaja = function(idComponente,mensaje){
    let componente;
    componente=document.getElementById(idComponente);
    componente.value = mensaje;
}

recuperarTexto=function(idComponente){
    let componente;
    let valorIngresado;
    componente=document.getElementById(idComponente);
    valorIngresado=componente.value;
    return valorIngresado;
}

recuperarInt = function(idComponente){
   let valorCaja= recuperarTexto(idComponente);
   let valorEntero = parseInt(valorCaja);
   return valorEntero;
}

recuperarFloat = function(idComponente){
    let valorCaja= recuperarTexto(idComponente);
    let valorFlotante = parseFloat(valorCaja);
    return valorFlotante;
 }


 esMayuscula=function(caracter){
    num=caracter.charCodeAt(0);

    if(num>=65 && num<=90){
    
    return true;
    }
    
    return false;
    }
    
    esDigito=function(caracter){
        num=caracter.charCodeAt(0);
        if(num>=48 && num<=57){
        
        return true;
        }
        
        return false;
        }
    

        esGuion=function(caracter){
            num=caracter.charCodeAt(0);
            if(num==45){
            
            return true;
            }
            
            return false;
            }
        