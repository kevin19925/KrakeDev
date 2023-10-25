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
       this. Celda1 = new Celda (codigoCelda1);
       this. Celda2 = new Celda (codigoCelda2);
       this. Celda3 =new Celda (codigoCelda3);
       this.  Celda4 = new Celda (codigoCelda4);
    }
    
    public void mostrarConfiguracion() {
        System.out.println("Celda 1: " + Celda1.getCodigo());
        System.out.println("Celda 2: " + Celda2.getCodigo());
        System.out.println("Celda 3: " + Celda3.getCodigo());
        System.out.println("Celda 4: " + Celda4.getCodigo());
       // System.out.println("Saldo actual: " + Saldo);
    }
    public Celda buscarCelda(String codigoCelda) {
        if (Celda1 != null && Celda1.getCodigo().equals(codigoCelda)) {
            return Celda1;
        } else if (Celda2 != null && Celda2.getCodigo().equals(codigoCelda)) {
            return Celda2;
        } else if (Celda3 != null && Celda3.getCodigo().equals(codigoCelda)) {
            return Celda3;
        } else if (Celda4 != null && Celda4.getCodigo().equals(codigoCelda)) {
            return Celda4;
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
        mostrarCelda(Celda1);
        mostrarCelda(Celda2);
        mostrarCelda(Celda3);
        mostrarCelda(Celda4);
     
    }


    private void mostrarCelda(Celda celda) {
        System.out.println("***********CELDA " + celda.getCodigo());
        System.out.println("Saldo: " + Saldo);
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
        return 0.0; // Cambiar el valor de retorno si es necesario indicar que la celda no existe
    }
    
    public Celda buscarCeldaProducto(String codigoProducto) {
        if (Celda1 != null && Celda1.getProducto() != null && Celda1.getProducto().getCodigo().equals(codigoProducto)) {
            return Celda1;
        } else if (Celda2 != null && Celda2.getProducto() != null && Celda2.getProducto().getCodigo().equals(codigoProducto)) {
            return Celda2;
        } else if (Celda3 != null && Celda3.getProducto() != null && Celda3.getProducto().getCodigo().equals(codigoProducto)) {
            return Celda3;
        } else if (Celda4 != null && Celda4.getProducto() != null && Celda4.getProducto().getCodigo().equals(codigoProducto)) {
            return Celda4;
        }
        return null;
    }
    // Método para incrementar la cantidad de productos en una celda
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
            Saldo += precioProducto;
            System.out.println("Venta realizada. Saldo actual: " + Saldo);
        } else {
            System.out.println("No se pudo realizar la venta. Celda vacía o no existe.");
        }
    }

   
    public double venderConCambio(String codigoCelda, double ingresoCliente) {
        Celda celda = buscarCelda(codigoCelda);
        if (celda != null && celda.getStock() > 0) {
            celda.disminuirStock(1);
            double precioProducto = celda.getProducto().getPrecio();
            Saldo += precioProducto;
            double cambio = ingresoCliente - precioProducto;
            System.out.println("Venta realizada. Cambio a entregar: " + cambio);
            System.out.println("Saldo actual: " + Saldo);
            return cambio;
        } else {
            System.out.println("No se pudo realizar la venta. Celda vacía o no existe.");
            return ingresoCliente; 
        }
    }

}
