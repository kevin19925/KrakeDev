calcularValorDescuento=function(monto,porcentajeDescuento){
    return monto*(porcentajeDescuento/100);

}
calcularIva=function(monto){

return (monto*0.12)
}

calcularSubtota=function(precio,cantidad){
return (precio*cantidad)
}
calcularTotal=function (subtotal,descuento,iva) {
    return(subtotal-descuento+iva)
}

calcularDescuento=function(subtotal,cantidad){
let descuento ;

if(cantidad<3){
    descuento=subtotal;
}
else if(cantidad>3 && cantidad<=5){
    descuento=(cantidad*subtotal)*0.03
}
else if(cantidad>6 && cantidad<=11){
    descuento=(cantidad*subtotal)*0.04
}
else if(cantidad>12){
    descuento=(cantidad*subtotal)*0.05
}

return descuento
}
