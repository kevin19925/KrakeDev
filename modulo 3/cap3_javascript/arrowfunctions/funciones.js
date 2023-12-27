// ejecutarSuma= function() {

// let valor1= recuperarTexto("txtValor1");
// let valor2= recuperarTexto("txtValor2");
// alert(valor1);
// alert(valor2);

// }

// ejecutarSumar = () => {

//     let valor1 = recuperarEntero("txtValor1");
//     let valor2 = recuperarEntero("txtValor2");
//     alert(valor1);
//     alert(valor2);
//     console.log("la suma es " + sumar(valor1, valor2));

// }

// ejecutarRestar = () => {

//     let valor1 = recuperarEntero("txtValor1");
//     let valor2 = recuperarEntero("txtValor2");

//     console.log("la suma es " + restar(valor1, valor2));

// }

ejecutarOperacion = (fun) => {
  let valor1 = recuperarEntero("txtValor1");
  let valor2 = recuperarEntero("txtValor2");
  let resultado = fun(valor1, valor2);
  alert(resultado);
};
ejecutarSumar = () => {
  ejecutarOperacion(sumar);
};

ejecutarRestar = () => {
  ejecutarOperacion(restar);
};

sumar = (num1, num2) => {
  return num1 + num2;
};
restar = (num1, num2) => {
  return num1 - num2;
};

ejecutar = (fn) => {
  fn();
};

imprimir = () => {
  console.log("imprimir");
};

saludar = () => {
  alert("aprender programacion funcional");
};

testEjecutar = () => {
  ejecutar(imprimir);
  ejecutar(saludar);
  //funcion anonima
  ejecutar(() => {
    alert("funcion sin nombre");
  });
};
