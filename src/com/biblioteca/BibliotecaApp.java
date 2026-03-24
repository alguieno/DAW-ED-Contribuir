package com.biblioteca;

import com.biblioteca.modelo.*;
import com.biblioteca.servicio.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Clase principal del Sistema de Gestión de Biblioteca
 * Este es un proyecto educativo para practicar pull requests
 */
public class BibliotecaApp {

    private static BibliotecaServicio bibliotecaServicio = new BibliotecaServicio();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gestión de Biblioteca ===");

        // Datos de ejemplo
        inicializarDatos();

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    listarLibros();
                    break;
                case 2:
                    agregarLibro();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    prestarLibro();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    listarPrestamos();
                    break;
                case 7:
                    calificarLibro();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("1. Listar todos los libros");
        System.out.println("2. Agregar nuevo libro");
        System.out.println("3. Buscar libro");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Listar préstamos activos");
        System.out.println("7. Calificar libro");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void inicializarDatos() {
        bibliotecaServicio.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", "978-8424936464", 1605));
        bibliotecaServicio.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728", 1967));
        bibliotecaServicio.agregarLibro(new Libro("1984", "George Orwell", "978-0451524935", 1949));
    }

    private static void listarLibros() {
        System.out.println("\n=== LIBROS DISPONIBLES ===");
        bibliotecaServicio.listarLibros();
    }

    private static void agregarLibro() {
        System.out.println("\n=== AGREGAR NUEVO LIBRO ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = Libro.validarIsbn(scanner);

        int año = 0;
        boolean valido = false;
        int añoActual = LocalDate.now().getYear();

        // Validar que el año sea un número válido entre 1450 y el año actual
        do {
            do {
                System.out.print("Año de publicación: ");
                String input = scanner.nextLine();
                try {
                    año = Integer.parseInt(input);
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debes introducir un número válido.");
                }
            } while (!valido);

            if (año < 1450 || año > añoActual) {
                System.out.println("Error: el año debe estar entre 1450 y " + añoActual);
                valido = false;
            }
        } while (!valido);

        Libro libro = new Libro(titulo, autor, isbn, año);
        bibliotecaServicio.agregarLibro(libro);
        System.out.println("Libro agregado exitosamente!");
    }

    private static void buscarLibro() {
        System.out.print("\nIngrese término de búsqueda: ");
        String termino = scanner.nextLine();
        bibliotecaServicio.buscarLibro(termino);
    }

    private static void prestarLibro() {
        System.out.print("\nIngrese ISBN del libro: ");
        String isbn = scanner.nextLine();
        System.out.print("Nombre del usuario: ");
        String usuario = scanner.nextLine();

        boolean exito = bibliotecaServicio.prestarLibro(isbn, usuario);
        if (exito) {
            System.out.println("Préstamo registrado exitosamente!");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }
    }

    private static void devolverLibro() {
        System.out.print("\nIngrese ISBN del libro: ");
        String isbn = scanner.nextLine();

        boolean exito = bibliotecaServicio.devolverLibro(isbn);
        if (exito) {
            System.out.println("Devolución registrada exitosamente!");
        } else {
            System.out.println("No se pudo registrar la devolución.");
        }
    }

    private static void listarPrestamos() {
        System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
        bibliotecaServicio.listarPrestamosActivos();
    }

    private static void calificarLibro() {
        System.out.print("\nIngrese ISBN del libro: ");
        String isbn = scanner.nextLine();

        // Buscar el libro usando el servicio
        Libro libro = bibliotecaServicio.buscarLibroPorIsbn(isbn);

        if (libro == null) {
            System.out.println("No se encontró ningún libro con ese ISBN.");
            return;
        }

        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Puntuación (1 a 10): ");
        int puntuacion = Integer.parseInt(scanner.nextLine());

        System.out.print("Comentario: ");
        String comentario = scanner.nextLine();

        Calificacion cal = new Calificacion(usuario, libro, puntuacion, comentario);
        libro.agregarCalificacion(cal);

        System.out.println("Calificación agregada correctamente.");
        System.out.println("Promedio actual: " + libro.calcularPromedio());
    }

}