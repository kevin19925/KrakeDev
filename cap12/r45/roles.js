let empleados = [
    { cedula: "1714616123", nombre: "John", apellido: "Cena", sueldo: 500.0 },
    { cedula: "0914632123", nombre: "Luisa", apellido: "Gonzalez", sueldo: 900.0 },
    { cedula: "1718625989", nombre: "kevin", apellido: "quihspe", sueldo: 800.0 }
]

let esNuevo = false;

mostrarOpcionEmpleado = function () {
    mostrarComponente("divEmpleado");
    ocultarComponente("divRol");
    ocultarComponente("divResumen");
    mostrarEmpleados();
    deshabilitar();
}

mostrarOpcionRol = function () {

    mostrarComponente("divRol");
    ocultarComponente("divEmpleado");
    ocultarComponente("divResumen");
}

mostrarOpcionResumen = function () {
    mostrarComponente("divResumen");
    ocultarComponente("divEmpleado");
    ocultarComponente("divRol");

}

mostrarEmpleados = function () {

    let contenido = "";
    contenido += "<table><tr><th>Cedula </th> <th>Nombre </th> <th>Apellido</th> <th>Sueldo</th> </tr>"
    for (let i = 0; i < empleados.length; i++) {
        let cliente = empleados[i];

        contenido += "<tr>"
        contenido += "<td>"
        contenido += cliente.cedula;
        contenido += "</td>"
        contenido += "<td>"
        contenido += cliente.nombre;
        contenido += "</td>"
        contenido += "<td>"
        contenido += cliente.apellido;
        contenido += "</td>"
        contenido += "<td>"
        contenido += cliente.sueldo;
        contenido += "</td>"
        contenido += "</tr>"

    }

    contenido += "</table>";
    mostrarTextoTabla("tablaEmpleados", contenido)

}

ejecutarNuevo = function () {
    habilitarComponente("txtCedula");
    habilitarComponente("txtNombre");
    habilitarComponente("txtApellido");
    habilitarComponente("txtSueldo");
    habilitarComponente("btnGuardar");
    esNuevo = true;
}

deshabilitar = function () {

    deshabilitarComponente("txtCedula");
    deshabilitarComponente("txtNombre");
    deshabilitarComponente("txtApellido");
    deshabilitarComponente("txtSueldo");
    deshabilitarComponente("btnGuardar");
}

buscarEmpleado = function (cedula) {

    for (let i = 0; i < empleados.length; i++) {
        let empleado = empleados[i];

        if (empleado.cedula == cedula) {
            return empleado;

        }
    }
    return null;
}

agregarEmpleado = function (empleado) {
    seAgrego = false;

    if (buscarEmpleado(empleado.cedula) == null) {
        empleados.push(empleado);
        seAgrego = true;
    }

    return seAgrego;
}

guardar = function () {

    let cedula = recuperarTexto("txtCedula");
    let nombre = recuperarTexto("txtNombre");
    let apellido = recuperarTexto("txtApellido");
    let sueldo = recuperarFloat("txtSueldo");
    if (esValidoCampos() == true) {
        let empleado = {};
        empleado.cedula = cedula;
        empleado.nombre = nombre;
        empleado.apellido = apellido;
        empleado.sueldo = sueldo;
        if (agregarEmpleado(empleado)) {
            alert("se agrego correctamente ");
            mostrarEmpleados();
            deshabilitar();
           
        }
        else {
            alert("ya exite el usuario con cedula :" + empleado.cedula);
        }


    }

    if (esNuevo == false) {
        let emplaedoBuscado = buscarEmpleado(cedula);
      
        emplaedoBuscado.nombre = nombre;
        emplaedoBuscado.apellido = apellido;
        emplaedoBuscado.sueldo = sueldo;
        alert("MODIFICADO EXITOSAMENTE");
        mostrarEmpleados();

    }
}



