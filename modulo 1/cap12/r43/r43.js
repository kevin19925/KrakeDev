



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
        console.log("tienen igual stock " );
    }
    if (p1 > p2) {
        console.log("producto 1 tiene mas stock" );
    }
    if (p2 > p1) {
        console.log("producto 2 tiene mas stock" );
    }







}