package com.cmc.directorio.test;
import com.cmc.directorio.entidades.*;
public class TestActivos {
    public static void main(String[] args) {
        Telefono telef = new Telefono(10, "movi", "09941234123");
        Contacto c = new Contacto("John", "Doe", telef, 75.5);


        System.out.println("Contacto antes de activación:");
        System.out.println("Activo: " + c.getActivo());

        AdminContactos admin = new AdminContactos();
        admin.activarUsuario(c);

        System.out.println("Contacto después de activación:");
        System.out.println("Activo: " + c.getActivo());
    }
}
