let num1, num2, resul, cadena
sumar = function () {
    num1 = parseInt(document.getElementById("txtnum1").value)
    num2 = parseInt(document.getElementById("txtnum2").value)
    resul = num1 + num2;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "el resultado es : " + resul;
}
sumar = function () {
    num1 = parseInt(document.getElementById("txtnum1").value)
    num2 = parseInt(document.getElementById("txtnum2").value)
    resul = num1 + num2;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "el resultado es : " + resul;
}
restar = function () {
    num1 = parseInt(document.getElementById("txtnum1").value)
    num2 = parseInt(document.getElementById("txtnum2").value)
    resul = num1 - num2;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "el resultado es : " + resul;
}
multiplicar = function () {
    num1 = parseInt(document.getElementById("txtnum1").value)
    num2 = parseInt(document.getElementById("txtnum2").value)
    resul = num1 * num2;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "el resultado es : " + resul;
}
dividir = function () {
    num1 = parseInt(document.getElementById("txtnum1").value)
    num2 = parseInt(document.getElementById("txtnum2").value)
    resul = num1 / num2;
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "resultado : " + resul;
}
limpiar = function () {
    num1 = document.getElementById("txtnum1");
    num2 = document.getElementById("txtnum2");
    num1.value="0";
    num2.value="0";
    cadena = document.getElementById("txtresultado");
    cadena.innerText = "resultado : " ;
}


