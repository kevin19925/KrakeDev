package com.clearminds.componentes;

public class Producto {
    private String Nombre;
    private double Precio;
    private String Codigo;

    public Producto(String codigo, String nombre, double precio) {
        this.Codigo = codigo;
        this.Nombre = nombre;
        this.Precio = precio;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getCodigo() {
        return this.Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public void setPrecio(double precio) {
        this.Precio = precio;
    }

    public void incrementarPrecio(int porcentaje) {
        double incremento = this.Precio * porcentaje / 100.0;
        this.Precio += incremento;
    }

    public void disminuirPrecio(double descuento) {
        this.Precio -= descuento;
    }

    public double getPrecio() {
        return this.Precio;
    }
}
