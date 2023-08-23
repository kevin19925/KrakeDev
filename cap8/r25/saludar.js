recuperar=function(idComponente){
return (document.getElementById(idComponente).value);
}

saludar=function(){
let nombre=recuperar("txtNombre");
let apellido=recuperar("txtApellido");
}