esValidoCampos = function () {
    let valido = true;
    let cedula = recuperarTexto("txtCedula");
    let nombre = recuperarTexto("txtNombre");
    let apellido = recuperarTexto("txtApellido");
    let sueldo = recuperarFloat("txtSueldo");

    if (isNaN(cedula)) {
        mostrarTexto("lblErrorCedula", "La cedula debe ser numeros");
        valido = false;
    }

    if (cedula.length < 10 && isNaN(cedula) == false) {
        valido = false;
        mostrarTexto("lblErrorCedula", "La cedula debe tener 10 digitos");
    }

    if (nombre.length < 3 && sonMayusculas(nombre)) {
        valido = false;
        mostrarTexto("lblErrorNombre", "el nombre minimo 3 caracteres");
    }

    if (!sonMayusculas(nombre)) {
        valido = false;
        mostrarTexto("lblErrorNombre", "el nombre solo en mayusculas");
    }

    if (apellido.length < 3 && sonMayusculas(apellido)) {
        valido = false;
        mostrarTexto("lblErrorApellido", "el Apellido minimo 3 caracteres");
    }

    if (!sonMayusculas(apellido)) {
        valido = false;
        mostrarTexto("lblErrorApellido", "el Apellido solo en mayusculas");
    }

    if (sueldo < 400 || sueldo > 5000) {
        valido = false;
        mostrarTexto("lblErrorSueldo", "el sueldo debe estar entre 400 y 5000");
    }


    return valido;

}

sonMayusculas = function (palabra) {
    let valido = true;
    for (let i = 0; i < palabra.length; i++) {
        if (!esMayuscula(palabra[i])) {
            valido = false;
            return valido;
            break;

        }

    }
    return valido;
}

ejecutarBusqueda = function () {
    let cedula = recuperarTexto("txtBusquedaCedula");

    newEmpleado = buscarEmpleado(cedula);
    if (newEmpleado == null) {
        alert("EMPLEADO NO EXISTE");

    }
    else {
        mostrarTextoEnCaja("txtCedula", newEmpleado.cedula);
        mostrarTextoEnCaja("txtNombre", newEmpleado.nombre);
        mostrarTextoEnCaja("txtApellido", newEmpleado.apellido);
        mostrarTextoEnCaja("txtSueldo", newEmpleado.sueldo);
        ejecutarNuevo();
        esNuevo=false;
        
    }

}
limpiar=function(){

    mostrarTextoEnCaja("txtCedula", "");
    mostrarTextoEnCaja("txtNombre", "");
    mostrarTextoEnCaja("txtApellido", "");
    mostrarTextoEnCaja("txtSueldo", "");
    mostrarTextoEnCaja("txtBusquedaCedula", "");
    esNuevo=false;
    deshabilitar();

}

buscarPorRol=function(){

    let cedula = recuperarTexto("txtBusquedaCedulaRol");
    let newEmpleado=buscarEmpleado(cedula);
    alert(cedula);

    if(newEmpleado==null){
        alert("EMPLEADO NO EXISTE CON CI :" +cedula);

    }else{
    mostrarTexto("infoCedula", newEmpleado.cedula);
    mostrarTexto("infoNombre", newEmpleado.apellido+" "+newEmpleado.apellido);
    mostrarTexto("infoSueldo", newEmpleado.sueldo);
    }
}

calcularAporteEmpleado=function(sueldo){
    return (sueldo*0.0945)

}
calcularValorAPagar=function(sueldo,aporte,descuento){

return (sueldo-aporte-descuento);
}

calcularRol=function(){
let sueldo=recuperarFloatDiv("infoSueldo");
let descuento=recuperarFloat("txtDescuentos");

if(descuento>0 && descuento<sueldo){
let aporte =calcularAporteEmpleado(sueldo);
let valor=calcularValorAPagar(sueldo,aporte,descuento);
mostrarTexto("infoIESS", aporte);
mostrarTexto("infoPago", valor);
}

}