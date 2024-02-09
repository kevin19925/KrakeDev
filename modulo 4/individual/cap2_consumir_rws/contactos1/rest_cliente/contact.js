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
