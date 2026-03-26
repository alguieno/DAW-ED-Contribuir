package com.biblioteca.servicio;

import com.biblioteca.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaServicio {
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public BibliotecaServicio() {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void buscarLibro(String termino) {
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(termino.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(termino.toLowerCase())) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No se encontraron libros.");
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public boolean prestarLibro(String isbn, String usuario) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    Prestamo prestamo = new Prestamo(libro, usuario);
                    prestamos.add(prestamo);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean devolverLibro(String isbn) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getIsbn().equals(isbn) && prestamo.isActivo()) {
                prestamo.finalizar();
                prestamo.getLibro().setDisponible(true);
                return true;
            }
        }
        return false;
    }

    public void listarPrestamosActivos() {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) System.out.println(prestamo);
        }
    }
}