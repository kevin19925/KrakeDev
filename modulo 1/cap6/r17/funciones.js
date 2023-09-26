
testSaludarAmigo= function(){
let nombre=document.getElementById("txtnombre").value;
let apellido=document.getElementById("txtapellido").value;
let apodo=document.getElementById("txtapodo").value;
saludarAmigo(nombre,apellido,apodo);
}

saludarAmigo=function(nombre,apellido,apodo){
alert("hola  amigo "+nombre+" "+apellido+" "+apodo)

}