package com.cmc.directorio.test;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono {
    public static void main(String[] args) {
        Telefono telf = new Telefono(10, "movi", "09941234123");

        // Imprimir información del teléfono
        System.out.println("Operadora: " + telf.getOperadora());
        System.out.println("Número: " + telf.getNumero());
        System.out.println("Codigo: " + telf.getCodigo());
        System.out.println("¿Tiene WhatsApp? " + telf.getTieneWhatsapp());
    }
}
