package krakedev.entidades;

import java.util.ArrayList;
import java.util.List;

public class Naipe {
    private List<Numero> numerosPosibles;
    private List<Carta> cartas;


    public Naipe() {
    
        numerosPosibles = new ArrayList<>();
        cartas = new ArrayList<>();

        // Agregar los 13 números del naipe con su información
        numerosPosibles.add(new Numero("A", 11));
        numerosPosibles.add(new Numero("2", 2));
        numerosPosibles.add(new Numero("3", 3));
        numerosPosibles.add(new Numero("4", 4));
        numerosPosibles.add(new Numero("5", 5));
        numerosPosibles.add(new Numero("6", 6));
        numerosPosibles.add(new Numero("7", 7));
        numerosPosibles.add(new Numero("8", 8));
        numerosPosibles.add(new Numero("9", 9));
        numerosPosibles.add(new Numero("10", 10));
        numerosPosibles.add(new Numero("J", 10));
        numerosPosibles.add(new Numero("Q", 10));
        numerosPosibles.add(new Numero("K", 10));

        // Crear las cartas del naipe
        for (Numero numero : numerosPosibles) {
            cartas.add(new Carta(numero, Palos.CORAZON_NEGRO)); 
            cartas.add(new Carta(numero, Palos.CORAZON_ROJO)); 
            cartas.add(new Carta(numero, Palos.DIAMANTE));
            cartas.add(new Carta(numero, Palos.TREBOL)); 
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }
    
    public ArrayList<Carta> barajar() {
        for (Carta carta : cartas) {
            carta.setEstado("N");
        }

        ArrayList<Carta> auxiliar = new ArrayList<Carta>();
        for (int i = 1; i <= 100; i++) {
            int posicion = Ramdom.obtenerPosicion();
            Carta carta = cartas.get(posicion);
            if (carta.getEstado().equals("N")) {
                auxiliar.add(carta);
                carta.setEstado("C");
            }
        }

        for (Carta carta : cartas) {
            if (carta.getEstado().equals("N")) {
                auxiliar.add(carta);
                carta.setEstado("C");
            }
        }

        return auxiliar;
    }
    
}
