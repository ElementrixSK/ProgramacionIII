/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

import java.util.Scanner;

/**
 *
 * @author SmartUrban2025
 */
public class PrincipalTarjeta {
    public static void main(String[] args) {
        int x = 0;
        boolean seguir = true;
        OperacionesTarjeta ot = new OperacionesTarjeta();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("                MENU DE OPCIONES            ");
            System.out.println("    1. Crear Archivo                        ");
            System.out.println("    2. Registrar Cliente - Tarjeta          ");
            System.out.println("    3. Guardar los Datos                    ");
            System.out.println("    4. Mostrar Datos                        "); 
            System.out.println("    5. Bloquear Tarjeta                     ");
            System.out.println("    6. Depositar                            ");
            System.out.println("    7. Retirar                              ");
            System.out.println("    8. Cerrar el programa                   ");
            System.out.println("                                            ");
            System.out.print("      Elija una opcion:                       ");
            x = leer.nextInt();
            System.out.println("--------------------------------------------");
            switch (x) {
                case 1:
                    ot.CrearArchivo();
                    break;
                case 2:
                    String r = "S";
                    while(r.equalsIgnoreCase("S")){
                        leer.nextLine();
                        ot.AñadirClienteTarjeta();
                        System.out.print("¿Continuar registrando clientes?   S/N   : ");
                        r = leer.nextLine();
                        System.out.println("");
                    }                    
                    break;
                case 3:
                    ot.AlmacenarDatos();
                    System.out.println("        DATOS ALMACENADOS CON EXITO!!!      ");
                    System.out.println("");
                    break;
                case 4:
                    ot.LeerClientes();
                    ot.MostrarCliente();
                    break;
                case 5:
                    ot.LeerClientes();
                    System.out.print("Ingrese numero de Cedula de Identidad: ");
                    int ci = leer.nextInt();
                    ot.ModificarEstado(ci);
                    ot.AlmacenarDatos();
                    break;
                case 6:
                    ot.LeerClientes();
                    System.out.print("Ingrese numero de Cedula de Identidad: ");
                    int c = leer.nextInt();
                    System.out.print("Ingrese el monto a depositar: ");
                    double m = leer.nextDouble();
                    ot.Depositar(c, m);
                    ot.AlmacenarDatos();
                    break;
                case 7:
                    ot.LeerClientes();
                    System.out.print("Ingrese numero de Cedula de Identidad: ");
                    int ced = leer.nextInt();
                    System.out.print("Ingrese el monto a retirar: ");
                    double cantidad = leer.nextDouble();
                    ot.Retirar(ced, cantidad);
                    ot.AlmacenarDatos();
                    break;
                default:
                    seguir = false;
                    break;
            }
        } while (seguir);
    }
}
