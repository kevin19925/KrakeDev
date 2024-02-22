const ip = "192.168.100.8";
const port = 3001;
const url = "http://" + ip + ":" + port + "/";

export const getAllConstac = (fnRefres) => {
  console.log("entro");
  fetch(url + "contactos")
    .then((response) => {
      return response.json();
    })
    .then((body) => {
      fnRefres(body);
    });
};

export const saveContactRest = (contact) => {
  const config = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    // la estrctura que espera el rws el objeto
    body: JSON.stringify({
      nombre: contact.name,
      apellido: contact.surname,
      cedula: contact.phoneNumber,
    }),
  };
  fetch(url + "contactos", config)
    .then((res) => {
      res.json();
    })
    .then((body) => {
      console.log(body);
    });
};
