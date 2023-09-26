let num1 ,resul
convert = function () {
    num1 = parseFloat(document.getElementById("txtnum").value)
  
    resul = num1 *1.609;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "el resultado es : " + resul+" kilometros";
}

