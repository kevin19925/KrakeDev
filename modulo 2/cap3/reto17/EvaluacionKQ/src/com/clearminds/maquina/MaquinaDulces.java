package com.clearminds.maquina;
import com.clearminds.componentes.*;

public class MaquinaDulces {

    private Celda Celda1;
    private Celda Celda2;
    private Celda Celda3;
    private Celda Celda4;
    private double Saldo;

    public MaquinaDulces() {
    }

    public void configurarMaquina(String codigoCelda1, String codigoCelda2, String codigoCelda3, String codigoCelda4) {
        this.Celda1 = new Celda(codigoCelda1);
        this.Celda2 = new Celda(codigoCelda2);
        this.Celda3 = new Celda(codigoCelda3);
        this.Celda4 = new Celda(codigoCelda4);
    }

    public void mostrarConfiguracion() {
        System.out.println("Celda 1: " + this.Celda1.getCodigo());
        System.out.println("Celda 2: " + this.Celda2.getCodigo());
        System.out.println("Celda 3: " + this.Celda3.getCodigo());
        System.out.println("Celda 4: " + this.Celda4.getCodigo());
    }

    public Celda buscarCelda(String codigoCelda) {
        if (this.Celda1 != null && this.Celda1.getCodigo().equals(codigoCelda)) {
            return this.Celda1;
        } else if (this.Celda2 != null && this.Celda2.getCodigo().equals(codigoCelda)) {
            return this.Celda2;
        } else if (this.Celda3 != null && this.Celda3.getCodigo().equals(codigoCelda)) {
            return this.Celda3;
        } else if (this.Celda4 != null && this.Celda4.getCodigo().equals(codigoCelda)) {
            return this.Celda4;
        }
        return null;
    }

    public void cargarProducto(Producto producto, String codigoCelda, int stockInicial) {
        Celda celdaRecuperada = buscarCelda(codigoCelda);
        if (celdaRecuperada != null) {
            celdaRecuperada.ingresarProducto(producto, stockInicial);
        }
    }

    public void mostrarProductos() {
        mostrarCelda(this.Celda1);
        mostrarCelda(this.Celda2);
        mostrarCelda(this.Celda3);
        mostrarCelda(this.Celda4);
    }

    private void mostrarCelda(Celda celda) {
        System.out.println("***********CELDA " + celda.getCodigo());
        System.out.println("Saldo: " + this.Saldo);
        System.out.println("Stock: " + celda.getStock());

        if (celda.getProducto() != null) {
            System.out.println("Nombre Producto: " + celda.getProducto().getNombre());
            System.out.println("Precio Producto: " + celda.getProducto().getPrecio());
            System.out.println("Código Producto: " + celda.getProducto().getCodigo());
        } else {
            System.out.println("La celda no tiene producto!!!");
        }
    }

    public Producto buscarProductoEnCelda(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null) {
            return celda.getProducto();
        }
        return null;
    }

    public double consultarPrecio(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null) {
            return celda.getProducto().getPrecio();
        }
        return 0.0;
    }

    public Celda buscarCeldaProducto(String codigoProducto) {
        if (this.Celda1 != null && this.Celda1.getProducto() != null && this.Celda1.getProducto().getCodigo().equals(codigoProducto)) {
            return this.Celda1;
        } else if (this.Celda2 != null && this.Celda2.getProducto() != null && this.Celda2.getProducto().getCodigo().equals(codigoProducto)) {
            return this.Celda2;
        } else if (this.Celda3 != null && this.Celda3.getProducto() != null && this.Celda3.getProducto().getCodigo().equals(codigoProducto)) {
            return this.Celda3;
        } else if (this.Celda4 != null && this.Celda4.getProducto() != null && this.Celda4.getProducto().getCodigo().equals(codigoProducto)) {
            return this.Celda4;
        }
        return null;
    }

    public void incrementarProductos(String codigoProducto, int cantidad) {
        Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
        if (celdaEncontrada != null) {
            celdaEncontrada.incrementarStock(cantidad);
        }
    }

    public void vender(String codigoCelda) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getStock() > 0) {
            celda.disminuirStock(1);
            double precioProducto = celda.getProducto().getPrecio();
            this.Saldo += precioProducto;
            System.out.println("Venta realizada. Saldo actual: " + this.Saldo);
        } else {
            System.out.println("No se pudo realizar la venta. Celda vacía o no existe.");
        }
    }

    public double venderConCambio(String codigoCelda, double ingresoCliente) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getStock() > 0) {
            celda.disminuirStock(1);
            double precioProducto = celda.getProducto().getPrecio();
            this.Saldo += precioProducto;
            double cambio = ingresoCliente - precioProducto;
            System.out.println("Venta realizada. Cambio a entregar: " + cambio);
            System.out.println("Saldo actual: " + this.Saldo);
            return cambio;
        } else {
            System.out.println("No se pudo realizar la venta. Celda vacía o no existe.");
            return ingresoCliente;
        }
    }
}
