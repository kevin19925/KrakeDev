package krakedev.entidades;

import java.util.Random;

public class Ramdom {
    public static int obtenerPosicion() {
        Random random = new Random();
        return random.nextInt(52); // Genera un número aleatorio entre 0 y 51 (incluidos)
    }
}
