calcularValorDescuento=function(monto,porcentajeDescuento){
    return monto*(1+(porcentajeDescuento/100));

}
calcularIva=function(monto){

return (monto*0.12)
}

calcularSubtota=function(precio,cantidad){
return (precio*cantidad)
}
calcularTotal=function (subtotal,descuento,iva) {
    return(subtotal-descuento+calcularIva(subtotal))
}

