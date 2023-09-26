

obtenerAleatorio = function () {

    let entero = 0;

    entero = parseInt((Math.random()) * 100) + 1;


    return entero;


}

generarAleatorio = function () {
    let num = 0;
    let numeros = [];
    let contenido = "";
    let cantidad = recuperarTexto("txtcantidad");
    if (isNaN(cantidad)) {
        alert("solo numeros");

    }
    else {


        contenido += "<table><tr><th> numeros </th></tr>"
        for (let i = 0; i < cantidad; i++) {

            numeros.push(obtenerAleatorio());
            contenido += "<tr><td>"
            contenido += numeros[i];
            contenido += "</td></tr>"

        }

        contenido += "</table>";

        mostrarTexto("lblresultado", contenido);
    }




}

mostrarTexto = function (idComponente, mensaje) {
    let componente;
    componente = document.getElementById(idComponente);
    componente.innerHTML = mensaje;
}
recuperarTexto = function (idComponente) {
    let componente;
    let valorIngresado;
    componente = document.getElementById(idComponente);
    valorIngresado = componente.value;
    return valorIngresado;
}
