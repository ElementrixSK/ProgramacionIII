/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SmartUrban2025
 */
public class OperacionesTarjeta {
    List<Cliente> ListaCliente;
    Scanner leer = new Scanner(System.in);
     public OperacionesTarjeta() {
        ListaCliente = new ArrayList<>();
    
    }
     
    public void AñadirClienteTarjeta(){
        Cliente cli = new Cliente();
        Tarjeta tar = new Tarjeta();
        System.out.print("Ingrese su Nombre                      : ");
        cli.setNom(leer.nextLine());
        System.out.print("Ingrese Apellido Paterno               : ");
        cli.setPat(leer.nextLine());
        System.out.print("Ingrese Apellido Materno               : ");
        cli.setMat(leer.nextLine());
        System.out.print("Ingrese el Nro. de Cedula de Identidad : ");
        cli.setCi(leer.nextInt());
        System.out.println("--------------------------------------");
        System.out.print("Ingrese Nro. tarjeta        : ");
        tar.setNrotarjeta(leer.nextInt());
        System.out.print("Ingrese Nro. Cuenta         : ");
        tar.setNrocuenta(leer.nextInt());
        System.out.print("Ingrese Saldo de la tarjeta : ");
        tar.setSaldo(leer.nextDouble());
        tar.setEstado("ACTIVO");
        cli.setTarjeta(tar);
        ListaCliente.add(cli);
        System.out.println("        REGISTRO REALIZADO CON EXITO        ");
        
    }
    
    public void MostrarCliente(){
        if(ListaCliente!=null){
            System.out.println("            CLIENTES ACTIVOS            ");
            for(Cliente cliAux:ListaCliente){
                cliAux.MostrarCliente();
            }
        }
        System.out.println("");
    }
    
    public void ModificarEstado(int ci){
        int x=0;
        if(ListaCliente!=null){
            for(Cliente cliente:ListaCliente){
                if(cliente.getCi()==ci){
                    x=1;
                    cliente.getTarjeta().setEstado("INACTIVO");
                    System.out.println("        LA TARJETA HA SIDO BLOQUEADA!!!        ");
                    System.out.println("");
                }
            }
            if(x==0){
                System.out.println("        EL CLIENTE NO ESTA REGISTRADO!!!       ");
                System.out.println("");
            }
        }
    }
    
    public void Depositar(int c,double m){
        int x=0;
        if(ListaCliente!=null){
            for(Cliente cliente:ListaCliente){
                if(cliente.getCi()==c){
                    x=1;
                    if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                        double saldo=cliente.getTarjeta().getSaldo();
                        saldo=saldo+m;
                        cliente.getTarjeta().setSaldo(saldo);
                        System.out.println("        DEPOSITO REALIZADO CON EXITO...     ");
                        System.out.println("");
                    }else{
                        System.out.println("        LA TARJETA SE ENCUENTRA BLOQUEADA!!!        ");
                        System.out.println("");
                    }
                }
            }
            if(x==0){
                System.out.println("        EL CLIENTE NO ESTA REGISTRADO!!!        ");
                System.out.println("");
            }
        }
    }
    
    public void Retirar(int ced,double cantidad){
        int x=0;
        if(ListaCliente!=null){
            for(Cliente cliente:ListaCliente){
                if(cliente.getCi()==ced){
                    x=1;
                    if(cliente.getTarjeta().getEstado().equals("ACTIVO")){
                        if(cliente.getTarjeta().getSaldo() > cantidad){
                            double saldo = cliente.getTarjeta().getSaldo() - cantidad;
                            cliente.getTarjeta().setSaldo(saldo);
                            System.out.println("        RETIRO REALIZADO CON EXITO!!!       ");
                            System.out.println("");
                        }else{
                            double s = cliente.getTarjeta().getSaldo();
                            System.out.println("        NO SE PUDO RETIRAR EL MONTO, SALDO INSUFICIENTE!!!      ");
                            System.out.println("        SALDO ACTUAL: " + s);
                            System.out.println("");
                        }
                    }else{
                        System.out.println("        LA TARJETA SE ENCUENTRA BLOQUEADA!!!        ");
                        System.out.println("");
                    }
                }
            }
            if(x==0){
                System.out.println("        EL CLIENTE NO ESTA REGISTRADO!!!        ");
                System.out.println("");
            }
        }
    }
    
    
    public void CrearArchivo(){
        Path path=Paths.get("C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoCliente.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("        ARCHIVO CREADO CON EXITO...     ");
                System.out.println("");
            }else{
                System.out.println("        EL ARCHIVO YA EXISTE...     ");
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }
    
    public void AlmacenarDatos(){
        String location="C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoCliente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(location);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(ListaCliente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
    
    public void LeerClientes(){
        String location="C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoCliente.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if(ois!=null){
                ListaCliente=(List<Cliente>)ois.readObject();
            }else{
                System.out.println("        EL OBJETO ES NULO       ");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
}
