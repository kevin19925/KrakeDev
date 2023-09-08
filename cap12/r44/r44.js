clientes = [
    { cedula: "123455", nombre: "sdf", edad: "45" },
    { cedula: "12355", nombre: "sf", edad: "45" },
    { cedula: "12345", nombre: "sf", edad: "45" },
];


crearCliente = function () {

    let cedula = recuperarTexto("txtCedula");
    let nombre = recuperarTexto("txtNombre");
    let edad = recuperarTexto("txtEdad");
    let nuevocliente = {}
    nuevocliente.cedula = cedula;
    nuevocliente.nombre = nombre;
    nuevocliente.edad = edad;
    agregarCliente(nuevocliente);

}


guardarCambios= function () {
    let cedula = recuperarTexto("txtCedula");
    let nombre = recuperarTexto("txtNombre");
    let edad = recuperarTexto("txtEdad");
    let nuevocliente = {}
    nuevocliente.cedula = cedula;
    nuevocliente.nombre = nombre;
    nuevocliente.edad = edad;
    modificar(nuevocliente);
    listaClientes ();
  

}
modificar=function(cliente){
    
let clienteEncontrado=buscarCliente(cliente.cedula);
if(clienteEncontrado!=null){
clienteEncontrado.nombre=cliente.nombre;
clienteEncontrado.edad=cliente.edad;
}


}

ejecutarBusqueda=function () {
    let cedula = recuperarTexto("txtbuscar");

    let clienteEcontrado = buscarCliente(cedula);
    if (clienteEcontrado == null) {
        alert("cliente no encontrado");
    }
    else{

        mostrarTextoEnCaja ("txtCedula",clienteEcontrado.cedula)
        mostrarTextoEnCaja ("txtNombre",clienteEcontrado.nombre)
        mostrarTextoEnCaja ("txtEdad",clienteEcontrado.edad)
    }
   
}

buscarCliente = function (cedula) {
    let elementoCliente;
    let clienteEcontrado = null;
    for (let i = 0; i < clientes.length; i++) {
        elementoCliente = clientes[i];
        if (elementoCliente.cedula == cedula) {
            clienteEcontrado = elementoCliente;
            break;
        }

    }

    return clienteEcontrado;
}

agregarCliente = function (cliente) {
    let resultado;
    resultado = buscarCliente(cliente.cedula)
    if (resultado == null) {
        clientes.push(cliente);
        alert("cliente agregado");
    }
    else {
        alert("cliente ya exite");
    }

}



listaClientes = function () {
    let tabla = mostrarContenido(clientes);
    mostrarTabla("tabla", tabla);
    console.log(tabla)

}


mostrarContenido = function (lista) {

    let contenido = "";
    contenido += "<table><tr><th>cedula </th> <th>nombre </th> <th>edad</th> </tr>"
    for (let i = 0; i < lista.length; i++) {
        let cliente = lista[i];

        contenido += "<tr>"
        contenido += "<td>"
        contenido += cliente.cedula;
        contenido += "</td>"
        contenido += "<td>"
        contenido += cliente.nombre;
        contenido += "</td>"
        contenido += "<td>"
        contenido += cliente.edad;
        contenido += "</td>"
        contenido += "</tr>"

    }

    contenido += "</table>";

    return contenido;
}






crearProducto = function () {
    let producto1 = {
        nombre: "papa",
        precio: 12,
        cantidad: 2
    }


    let producto2 = {
        nombre: "coca",
        precio: 1,
        cantidad: 22
    }

    console.log("nombre proc1 : " + producto1.nombre);
    console.log("nombre proc2 : " + producto2.nombre);

    let p1 = producto1.cantidad;
    let p2 = producto2.cantidad;
    if (p1 == p2) {
        console.log("tienen igual stock ");
    }
    if (p1 > p2) {
        console.log("producto 1 tiene mas stock");
    }
    if (p2 > p1) {
        console.log("producto 2 tiene mas stock");
    }







}