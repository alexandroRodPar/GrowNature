package com.proyecto.alexandrorodriguez.grownature.model;

public class PlantasArbustosArboles {
    /**ATRIBUTOS**/
    private String nombre;
    private String breveDescripcion;
    private int imagen;

    /**CONSTRUCTORES**/
    public PlantasArbustosArboles(String nombre, String breveDescripcion, int imagen) {
        this.nombre = nombre;
        this.breveDescripcion = breveDescripcion;
        this.imagen = imagen;
    }
    public PlantasArbustosArboles() {
    }

    /**GETTERS Y SETTERS**/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
