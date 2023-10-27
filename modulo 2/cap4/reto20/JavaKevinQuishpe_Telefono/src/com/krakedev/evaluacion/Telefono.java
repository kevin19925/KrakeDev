package com.krakedev.evaluacion;

public class Telefono {
    private String numero;
    private String tipo;
    private String estado;

    public Telefono(String numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        if (validarTelefono(numero, tipo)) {
            this.estado = "C";
        } else {
            this.estado = "E";
        }
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
            if (tipo.equals("Movil") && numero.length() == 10) {
                return true;
            }
            if (( tipo.equals("Convencional")) && numero.length() == 7) {
                return true;
            }
            
        }
        return false;
    }
}
