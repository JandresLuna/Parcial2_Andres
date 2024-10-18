package com.example.parcial2_andres.clases;

public class Personaje {

    private String imagen;
    private String nombre;
    private String estado;
    private String raza;

    public Personaje(String imagen, String nombre, String estado, String raza) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = estado;
        this.raza = raza;
}

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
