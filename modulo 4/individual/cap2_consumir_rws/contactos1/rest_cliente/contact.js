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

export const saveContactRest = (contact, fnshowMessage) => {
  const config = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    // la estrctura que espera el rws el objeto
    body: JSON.stringify({
      nombre: contact.nom,
      apellido: contact.ape,
      telefono: contact.tele,
    }),
  };
  fetch(url + "contactos", config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage();
      console.log(body);
    });
};

export const updateRest = (contact, fnshowMessage) => {
  const config = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    // la estrctura que espera el rws el objeto
    body: JSON.stringify({
      nombre: contact.nom,
      apellido: contact.ape,
      telefono: contact.tele,
    }),
  };
  fetch(url + "contactos/" + contact.id, config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage("Se actualizo");
      console.log(body);
    });
};

export const deleteRest = (contact, fnshowMessage) => {
  const config = {
    method: "DELETE",
  };
  fetch(url + "contactos/" + contact.id, config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage("Se elimino ");
      console.log(body);
    });
};
