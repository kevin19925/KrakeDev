export let notas = [
  { materia: "matematicas ", nota: 9.5 },
  { materia: "fisica ", nota: 8.5 },
];

export const saveNotas = (nota) => {
  notas.push(nota);
  console.log("arreglo", notas);
};

export const getNotas = () => {
  return notas;
};

export const updatenota = (nota) => {
  let notaAct = find(nota.materia);
  if (notaAct != null) {
    notaAct.nota = nota.nota;
  }
};

const find = (materia) => {
  for (let i = 0; i < notas.length; i++) {
    if (notas[i].materia == materia) {
      return notas[i];
    }
  }
  return null;
};
