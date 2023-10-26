package krakedev.servicios;
import krakedev.entidades.*;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Naipe naipe;
    private ArrayList<ArrayList<Carta>> cartasJugadores;
    private ArrayList<Carta> naipeBarajado;

    public Juego(ArrayList<String> idsjugadores) {
        this.naipe = new Naipe();
        this.naipeBarajado = naipe.barajar(); // Barajamos el naipe y guardamos el resultado

        cartasJugadores = new ArrayList<ArrayList<Carta>>();

        for (String id : idsjugadores) {
            ArrayList<Carta> cartasJugador = new ArrayList<Carta>();
            cartasJugadores.add(cartasJugador);
        }
    }
    
    
    
    
    

    public ArrayList<ArrayList<Carta>> getCartasJugadores() {
		return cartasJugadores;
	}

	
	public ArrayList<Carta> getCartasJugador(int jugador) {
        if (jugador >= 0 && jugador < cartasJugadores.size()) {
            return cartasJugadores.get(jugador);
        } else {
            return null; // Jugador no válido
        }
    }

    public void entregarCartas(int cartasPorJugador) {
        int numJugadores = cartasJugadores.size();
        int cartaActual = 0;

        for (int i = 0; i < cartasPorJugador; i++) {
            for (int j = 0; j < numJugadores; j++) {
                if (cartaActual < naipeBarajado.size()) {
                    cartasJugadores.get(j).add(naipeBarajado.get(cartaActual));
                    cartaActual++;
                }
            }
        }
    }
    
    
    public int devolverTotal(int jugador) {
    	
    	ArrayList<Carta> cartas= getCartasJugador(jugador);
    	
    	int suma=0;
    	
    	for (Carta carta : cartas) {
			suma+=carta.getNumero().getValor();
		}
    	
    	return suma;
    
    }
    
    
    public String determinarGanador() {
        int idGanador = 0;
        int sumaGanador = devolverTotal(0); // Obtener el total del primer jugador

        for (int i = 1; i < cartasJugadores.size(); i++) {
            int sumaActual = devolverTotal(i); // Obtener el total del jugador actual

            if (sumaActual >= sumaGanador) {
                idGanador = i; // Actualizar el id del ganador
                sumaGanador = sumaActual; // Actualizar la suma del ganador
            }
        }

        return "jugador "+(idGanador+1);
    }

}
