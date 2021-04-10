/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.io.Serializable;

/**
 *
 * @author SmartUrban2025
 */
public class Tarjeta implements Serializable{
    static final long serialVersionUID=42L;
    private int nrotarjeta;
    private int nrocuenta;
    private double saldo;
    private String estado;
    
    public void MostrarTarjeta(){
        System.out.println("Nro. de Tarjeta: "                +this.nrotarjeta);
        System.out.println("Nro. de Cuenta: "                 +this.nrocuenta);
        System.out.println("Saldo de la tarjeta: "            +this.saldo);
        System.out.println("Estado de la tarjeta: "           +this.estado);
    }

    public int getNrotarjeta() {
        return nrotarjeta;
    }

    public void setNrotarjeta(int nrotarjeta) {
        this.nrotarjeta = nrotarjeta;
    }

    public int getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(int nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
