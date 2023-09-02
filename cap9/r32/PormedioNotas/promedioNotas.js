calcularPromedionotas=function () {
    
    let n1=recuperarFlotante("lbln1");
    let n2=recuperarFlotante("lbln2");
    let n3=recuperarFlotante("lbln3");

    let promedio=calcularPromedio(n1,n2,n3);
    cambiarTexto("lblResultado",promedio)
    if (promedio<5 && promedio>0) {

        cambiarImagen("img","https://media.tenor.com/aaN_KimJC74AAAAM/denied-lou.gif");

       
        cambiarTexto("lblMensaje","REPROBADO");
    } 
    
    else if(promedio>=5 && promedio<=8){

        cambiarImagen("img","https://www.gifsanimados.org/data/media/1574/exito-imagen-animada-0006.gif");
        cambiarTexto("lblMensaje","BUEN TRABAJO");
    }

    else if(promedio>8 && promedio<=10){

        cambiarImagen("img","https://i.pinimg.com/originals/ce/4c/3d/ce4c3d6954cfce9e1397dda6e918fdcf.gif");
        cambiarTexto("lblMensaje","EXCELENTE");
    }


    else {
        cambiarImagen("img","https://logos.flamingtext.com/Word-Logos/incorrecto-design-stripes-name.gif");
        cambiarTexto("lblMensaje","DATOS INCORRECTOS");
    }

}