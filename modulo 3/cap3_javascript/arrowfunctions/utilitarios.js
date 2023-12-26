/*recuperarTexto=function(idComponente) {  
let componente=document.getElementById(idComponente);
let valorComponete=componente.value;

return valorComponete;

}*/

// arrow functios
recuperarTexto = (idComponente)=>{
    let componente=document.getElementById(idComponente);
let valorComponete=componente.value;

return valorComponete;
};

recuperarEntero=(idComponente)=>{

let componente=document.getElementById(idComponente);
return (parseInt(componente.value))

}

recuperarFloat=(idComponente)=>{

    let componente=document.getElementById(idComponente);
    return (parseFloat(componente.value))
    
    }