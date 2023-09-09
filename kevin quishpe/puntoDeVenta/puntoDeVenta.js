calcularValorTotal = function () {
    let nombreProducto;
    let precioProducto;
    let cantidad;
    let porcentajeDescuento;
    let valorSubtotal;
    let valorDescuento;
    let valorIVA;
    let valorTotal;

    
    



   

    if( esProductoValido("txtProducto")==true &    esCantidadValida("txtCantidad")==true &     esPreciodValido("txtPrecio")==true){
        nombreProducto= recuperarTexto("txtProducto");
        precioProducto = recuperarFloat("txtPrecio");
        cantidad = recuperarInt("txtCantidad");
        valorSubtotal = calcularSubtota(precioProducto, cantidad);
        mostrarTexto("lblSubtotal", "Subtotal  : "+valorSubtotal);
        valorDescuento = calcularDescuento(valorSubtotal, cantidad)
        mostrarTexto("lblDescuento", "Descuento: "+valorDescuento);
        valorIVA = calcularIva(valorSubtotal - valorDescuento);
        mostrarTexto("lblValorIVA", "IVA 12% : "+valorIVA.toFixed(2));
        valorTotal = calcularTotal(valorSubtotal, valorDescuento, valorIVA)
        valorTotal=valorTotal.toFixed(2);
        mostrarTexto("lblTotal", "Total: "+valorTotal);
    }

    

    }
    
     




   
esProductoValido=function(campo){
    let nombreProducto= recuperarTexto("txtProducto");
    let valido=true;
    if(nombreProducto.length==0){
        mostrarTexto("lblError1", "CAMPO OBLIGATORIO");
        valido=false;
    }
    else{

    if(nombreProducto.length>10){
        mostrarTexto("lblError1", "maximo 10 caracteres");
        valido=false;
    }
    else{
        valido=true;
        mostrarTexto("lblError1", "");
    }
    

    }

return valido;

}   


esCantidadValida=function(campo){
    let valido=true;

    if(recuperarTexto(campo).length==0){
        mostrarTexto("lblError2", "CAMPO OBLIGATORIO");
         valido=false;
    }
    else{
            let cantidad = recuperarInt("txtCantidad");
            if(!isNaN(cantidad)){
                        if(cantidad>0 && cantidad<=100){
                            mostrarTexto("lblError2", "");
                            valido=true;
                        }
                        else{
                            valido=false;
                            mostrarTexto("lblError2", "SOLO ENTRE 0 Y 100");
                        }
            
            }
            else{
                mostrarTexto("lblError2", "SOLO NUMEROS");
                valido=false;
            }
        
        
    }

return valido;
}



esPreciodValido=function(campo){

    let valido=true;

    if(recuperarTexto(campo).length==0){
        mostrarTexto("lblError3", "CAMPO OBLIGATORIO");
         valido=false;
    }
    else{
      let  precioProducto = recuperarFloat("txtPrecio");
            if(!isNaN(precioProducto )){
                        if(precioProducto >0 && precioProducto <=50){
                            mostrarTexto("lblError3", "");
                            valido=true;
                        }
                        else{
                            valido=false;
                            mostrarTexto("lblError3", "SOLO ENTRE 0 Y 50");
                        }
            
            }
            else{
                mostrarTexto("lblError3", "SOLO NUMEROS");
                valido=false;
            }
        
        
    }

return valido;


}


limpiar = function () {
  
    mostrarTextoEnCaja("txtProducto", "");
    mostrarTextoEnCaja("txtCantidad", "");
    mostrarTextoEnCaja("txtPrecio", "");
    mostrarTexto("lblSubtotal", "Subtotal  : 0.0");
    mostrarTexto("lblDescuento", "Descuento: 0.0");
    mostrarTexto("lblValorIVA", "IVA 12% :0.0");
    mostrarTexto("lblTotal", "Total: 0.0");


}
