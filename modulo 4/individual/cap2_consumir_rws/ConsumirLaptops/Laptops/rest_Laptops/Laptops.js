const ip = "192.168.100.8";
// "192.168.100.8";
const port = 3001;
const url = "http://" + ip + ":" + port + "/";

export const getLaptops = (actu) => {
  console.log(url);
  fetch(url + "laptops")
    .then((response) => {
      return response.json();
    })
    .then((body) => {
      actu(body);
    });
};

export const saveRest = (laptop, fnshowMessage) => {
  const config = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    // la estrctura que espera el rws el objeto
    body: JSON.stringify({
      marca: laptop.marca,
      procesador: laptop.procesador,
      memoria: laptop.memoria,
    }),
  };
  fetch(url + "laptops", config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage("se inserto");
      console.log(body);
    });
};

export const updateRest = (laptop, fnshowMessage) => {
  const config = {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    // la estrctura que espera el rws el objeto
    body: JSON.stringify({
      id: laptop.id,
      marca: laptop.marca,
      procesador: laptop.procesador,
      memoria: laptop.memoria,
    }),
  };
  fetch(url + "laptops/" + laptop.id, config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage("Se actualizo");
      console.log(body);
    });
};

export const deleteRest = (laptop, fnshowMessage) => {
  const config = {
    method: "DELETE",
  };
  fetch(url + "laptops/" + laptop.id, config)
    .then((res) => {
      return res.json();
    })
    .then((body) => {
      fnshowMessage("Se elimino ");
      console.log(body);
    });
};
