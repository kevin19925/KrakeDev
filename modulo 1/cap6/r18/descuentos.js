calcularDescuento=function( valorReal ,porcentajeDescuento){
    let valorDescuento;
let  total;
// pregunta 2
valorDescuento=(valorReal*porcentajeDescuento/100);
//pregunta 3

total=valorReal-valorDescuento;
//pregunta 4
return total;
}

descontar=function(){
let valorMonto=parseInt(document.getElementById("txtMonto").value)
let valorDescuento=parseInt(document.getElementById("txtDescuento").value)
let total=calcularDescuento(valorMonto,valorDescuento);
let valor=valorMonto=document.getElementById("lblTotal");
valor.innerText="Valor a pagar: "+total
}
