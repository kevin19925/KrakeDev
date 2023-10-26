package com.cmd.evaluacion;

public class CalculadoraAmortizacion {
	
	  public static void generarTabla(Prestamo préstamo) {
		  Cuota[] cuotas = préstamo.getCuotas();
	        double capitalInicial = préstamo.getMonto();
	        double cuotaMensual = calcularCuota(préstamo);
	        double saldoAnterior = capitalInicial;

	        for (int i = 0; i < cuotas.length; i++) {
	            cuotas[i] = new Cuota(i + 1);
	            cuotas[i].setCuota(cuotaMensual);
	            cuotas[i].setCapital(saldoAnterior);
	            double interes = (saldoAnterior * préstamo.getInteres()) / 12 / 100;
	            cuotas[i].setInteres(interes);
	            cuotas[i].setAbonoCapital(cuotaMensual - interes);
	            double saldoActual = saldoAnterior - cuotas[i].getAbonoCapital();
	            cuotas[i].setSaldo(saldoActual);
	            saldoAnterior = saldoActual;
	        }
	    }
	
    public static double calcularCuota(Prestamo préstamo) {
        double monto = préstamo.getMonto();
        double interesMensual = préstamo.getInteres() / 12 / 100; // Tasa de interés mensual
        int plazoMeses = préstamo.getPlazo();

        double cuota = (monto * interesMensual )
                     / (1-Math.pow(1 + interesMensual, -plazoMeses) );

        return cuota;
    }
    
    private static void calcularValoresCuota(Prestamo préstamo, Cuota[] cuotas) {
        for (int i = 0; i < cuotas.length; i++) {
            Cuota cuotaActual = cuotas[i];
            double interes = (cuotaActual.getSaldo() * préstamo.getInteres()) / 12 / 100;
            double abonoCapital = cuotaActual.getCuota() - interes;

            cuotaActual.setInteres(interes);
            cuotaActual.setAbonoCapital(abonoCapital);

            if (i < cuotas.length - 1) {
                cuotas[i + 1].setSaldo(cuotas[i].getSaldo() - abonoCapital);
            }
        }
    
    }
    
    public static void mostrarTabla(Prestamo préstamo) {
        Cuota[] cuotas = préstamo.getCuotas();
        System.out.println("Número | Cuota | Inicio | Interés | Abono | Saldo");
        
        for (Cuota cuota : cuotas) {
            System.out.format("%d | %.2f | %.2f | %.2f | %.2f | %.2f%n",
                cuota.getNumero(), cuota.getCuota(), cuota.getCapital(),
                cuota.getInteres(), cuota.getAbonoCapital(), cuota.getSaldo());
        }
    }
}
