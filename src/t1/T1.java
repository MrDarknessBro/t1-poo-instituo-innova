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
            System.out.println("\n========================================");
            System.out.println("   SISTEMA DE GESTION - INSTITUTO INNOVA");
            System.out.println("========================================");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Mostrar lista de alumnos y pensiones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRO DE ALUMNO ---");
                        try {
                            System.out.print("Ingrese nombre completo: ");
                            String nombre = scanner.nextLine();
                            
                            System.out.print("Ingrese tipo de documento (DNI / Residencia): ");
                            String tipoDoc = scanner.nextLine();
                            
                            System.out.print("Ingrese número de documento: ");
                            String numDoc = scanner.nextLine();
                            
                            System.out.print("Ingrese nivel socioeconómico (A, B, C): ");
                            char nivel = scanner.nextLine().charAt(0);
                            
                            System.out.print("Ingrese tipo de beca (Ninguna, Parcial, Total): ");
                            String beca = scanner.nextLine();
                            
                            Alumno nuevoAlumno = new Alumno(nombre, tipoDoc, numDoc, nivel, beca);
                            listaAlumnos.add(nuevoAlumno);
                            System.out.println(" ¡Alumno registrado exitosamente!");
                            
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error de validación: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ocurrió un error inesperado al registrar el alumno.");
                        }
                        break;
                        
                    case 2:
                        System.out.println("\n--- LISTA DE ALUMNOS REGISTRADOS ---");
                        if (listaAlumnos.isEmpty()) {
                            System.out.println("No hay alumnos registrados en el sistema.");
                        } else {
                            for (int i = 0; i < listaAlumnos.size(); i++) {
                                System.out.println((i + 1) + ". " + listaAlumnos.get(i));
                            }
                        }
                        break;
                        
                    case 3:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        break;
                        
                    default:
                        System.out.println("Opción inválida. Intente entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            }
            
        } while (opcion != 3);
        
        scanner.close();
    }
}