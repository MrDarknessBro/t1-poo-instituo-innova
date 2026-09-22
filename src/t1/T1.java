/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author UCA40417
 */
public class T1 {
private List<Alumno> listaAlumnos = new ArrayList<>();

    public void agregarAlumno(Alumno objAlumno) {
        listaAlumnos.add(objAlumno);
    }

    public void listarAsistentes() {
        if (listaAlumnos.isEmpty()) {
            String rpta = "No hay alumnos registrados en el sistema.";
            System.out.println(rpta);
        } else {
            System.out.println("\n===== LISTA DE ALUMNOS REGISTRADOS =====");
            for (int i = 0; i < listaAlumnos.size(); i++) {
                String rpta = (i + 1) + ". " + listaAlumnos.get(i).toString();
                System.out.println(rpta);
            }
        }
    }
    
    public static void main(String[] args) {
       T1 controla = new T1();
        Scanner lector = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN - INSTITUTO INNOVA ---");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Listar todos los alumnos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(lector.nextLine());

                switch (opcion) {
                    case 1:
                        Alumno nuevoAlumno = new Alumno();
                        System.out.println("\n--- Registro de Nuevo Alumno ---");

                        while (true) {
                            try {
                                System.out.print("Ingrese nombre completo: ");
                                String nombre = lector.nextLine();
                                nuevoAlumno.setNombre(nombre);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("[Error]: " + e.getMessage() + " Intente de nuevo.");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Ingrese tipo de documento (DNI / Residencia): ");
                                String tipoDoc = lector.nextLine();
                                nuevoAlumno.setTipoDocumento(tipoDoc);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("[Error]: " + e.getMessage() + " Intente de nuevo.");
                            }
                        }

                        while (true) {
                            try {
                                String req = nuevoAlumno.getTipoDocumento().equals("DNI") ? "8 dígitos" : "11 dígitos";
                                System.out.print("Ingrese número de documento (" + req + "): ");
                                String numDoc = lector.nextLine();
                                nuevoAlumno.setNumeroDocumento(numDoc);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("[Error]: " + e.getMessage() + " Intente de nuevo.");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Ingrese nivel socioeconómico (A, B, C): ");
                                String inputNivel = lector.nextLine();
                                if (inputNivel.length() != 1) {
                                    throw new IllegalArgumentException("Debe ingresar únicamente un carácter.");
                                }
                                nuevoAlumno.setNivelSocioeconomico(inputNivel.charAt(0));
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("[Error]: " + e.getMessage() + " Intente de nuevo.");
                            }
                        }

                        while (true) {
                            try {
                                System.out.print("Ingrese tipo de beca (Ninguna, Parcial, Total): ");
                                String beca = lector.nextLine();
                                nuevoAlumno.setTipoBeca(beca);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println("[Error]: " + e.getMessage() + " Intente de nuevo.");
                            }
                        }

                        controla.agregarAlumno(nuevoAlumno);
                        System.out.println("¡Alumno registrado con éxito!");
                        break;

                    case 2:
                        controla.listarAsistentes();
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("[Error]: Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error]: Ingrese un número válido.");
            } catch (Exception e) {
                System.out.println("[Error]: " + e.getMessage());
            }

        } while (opcion != 3);

        lector.close();
    }
}