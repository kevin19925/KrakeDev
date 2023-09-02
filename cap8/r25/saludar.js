recuperar=function(idComponente){
return (document.getElementById(idComponente).value);
}

saludar=function(){
let ingresos =recuperar("txtNombre");
if (ingresos>=100 && ingresos<200) {
    console.log("ok")
    
}
//let nombre=recuperar("txtNombre");
//let apellido=recuperar("txtApellido");



}