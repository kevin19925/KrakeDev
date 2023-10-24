package com.cmc.directorio.test;
import com.cmc.directorio.entidades.*;

public class TestContacto1 {
	
    public static void main(String[] args) {
        Telefono telef = new Telefono(10, "movi", "09941234123");
        Contacto c = new Contacto("John", "Doe", telef, 75.5);

        System.out.println("Nombre: " + c.getNombre());
        System.out.println("Apellido: " + c.getApellido());
        System.out.println("Activo: " + c.getActivo());
        System.out.println("Numero de Telefono: " + c.getTelefono().getNumero());

        AdminContactos admin = new AdminContactos();
        Contacto c1 = new Contacto("Alice", "Smith", telef, 65.2);
        Contacto c2 = new Contacto("Bob", "Johnson", telef, 80.0);

        Contacto masPesado = admin.buscarMasPesado(c1, c2);
        System.out.println("Contacto más pesado: " + masPesado.getNombre() + " " + masPesado.getApellido());

        boolean operadorasIguales = admin.compararOperadoras(c1, c2);
        System.out.println("Operadoras iguales? " + operadorasIguales);
    }
}
