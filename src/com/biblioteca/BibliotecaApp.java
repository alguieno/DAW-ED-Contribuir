package com.biblioteca;

import com.biblioteca.modelo.*;
import com.biblioteca.servicio.*;
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
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Listar todos los libros");
        System.out.println("2. Agregar nuevo libro");
        System.out.println("3. Buscar libro");
        System.out.println("4. Prestar libro");
        System.out.println("5. Devolver libro");
        System.out.println("6. Listar préstamos activos");
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
        bibliotecaServicio.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", "978-8424936464", "RBA", 1605));
        bibliotecaServicio.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728", "Debolsillo", 1967));
        bibliotecaServicio.agregarLibro(new Libro("1984", "George Orwell", "978-0451524935", "Alma", 1949));
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
        String isbn = scanner.nextLine();
        System.out.print("Editorial: ");
        String editorial = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int año = Integer.parseInt(scanner.nextLine());
        
        Libro libro = new Libro(titulo, autor, isbn, editorial, año);
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
}
