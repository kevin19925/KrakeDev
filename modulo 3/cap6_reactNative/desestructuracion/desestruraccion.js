recuperar = () => {
  let frutas = ["a", "b", "c", "d", "e"];
  frutas.push("f");
  return frutas;
};

testRecuperar = () => {
  let misfrtas = recuperar();
  console.log("1>>" + misfrtas[0]);
};

testRecuperarDes = () => {
  let [a, b] = recuperar();
  console.log("1>>" + b);
};
