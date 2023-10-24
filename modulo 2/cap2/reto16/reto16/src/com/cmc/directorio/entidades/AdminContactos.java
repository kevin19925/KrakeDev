package com.cmc.directorio.entidades;

public class AdminContactos {
    public Contacto buscarMasPesado(Contacto c1, Contacto c2) {
        return (c1.getPeso() > c2.getPeso()) ? c1 : c2;
    }

    public boolean compararOperadoras(Contacto c1, Contacto c2) {
        return c1.getTelefono().getOperadora().equals(c2.getTelefono().getOperadora());
    }

    public void activarUsuario(Contacto contacto) {
        if (contacto.getTelefono().getTieneWhatsapp()) {
            contacto.setActivo(true);
        }
    }
}
