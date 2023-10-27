package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.*;
import com.krakedev.estaticos.ejercicio.logica.*;
import com.krakedev.estaticos.ejercicio.utils.*;

public class TestAlarmas1 {
    public static void main(String[] args) {
        AdminAlarmas adminAlarmas = new AdminAlarmas();

        Alarma alarma1 = new Alarma(DiasSemana.LUNES, 5, 45);
        Alarma alarma2 = new Alarma(DiasSemana.MARTES, 7, 30);
        Alarma alarma3 = new Alarma(DiasSemana.MIERCOLES, 9, 15);

        adminAlarmas.agregarAlarma(alarma1);
        adminAlarmas.agregarAlarma(alarma2);
        adminAlarmas.agregarAlarma(alarma3);

        ArrayList<Alarma> alarmasActuales = adminAlarmas.getAlarmas();

        System.out.println("Lista de Alarmas:");
        for (Alarma alarma : alarmasActuales) {
            System.out.println(alarma);
        }
    }
}
