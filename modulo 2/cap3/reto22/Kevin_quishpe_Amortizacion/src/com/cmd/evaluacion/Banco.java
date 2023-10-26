package com.cmd.evaluacion;


import java.util.ArrayList;



public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Prestamo> prestamos;

    public Banco() {
        clientes = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCedula()) == null) {
            clientes.add(cliente);
            cliente.mostrarCliente();
        } else {
            System.out.println("Cliente ya existe: " + cliente.getNombre() + " " + cliente.getApellido() +
                    "[cedula=" + cliente.getCedula() + "]");
        }
    }

    public void asignarPrestamo(String cedula, Prestamo prestamo) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.println("No es cliente del banco");
        } else {
            prestamos.add(prestamo);
            System.out.println("Préstamo asignado a " + cliente.getNombre() + " " + cliente.getApellido());
        }
    }

    public ArrayList<Prestamo> buscarPrestamos(String cedula) {
        ArrayList<Prestamo> prestamosCliente = new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCliente().getCedula().equals(cedula)) {
                prestamosCliente.add(prestamo);
            }
        }
        if (prestamosCliente.isEmpty()) {
            return null;
        } else {
            return prestamosCliente;
        }
    }


    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
    
    
}
