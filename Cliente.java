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
public class Cliente implements Serializable{
    static final long serialVersionUID=43L;
    private String nom;
    private String pat;
    private String mat;
    private int ci;
    private Tarjeta tarjeta;
    
    public void MostrarCliente(){
        System.out.println("Nombre: "       +this.nom);
        System.out.println("Paterno: "      +this.pat);
        System.out.println("Materno: "      +this.mat);
        System.out.println("       TARJETA        ");
        if(tarjeta!=null){
            tarjeta.MostrarTarjeta();
        }else{
            System.out.println("        EL CLIENTE NO CUENTA CON UNA TARJETA...     ");
            System.out.println("");
        }
        System.out.println("-------------------------------");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
