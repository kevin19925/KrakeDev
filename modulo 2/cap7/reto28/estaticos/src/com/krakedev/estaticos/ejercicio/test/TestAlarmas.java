package com.krakedev.estaticos.ejercicio.test;



import com.krakedev.estaticos.ejercicio.entidades.*;
import com.krakedev.estaticos.ejercicio.logica.*;
import com.krakedev.estaticos.ejercicio.utils.*;
public class TestAlarmas {
    public static void main(String[] args) {
        AdminAlarmas adminAlarmas = new AdminAlarmas();

        Alarma alarma1 = new Alarma(DiasSemana.LUNES, 8, 0);
        Alarma alarma2 = new Alarma(DiasSemana.MARTES, 7, 30);
        Alarma alarma3 = new Alarma(DiasSemana.MIERCOLES, 9, 15);

        adminAlarmas.agregarAlarma(alarma1);
        adminAlarmas.agregarAlarma(alarma2);
        adminAlarmas.agregarAlarma(alarma3);

        // Puedes agregar más alarmas aquí si lo deseas.

        // Obtener la lista de alarmas y mostrarlas
        System.out.println("Lista de Alarmas:");
        for (Alarma alarma : adminAlarmas.getAlarmas()) {
            System.out.println(alarma);
        }
    }
}
