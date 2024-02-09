const ip = "192.168.100.8";
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
