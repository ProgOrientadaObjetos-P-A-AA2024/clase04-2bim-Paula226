/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class Ejecutor2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Arriendo> listaArriendos = new ArrayList<>();
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("Seleccione el tipo de arriendo a ingresar:");
            System.out.println("1. Arriendo de Comida");
            System.out.println("2. Arriendo Comercial");
            System.out.println("3. Arriendo de Sesiones");
            System.out.println("0. Terminar y mostrar resultados");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Ingrese el nombre del arrendatario:");
                    String nombreComida = scanner.nextLine();
                    System.out.println("Ingrese el valor base del arriendo:");
                    double valorBaseComida = scanner.nextDouble();
                    System.out.println("Ingrese el IVA (en porcentaje):");
                    double iva = scanner.nextDouble();
                    System.out.println("Ingrese el valor del agua:");
                    double valorAgua = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la luz:");
                    double valorLuz = scanner.nextDouble();
                    
                    ArriendoLocalComida arriendoComida = new ArriendoLocalComida(nombreComida, valorBaseComida);
                    arriendoComida.establecerIva(iva);
                    arriendoComida.establecerValorAgua(valorAgua);
                    arriendoComida.establecerValorLuz(valorLuz);
                    listaArriendos.add(arriendoComida);
                    break;
                    
                case 2:
                    scanner.nextLine(); 
                    System.out.println("Ingrese el nombre del arrendatario:");
                    String nombreComercial = scanner.nextLine();
                    System.out.println("Ingrese el valor base del arriendo:");
                    double valorBaseComercial = scanner.nextDouble();
                    System.out.println("Ingrese el valor adicional fijo:");
                    double valorAdicional = scanner.nextDouble();
                    
                    ArriendoLocalComercial arriendoComercial = new ArriendoLocalComercial(nombreComercial, valorBaseComercial);
                    arriendoComercial.establecerValorAdicionalFijo(valorAdicional);
                    listaArriendos.add(arriendoComercial);
                    break;
                    
                case 3:
                    scanner.nextLine(); 
                    System.out.println("Ingrese el nombre del arrendatario:");
                    String nombreSesiones = scanner.nextLine();
                    System.out.println("Ingrese el valor base del arriendo:");
                    double valorBaseSesiones = scanner.nextDouble();
                    System.out.println("Ingrese el valor de las sillas:");
                    double valorSillas = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la amplificación:");
                    double valorAmplificacion = scanner.nextDouble();
                    
                    ArriendoLocalSesiones arriendoSesiones = new ArriendoLocalSesiones(nombreSesiones, valorBaseSesiones);
                    arriendoSesiones.establecerValorSillas(valorSillas);
                    arriendoSesiones.establecerValorAmplificacion(valorAmplificacion);
                    listaArriendos.add(arriendoSesiones);
                    break;
                    
                case 0:
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
                    break;
            }
        }
        
        for (int i = 0; i < listaArriendos.size(); i++) {
            listaArriendos.get(i).establecerArriendoMensual();
        }
        
        CentroComercial centro = new CentroComercial("La Pradera", listaArriendos);
        centro.establecerTotalArriendosBaseMensual();
        centro.establecerTotalArriendosFinalMensual();
        System.out.println(centro);
    }
}