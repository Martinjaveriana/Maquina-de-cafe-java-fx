package org.example.maquinadecafejavafx.entities;

public class Usuario {

    /*
     *
     * ATRIBUTOS
     *
     * */

    private String nombre;
    private String Apellido;

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        Apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
