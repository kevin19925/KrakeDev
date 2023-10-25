package com.krakedev.evaluacion;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Directorio {
    private ArrayList<Contacto> contactos;
    private Date fechaModificacion;
    private ArrayList<Contacto> correctos ;
    private ArrayList<Contacto> incorrectos ;
    public Directorio() {
        contactos = new ArrayList<>();
        fechaModificacion = new Date();
    }


    
    public boolean agregarContacto(Contacto contacto) {
        if (contacto != null) {
            String cedula = contacto.getCedula();
            if (buscarPorCedula(cedula) == null) {
                contactos.add(contacto);
           
                return true;
            }
        }
        return false;
    }


    public Contacto buscarPorCedula(String cedula) {
        for (Contacto contacto : contactos) {
            if (contacto.getCedula() != null && contacto.getCedula().equals(cedula)) {
                return contacto;
            }
        }
        return null; // No se encontró el contacto
    }
    
    public String consultarUltimaModificacion() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formatoFecha.format(fechaModificacion);
    }
    
    
    public int contarPerdidos() {
        int contador = 0;
        for (Contacto contacto : contactos) {
            if (contacto.getDireccion() == null) {
                contador++;
            }
        }
        return contador;
    }
    public int contarFijos() {
        int contador = 0;
        for (Contacto contacto : contactos) {
            if ( contacto.tieneTelefonosCorrectos()) {
                contador++;
            }
        }
        return contador;
    }
    
    public void depurar() {
        ArrayList<Contacto> correctos = new ArrayList<>();
        ArrayList<Contacto> incorrectos = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getDireccion() != null) {
                correctos.add(contacto);
            } else {
                incorrectos.add(contacto);
            }
        }

        // Vaciar la lista de contactos original
        contactos.clear();
        
        // Asignar las listas correctos e incorrectos a los atributos correspondientes
        this.correctos = correctos;
        this.incorrectos = incorrectos;
    }



	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}



	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}



	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}



	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}



	public ArrayList<Contacto> getContactos() {
		return contactos;
	}



	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

    

}
