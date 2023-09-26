
testSaludarAmigo= function(){
let nombre=document.getElementById("txtNombre").value;
let apellido=document.getElementById("txtApellido").value;
let apodo=document.getElementById("txtApodo").value;
saludarAmigo(nombre,apellido,apodo);
}

saludarAmigo=function(nombre,apellido,apodo){
alert("hola  amigo "+nombre+" "+apellido+" "+apodo)

}