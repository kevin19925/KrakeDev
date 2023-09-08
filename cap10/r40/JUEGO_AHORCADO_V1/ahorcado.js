//No se olvide de respirar, mantenga la calma y demuestre lo que sabe
let palabraSecreta = "";
let intentos = 0;
let coicidencias = 0;
let errores = 0;
esMayuscula = function (caracter) {
    num = caracter.charCodeAt(0);

    if (num >= 65 && num <= 90) {

        return true;
    }

    return false;
}

guardarPalabra = function () {
    let cadena = recuperarTexto("txtSecreta");

    let numletra = 0

    for (let i = 0; i < cadena.length; i++) {
        let letra = cadena.charAt(i);

        if (esMayuscula(letra)) {
            numletra++;
        }

    }

    if (numletra == 5) {
        palabraSecreta = cadena;
        //alert("5 mayusculas");
    }

}

mostrarLetra = function (letra, posicion) {
    if (posicion == 0) {
        mostrarTexto("div0", letra)
    }
    if (posicion == 1) {
        mostrarTexto("div1", letra)
    }
    if (posicion == 2) {
        mostrarTexto("div2", letra)
    }
    if (posicion == 3) {
        mostrarTexto("div3", letra)
    }
    if (posicion == 4) {
        mostrarTexto("div4", letra)
    }
}

validar = function (letra) {
    let letrasEncontradas = 0;
    let cadena = palabraSecreta;
    let encontro = false;
    for (let i = 0; i < cadena.length; i++) {
        let letraCadena = cadena.charAt(i);

        if (letraCadena == letra) {
            letrasEncontradas++;
            mostrarLetra(letra, i)
            coicidencias++;
            encontro = true;
        }
    }

    if (encontro == false) {
        alert("LA LETRA NO Es PARTE DE LA PALABRA")
        errores++;
        mostrarAhorcado();
    }


}

ingresarLetra = function () {

    let letra = recuperarTexto("txtLetra");
    //alert(letra);
    if (esMayuscula(letra)) {

        validar(letra);
        if (coicidencias == 5) {
            mostrarImagen("ahorcadoImagen", "./ganador.gif");
        }
        if (intentos == 10) {
         
            mostrarImagen("ahorcadoImagen", "./gameOver.gif");
        }
    }
    else {

        alert("SOLO SE ACEPTAN MAYUSCULAS")
    }
    intentos++;


}

mostrarAhorcado = function () {

    if (errores == 1) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_01.png");
    }
    if (errores == 2) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_02.png");
    }
    if (errores == 3) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_03.png");
    }
    if (errores == 4) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_04.png");
    }
    if (errores == 5) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_05.png");
    }
    if (errores == 6) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_06.png");
    }
    if (errores == 7) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_07.png");
    }
    if (errores == 8) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_08.png");
    }
    if (errores == 9) {
        mostrarImagen("ahorcadoImagen", "./Ahorcado_09.png");
    }
  
    

}