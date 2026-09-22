/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author UCA40417
 */
public class T1 {
 
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        int opcion = 0;
        
        do {
            System.out.println("\n=== Sistema Instituto Innova ===");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("Opcion de registro seleccionada.");
                        break;
                    case 2:
                        System.out.println("Listando alumnos...");
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
}