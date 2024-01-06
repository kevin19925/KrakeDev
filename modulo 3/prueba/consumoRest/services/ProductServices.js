export const saveProduct=()=>{
    fetch('https://jsonplaceholder.typicode.com/posts/1', {
  method: 'PUT',
  body: JSON.stringify({
    id: 1,
    title: 'SOY EL QUE SOY',
    body: 'MALDITOS',
    userId: 1,
  }),
  headers: {
    'Content-type': 'application/json; charset=UTF-8',
  },
})
  .then((response) => response.json())
  .then((json) => console.log(json));
}
export const getAllProducts=()=>{
    fetch('http://192.168.100.67:8080/inventarios-1.0.0/rest/tiposdocumento/recuperar')
    .then((response) => response.json())
    .then((json) => console.log(json));
}