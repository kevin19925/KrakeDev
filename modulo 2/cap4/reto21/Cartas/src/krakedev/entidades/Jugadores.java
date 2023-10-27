package krakedev.entidades;

import java.util.ArrayList;

public class Jugadores {
    private ArrayList<String> jugadores;

    public Jugadores() {
        jugadores = new ArrayList<>();
    }

    public ArrayList<String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<String> jugadores) {
        this.jugadores = jugadores;
    }
}
