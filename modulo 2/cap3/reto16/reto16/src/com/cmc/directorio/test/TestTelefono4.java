package com.cmc.directorio.test;
import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {
    public static void main(String[] args) {
        Telefono t1 = new Telefono(10, "movi", "09941234123");
        Telefono t2 = new Telefono(20, "claro", "098234234");
        Telefono t3 = new Telefono(30, "movi", "097654321");
        Telefono t4 = new Telefono(40, "claro", "096543210");
        AdminTelefono at = new AdminTelefono();
        int resultado = at.contarClaro(t1, t2, t3, t4);
        System.out.println("Cantidad de teléfonos con operadora 'claro': " + resultado);
    }
}
