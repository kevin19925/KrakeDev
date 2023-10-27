package com.cmd.evaluacion;



public class Cuota {
    private int numero;
    private double cuota;
    private double capital;
    private double interes;
    private double abonoCapital;
    private double saldo;

    public Cuota(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAbonoCapital() {
        return abonoCapital;
    }

    public void setAbonoCapital(double abonoCapital) {
        this.abonoCapital = abonoCapital;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void mostrarPréstamo() {
        System.out.format("%d | %.2f | %.2f | %.2f | %.2f | %.2f%n", 
            numero, Utilitario.redondear(cuota), Utilitario.redondear(capital), 
            Utilitario.redondear(interes), Utilitario.redondear(abonoCapital), 
            Utilitario.redondear(saldo));
    }
}
