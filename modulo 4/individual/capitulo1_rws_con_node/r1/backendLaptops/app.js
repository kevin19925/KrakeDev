const express = require("express");
const bodyParser = require("body-parser");
const app = express();
const puerto = 3001;
app.listen(puerto, () => {
  console.log(" servidor en el puerto " + puerto);
});
app.use(bodyParser.json());
const laptops = [
  {
    id: 4,
    marca: "Lenovo",
    procesador: "Intel Core i5",
    memoria: "16 GB",
    disco: "1 TB",
  },
  {
    id: 5,
    marca: "Lenovo1",
    procesador: "Intel Core i",
    memoria: "1 GB",
    disco: "2 TB",
  },
  {
    id: 6,
    marca: "HP",
    procesador: "AMD Ryzen 7",
    memoria: "32 GB",
    disco: "512 GB SSD",
  },
  {
    id: 7,
    marca: "Dell",
    procesador: "Intel Core i7",
    memoria: "8 GB",
    disco: "256 GB SSD",
  },
  {
    id: 8,
    marca: "Acer",
    procesador: "Intel Core i3",
    memoria: "4 GB",
    disco: "1 TB HDD",
  },
  {
    id: 9,
    marca: "Asus",
    procesador: "AMD Ryzen 5",
    memoria: "16 GB",
    disco: "512 GB SSD",
  },
];

app.post("/laptops", (request, response) => {
  request.body.id = 99;
  response.send(request.body);
  console.log(request.body);
});

app.get("/laptops/:idparam", (request, response) => {
  const idParametro = parseInt(request.params.idparam);

  let laptopEncontrada = null;

  let laptopsAux = laptops.concat();
  for (let i = 0; i < laptopsAux.length; i++) {
    if (laptopsAux[i].id === idParametro) {
      laptopEncontrada = laptopsAux[i];
      delete laptopEncontrada.id;
      break;
    }
  }
  if (laptopEncontrada) {
    response.send(laptopEncontrada);
  }
});
app.get("/laptops", (request, response) => {
  response.send(laptops);
});

app.put("/laptops/:idParam", (request, response) => {
  const id = request.params.idParam;
  console.log("id=" + id);
  response.send(request.body);
});
app.delete("/laptops/:idparam", (request, response) => {
  const id = request.params.idparam;
  console.log("id=" + id);
  response.status(200).send({ id: id });
});
