package com.proyecto.alexandrorodriguez.grownature.model;

public class PlantasArbustosArboles {
    /**ATRIBUTOS**/
    private String nombre;
    private String descripcion;
    private String plantacion;
    private String crecimiento;
    private String riego;
    private String clima;
    private String coste;
    private String dondeEncontrarlo;
    private int imagenPortada;
    private int imagenEjemplo;
    /**CONSTRUCTORES**/
    public PlantasArbustosArboles(String nombre, String descripcion, String plantacion, String crecimiento, String riego, String clima, String coste, String dondeEncontrarlo, int imagenPortada, int imagenEjemplo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.plantacion = plantacion;
        this.crecimiento = crecimiento;
        this.riego = riego;
        this.clima = clima;
        this.coste = coste;
        this.dondeEncontrarlo = dondeEncontrarlo;
        this.imagenPortada = imagenPortada;
        this.imagenEjemplo = imagenEjemplo;
    }
    public PlantasArbustosArboles(String nombre, String breveDescripcion, int imagenPortada) {
        this.nombre = nombre;
        this.descripcion = breveDescripcion;
        this.imagenPortada = imagenPortada;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getImagenPortada() {
        return imagenPortada;
    }
    public void setImagenPortada(int imagenPortada) {
        this.imagenPortada = imagenPortada;
    }
    public String getPlantacion() {
        return plantacion;
    }
    public void setPlantacion(String plantacion) {
        this.plantacion = plantacion;
    }
    public String getCrecimiento() {
        return crecimiento;
    }
    public void setCrecimiento(String crecimiento) {
        this.crecimiento = crecimiento;
    }
    public String getRiego() {
        return riego;
    }
    public void setRiego(String riego) {
        this.riego = riego;
    }
    public String getClima() {
        return clima;
    }
    public void setClima(String clima) {
        this.clima = clima;
    }
    public String getCoste() {
        return coste;
    }
    public void setCoste(String coste) {
        this.coste = coste;
    }
    public String getDondeEncontrarlo() {
        return dondeEncontrarlo;
    }
    public void setDondeEncontrarlo(String dondeEncontrarlo) {
        this.dondeEncontrarlo = dondeEncontrarlo;
    }
    public int getImagenEjemplo() {
        return imagenEjemplo;
    }
    public void setImagenEjemplo(int imagenEjemplo) {
        this.imagenEjemplo = imagenEjemplo;
    }
}
