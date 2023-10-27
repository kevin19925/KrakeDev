package com.krakedev.evaluacion;
import java.util.ArrayList;

public class Contacto {
    private String cedula;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private ArrayList<Telefono> telefonos;

    public Contacto(String cedula, String nombre, String apellido, Direccion direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonos = new ArrayList<>();
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
    }

    public void mostrarTelefonos() {
        System.out.println("Teléfonos con estado 'C':");
        for (Telefono telefono : telefonos) {
            if ("C".equals(telefono.getEstado())) {
                System.out.println("Número: " + telefono.getNumero() + ", Tipo: " + telefono.getTipo());
            }
        }
    }
    
  

    public boolean tieneTelefonosCorrectos() {
     
        for (Telefono telefono : telefonos) {
            if ("C".equals(telefono.getEstado()) && telefono.getTipo().equals("Convencional"))  {
              return true;
            }
        }
        return false;
    }
    
    public void imprimir() {
        System.out.println("Información del Contacto:");
        System.out.println("Cédula: " + cedula);
        System.out.println("Nombre: " + nombre + " " + apellido);
        if (direccion != null) {
            System.out.println("Dirección:");
            System.out.println("Calle Principal: " + direccion.getCallePrincipal());
            System.out.println("Calle Secundaria: " + direccion.getCalleSecundaria());
        }
    }

    
    public ArrayList<Telefono> recuperarIncorrectos() {
        ArrayList<Telefono> incorrectos = new ArrayList<>();
        for (Telefono telefono : telefonos) {
            if ("E".equals(telefono.getEstado())) {
                incorrectos.add(telefono);
            }
        }
        return incorrectos;
    }
}
