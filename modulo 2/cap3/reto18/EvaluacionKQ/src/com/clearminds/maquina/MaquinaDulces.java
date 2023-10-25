package com.clearminds.maquina;
import java.util.ArrayList;

import com.clearminds.componentes.*;

public class MaquinaDulces {

    private ArrayList<Celda> Celdas ;
 
    private double Saldo;

    public MaquinaDulces() {
    	
    	this.Celdas=new ArrayList<Celda>();
    }

    public void agregarCelda(Celda cel) {
       this.Celdas.add(cel);
    }



    public void mostrarConfiguracion() {
  
        
        for (Celda celda : Celdas) {
        	 System.out.println("Celda : " + celda.getCodigo());
		}
    }

    public Celda buscarCelda(String codigoCelda) {
       
        
	        for (Celda celda : Celdas) {
	        	 if ( celda.getCodigo().equals(codigoCelda)) {
	                 return celda;
			}
	        	 
	        
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
      
        
        for (Celda celda : Celdas) {
            mostrarCelda(celda);
    }
        System.out.println("\n Saldo actual: " + this.Saldo);
    }

    private void mostrarCelda(Celda celda) {
        System.out.print("\n CELDA " + celda.getCodigo());
        System.out.print(" Stock: " + celda.getStock());

        if (celda.getProducto() != null) {
            System.out.print(" Producto: " + celda.getProducto().getNombre());
            System.out.print(" Precio: " + celda.getProducto().getPrecio() +"");
           // System.out.println("Código Producto: " + celda.getProducto().getCodigo());
        } else {
            System.out.print(" Sin Producto Asigando");
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
    	 for (Celda celda : Celdas) {
    		 if (celda.getProducto() != null) {
    			
    		 if ( celda.getProducto().getCodigo().equals(codigoProducto) ) {
    		
                 return celda;
    		 }
     }
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
//            System.out.println("Venta realizada. Cambio a entregar: " + cambio);
//            System.out.println("Saldo actual: " + this.Saldo);
            return cambio;
        } else {
            System.out.println("No se pudo realizar la venta. Celda vacía o no existe.");
            return ingresoCliente;
        }
    }
    
    
    public ArrayList<Producto> buscarMenores(double limite) {
    	
    	ArrayList<Producto> menores =new ArrayList<Producto>();
    	for (Celda cel : Celdas) {
    		if(cel.getProducto()!=null) {
			if(cel.getProducto().getPrecio()<limite) {
				menores.add(cel.getProducto());
				
			}}
		}
    	
    	return menores;
    }
}
