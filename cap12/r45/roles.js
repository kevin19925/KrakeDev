let empleados = [
    {cedula:"1714616123",nombre:"John",apellido:"Cena",sueldo:500.0},
    {cedula:"0914632123",nombre:"Luisa",apellido:"Gonzalez",sueldo:900.0},
    {cedula:"1718625989",nombre:"kevin",apellido:"quihspe",sueldo:700.0}
]


mostrarOpcionEmpleado=function(){
    mostrarComponente("divEmpleado");
    ocultarComponente("divRol");
    ocultarComponente("divResumen");
    mostrarEmpleados();

}

mostrarOpcionRol=function(){

    mostrarComponente("divRol");
    ocultarComponente("divEmpleado");
    ocultarComponente("divResumen");
}

mostrarOpcionResumen=function(){
    mostrarComponente("divResumen");
    ocultarComponente("divEmpleado");
    ocultarComponente("divRol");

}

mostrarEmpleados=function(){

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
    mostrarTextoTabla("tablaEmpleados",contenido)

}


