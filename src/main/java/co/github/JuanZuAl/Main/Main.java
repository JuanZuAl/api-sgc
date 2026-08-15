/**package co.github.JuanZuAl.Main;

import java.util.Scanner;

public class Main {
    // menu
    public static void main(String[] args) {
        do {
            System.out.println("Bienvenidos al menú de la aplicación");
            System.out.println("1.Estudiantes");
            System.out.println("2.Cursos");
            System.out.println("3.Matriculas");
            System.out.println("0.Salir");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Estudiantes");
                    do {
                        System.out.println("1. Crear estudiante");
                        System.out.println("2. Encontrar por ID de estudiante");
                        System.out.println("3. Listar todos los estudiantes");
                        System.out.println("4. Actualizar estudiante");
                        System.out.println("5. Eliminar estudiante");
                        System.out.println("0. Volver al menu");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado Crear estudiante");
                                break;
                            case 2:
                                System.out.println("Has seleccionado Encontrar por ID de estudiante");
                                break;
                            case 3:
                                System.out.println("Has seleccionado Listar todos los estudiantes");
                                break;
                            case 4:
                                System.out.println("Has seleccionado Actualizar estudiante");
                                break;
                            case 5:
                                System.out.println("Has seleccionado Eliminar estudiante");
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal");
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    }while (opcion != 0);
                    break;
                case 2:
                    System.out.println("Has seleccionado Cursos");
                    do {
                        System.out.println("1. Crear curso");
                        System.out.println("2. Encontrar por ID de curso");
                        System.out.println("3. Listar todos los cursos");
                        System.out.println("4. Actualizar curso");
                        System.out.println("5. Eliminar curso");
                        System.out.println("0. Volver al menu");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado Crear curso");
                                break;
                            case 2:
                                System.out.println("Has seleccionado Encontrar por ID de curso");
                                break;
                            case 3:
                                System.out.println("Has seleccionado Listar todos los cursos");
                                break;
                            case 4:
                                System.out.println("Has seleccionado Actualizar curso");
                                break;
                            case 5:
                                System.out.println("Has seleccionado Eliminar curso");
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal");
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    }while (opcion != 0);
                    break;
                case 3:
                    System.out.println("Has seleccionado Matriculas");
                    do {
                        System.out.println("1. Crear matricula");
                        System.out.println("2. Encontrar por ID de matricula");
                        System.out.println("3. Listar todas las matriculas");
                        System.out.println("4. Cancelar matricula");
                        System.out.println("5. Eliminar matricula");
                        System.out.println("0. Volver al menu");
                        opcion = sc.nextInt();
                        switch (opcion) {
                            case 1:
                                System.out.println("Has seleccionado Crear matricula");
                                break;
                            case 2:
                                System.out.println("Has seleccionado Encontrar por ID de matricula");
                                break;
                            case 3:
                                System.out.println("Has seleccionado Listar todas las matriculas");
                                break;
                            case 4:
                                System.out.println("Has seleccionado Cancelar matricula");
                                break;
                            case 5:
                                System.out.println("Has seleccionado Eliminar matricula");
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal");
                                break;
                            default:
                                System.out.println("Opción no válida");
                        }
                    }while (opcion != 0);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        } while (true);
    }
}
**/

