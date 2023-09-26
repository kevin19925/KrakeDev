calcularPromedionotas=function () {
    
    let n1=recuperarFlotante("lbln1");
    let n2=recuperarFlotante("lbln2");
    let n3=recuperarFlotante("lbln3");

    let promedio=calcularPromedio(n1,n2,n3);
    cambiarTexto("lblresultado",promedio)
    if (promedio>7) {
        cambiarImagen("img","https://www.gifsanimados.org/data/media/1574/exito-imagen-animada-0006.gif");
    } else {
        cambiarImagen("img","https://media.tenor.com/Q4b2T6umZyoAAAAM/fail-badtestscore.gif");
    }

}