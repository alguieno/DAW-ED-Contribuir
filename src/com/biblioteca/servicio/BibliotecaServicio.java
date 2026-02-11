package com.biblioteca.servicio;

import com.biblioteca.modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que gestiona las operaciones de la biblioteca
 */
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
        
        if (!encontrado) {
            System.out.println("No se encontraron libros con ese término.");
        }
    }
    
    public boolean prestarLibro(String isbn, String usuario) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    Prestamo prestamo = new Prestamo(libro, usuario);
                    prestamos.add(prestamo);
                    return true;
                } else {
                    System.out.println("El libro no está disponible.");
                    return false;
                }
            }
        }
        System.out.println("Libro no encontrado.");
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
        System.out.println("No se encontró un préstamo activo para ese libro.");
        return false;
    }
    
    public void listarPrestamosActivos() {
        boolean hayPrestamos = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.isActivo()) {
                System.out.println(prestamo);
                hayPrestamos = true;
            }
        }
        
        if (!hayPrestamos) {
            System.out.println("No hay préstamos activos.");
        }
    }

    public void buscarLibroAvanzado(ArrayList<String> terminos)
    {

         String titulo = terminos.get(0);
         String autor = terminos.get(1);
         String isbn = terminos.get(2);
         String añoPublicacion = terminos.get(3);

         boolean encontrado = false;

        for(Libro libro : libros)
        {

             if(coinciden(titulo, libro.getTitulo()) &&
                coinciden(autor, libro.getAutor()) &&
                coinciden(isbn, libro.getIsbn()) &&
                coinciden(añoPublicacion, String.valueOf(libro.getAñoPublicacion())))
             {

                encontrado = true;
                System.out.println(libro);

            }

        }

        if(!encontrado) System.out.println("Libro no encontrado.");


    }

    //comprueba las coincidencias
    private static boolean coinciden(String valor, String valorLibro)
    {

        return valor.isEmpty() || valor.equalsIgnoreCase(valorLibro);

    }

    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }
    
    public List<Prestamo> getPrestamos() {
        return new ArrayList<>(prestamos);
    }

}
