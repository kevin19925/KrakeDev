let notas=[];

aniadir = function () {
   let  num=0;
     num = recuperarTexto("txtnota");
    notas.push(num);

}

promedio=function(){
    let suma=0;
    let promedio=0;
for(let i=0;i<notas.length;i++){
suma+=parseInt( notas[i]);


}
promedio=suma/notas.length;

mostrarTexto("lblresultado", promedio);
}


   
