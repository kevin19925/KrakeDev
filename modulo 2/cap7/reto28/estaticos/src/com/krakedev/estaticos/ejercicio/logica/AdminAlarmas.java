package com.krakedev.estaticos.ejercicio.logica;


import com.krakedev.estaticos.ejercicio.entidades.Alarma;

import java.util.ArrayList;

public class AdminAlarmas {
    private ArrayList<Alarma> alarmas;

    public AdminAlarmas() {
        alarmas = new ArrayList<>();
    }

    public void agregarAlarma(Alarma alarma) {
        alarmas.add(alarma);
    }

    public ArrayList<Alarma> getAlarmas() {
        return alarmas;
    }
}
