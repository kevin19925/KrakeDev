let personas = [
    {  nombre: "marcos",edad: 18 },
    {  nombre: "roberto",edad: 15 },
    {  nombre: "kate",edad: 25 },
    {  nombre: "diana",edad: 12 },
    {  nombre: "benja",edad: 5 },
]

agregarPersona = function () {

   
    let nombre = recuperarTexto("txtNombre");
    let edad = recuperarTexto("txtEdad");

    if(validarCampos()==true){
    let persona= {}
    persona.nombre = nombre;
    persona.edad = edad;
    personas.push(persona);
    mostrarPersonas();
    }
}


validarCampos=function(){
let valido=true;
    let nombre = recuperarTexto("txtNombre");
    let edad = recuperarInt("txtEdad");
  
    if (nombre.length < 3 && sonMayusculas(nombre)) {
        valido = false;
        mostrarTexto("lblError1", "el nombre minimo 3 caracteres");
    }

    if (!sonMayusculas(nombre)) {
        valido = false;
        mostrarTexto("lblError1", "el nombre solo en mayusculas");
    }


 if (sonMayusculas(nombre)) {
       
        mostrarTexto("lblError1", "");
    }

    if (edad< 0 || edad > 100) {
        valido = false;
        mostrarTexto("lblError2", "edad entre 0 y 100");
    }

    if (edad> 0 && edad <100) {
        
        mostrarTexto("lblError2", "");
    }
    if (isNaN(edad)) {
        mostrarTexto("lblError2", "solo numeros");
        valido = false;
    }
    if (nombre.length ==0 ) {
        valido = false;
        mostrarTexto("lblError1", "campo vacio");
    }
    if (edad.length ==0 ) {
        valido = false;
        mostrarTexto("lblError1", "campo vacio");
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



mostrarPersonas = function () {

    let contenido = "";
    contenido += "<table><tr><th>Nombre </th> <th>Edad</th>  </tr>"
    for (let i = 0; i < personas.length; i++) {
        let persona = personas[i];

        contenido += "<tr>"

      

        contenido += "<td>"
        contenido += persona.nombre;
        contenido += "</td>"

        contenido += "<td>"
        contenido += persona.edad;
        contenido += "</td>"

     

        contenido += "</tr>"

    }

    contenido += "</table>";
    mostrarTextoTabla("tablaPersona", contenido)

}


encontrarMayor=function(){
    let personaMayor=personas[0];
    let elementoPersona;
    
    for (let i = 0; i < personas.length; i++) {
        let persona = personas[i];
        if(persona.edad>=personaMayor.edad){
            personaMayor=persona;
        }
         
    }

    alert("la persona mayor es " +personaMayor.nombre);;
}



encontrarMenor=function(){
    let personaMenor=personas[0];
    let elementoPersona;
    
    for (let i = 0; i < personas.length; i++) {
        let persona = personas[i];
        if(persona.edad<=personaMenor.edad){
            personaMenor=persona;
        }
         
    }

    alert("la persona menor es " +personaMenor.nombre);
}



