package com.biblioteca.modelo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa un libro en el sistema de biblioteca
 */
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;
    private int añoPublicacion;
    private boolean disponible;
    
    

    private ArrayList<String> usuarios = new ArrayList<>();
    private ArrayList<Integer> puntuaciones = new ArrayList<>();
    private ArrayList<String> comentarios = new ArrayList<>();
    private ArrayList<Calificacion> calificaciones = new ArrayList<>();

    public Libro(String titulo, String autor, String isbn, String editorial, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.añoPublicacion = añoPublicacion;
        this.disponible = true;
    }

    // --- Métodos de calificación ---
    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    public double calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return 0.0;
        }

        int suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.getPuntuacion();
        }

        return (double) suma / calificaciones.size();
    }

    public void mostrarCalificaciones() {
        for (Calificacion c : calificaciones) {
            System.out.println(c);
        }
    }

    // --- Métodos de validación de ISBN (upstream) ---
    public static String validarIsbn(Scanner sc) {
        String isbn;

        while (true) {
            isbn = sc.nextLine();
            String isbnLimpio = isbn.replace("-", "");

            if (isbnLimpio.length() != 13) {
                System.out.println("El código ISBN introducido debe tener exactamente trece dígitos.");
                continue;
            }

            if (!isbnLimpio.matches("\\d{13}")) {
                System.out.println("El ISBN solo puede contener valores numéricos y la separación por guiones es opcional");
                continue;
            }

            return isbn;
        }
    }

    // --- Getters y Setters ---
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {return editorial;}

    public void setEditorial(String editorial) {this.editorial = editorial;}
    
    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("Libro: %s | Autor: %s | ISBN: %s | Editorial: %s | Año: %d | Disponible: %s",
                titulo, autor, isbn, editorial, añoPublicacion, disponible ? "Sí" : "No");
    }
}