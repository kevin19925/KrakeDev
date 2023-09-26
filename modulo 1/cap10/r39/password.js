
ejecutar = function () {
    let cadena = recuperarTexto("txtcadena");
    validarPassword(cadena);
}



validarPassword = function (pass) {
    valido = true;
    let cadena = pass;
    let numletra = 0
    let numdiguito = 0;
    let numespecial = 0
    for (let i = 0; i < cadena.length; i++) {
        let letra = cadena.charAt(i);

        if (esMayuscula(letra)) {
            numletra++;
        }

        if (esDigito(letra)) {
            numdiguito++;
        }
        if (esEspecial(letra)) {
            numespecial++;
        }

    }

    let mensaje = "";
    if (cadena.length < 8) {

        mensaje = mensaje + "minimo 8 caracteres , \n";
        valido = false;
    }

    else if (cadena.length > 16) {

        mensaje = mensaje + "maximo 16 caracteres , \n";
        valido = false;
    }

     if (numdiguito == 0) {

        mensaje = mensaje + "almenos un diguito , \n"
        valido = false
    }

    if (numletra == 0) {

        mensaje = mensaje + "almenos una mayuscula , \n "
        valido = false
    }

    if (numespecial == 0) {

        mensaje = mensaje + "almenos un c arcater especial , \n "
        valido = false
    }
    mostrarTexto("lblresultado", mensaje);

   if(valido==true){
    mostrarTexto("lblresultado", "password correcto ");
   }

   

    return valido;



}

esMayuscula = function (caracter) {
    num = caracter.charCodeAt(0);

    if (num >= 65 && num <= 90) {

        return true;
    }

    return false;
}

esDigito = function (caracter) {
    num = caracter.charCodeAt(0);
    if (num >= 48 && num <= 57) {

        return true;
    }

    return false;
}

esEspecial = function (caracter) {
    num = caracter.charCodeAt(0);

    if (num == 95 || num == 45 || num == 42) {

        return true;
    }

    return false;
}

////
