saludar = function () {
    let nombre = recuperarTexto("txtNombre");
    let apellido = recuperarTexto("txtApellido");
    let edad = recuperarInt("txtEdad");
    let estatura=recuperarFloat("txtEstatura")

}

recuperarTexto = function (idComponente) {
    return (document.getElementById(idComponente).value);
}



recuperarFloat = function (idComponente) {
    return parseFloat(document.getElementById(idComponente).value);
}
recuperarInt = function (idComponente) {
    return parseInt(document.getElementById(idComponente).value);
}
