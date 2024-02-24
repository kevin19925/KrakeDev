const express = require("express");
const bodyParser = require("body-parser");
const { Client } = require("pg");
const client = new Client({
  user: "postgres",
  host: "192.168.100.8",
  database: "prueba_m4",
  password: "POLIkevin1",
  port: 5432,
});
const app = express();
const puerto = 3001;
//se ejecuta nates de cualquier peticiosn simpre

//"ingresa middlewear"
app.use(bodyParser.json());
app.use("/contactos", (request, response, next) => {
  console.log("ingresa middlewear");
  //recuperar hedders
  //console.log("heders", request.headers);

  console.log("body", request.body);
  next();
});

app.get("/contactos", (request, response) => {
  client.connect();
  client
    .query("select * from contactos")
    .then((result) => {
      console.log(result.rows);
      response.send(result.rows);
      client.end();
    })
    .catch((err) => {
      console.log(err);
      client.end();
    });
  // const contactos = [
  //   { id: 1, nombre: "kevin", apellido: "quishpe", celular: "097914994" },
  //   { id: 2, nombre: "kevin1", apellido: "quishpe1", celular: "0979149941" },
  //   { id: 3, nombre: "kevin2", apellido: "quishpe2", celular: "0979149942" },
  // ];

  // console.log(contactos);
});
//(url,funciona aejecutar)
// request valores de llegada
//response responder

app.post("/contactos", (request, response) => {
  //devuelvo el bady creado el objeto , con un id
  request.body.id = 99;
  response.send(request.body);
});

app.put("/contactos/:idParam", (request, response) => {
  const id = request.params.idParam;
  console.log("id=" + id);
  response.send(request.body);
});

app.delete("/contactos/:idparam", (request, response) => {
  const id = request.params.idparam;
  console.log("id=" + id);
  response.status(200).send({ id: id });
});

app.listen(3001, () => {
  console.log(" servidor en el puerto " + puerto);
});
