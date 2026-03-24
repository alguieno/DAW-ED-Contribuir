package com.biblioteca.modelo;

public class Calificacion {
    private String usuario;
    private Libro libro;
    private int puntuacion; // por ejemplo, de 1 a 5
    private String comentario;

    public Calificacion(String usuario, Libro libro, int puntuacion, String comentario) {
        this.usuario = usuario;
        this.libro = libro;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario +
                " | Puntuación: " + puntuacion +
                " | Comentario: " + comentario;
    }
}
