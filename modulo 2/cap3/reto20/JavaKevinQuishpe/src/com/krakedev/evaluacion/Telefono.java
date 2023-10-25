package com.krakedev.evaluacion;

public class Telefono {
    private String numero;
    private String tipo;
    private String estado;

    public Telefono(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.estado = validarTelefono(numero, tipo) ? "C" : "E";
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    private boolean validarTelefono(String numero, String tipo) {
        if (numero != null && tipo != null) {
            if ((tipo.equals("Móvil") || tipo.equals("Convencional")) && numero.length() == 10) {
                return true;
            }
        }
        return false;
    }
}
