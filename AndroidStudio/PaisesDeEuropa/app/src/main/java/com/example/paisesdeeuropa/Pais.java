package com.example.paisesdeeuropa;

import java.io.Serializable;

public class Pais implements Serializable {
    static final long serialVersionUID = 1L;
    private String nombre;
    private String capital;
    private int resource;
    private int poblacion;
    private int superficie;

    public Pais(String nombre, String capital, int poblacion, int superficie, int resource) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.superficie = superficie;
        this.resource = resource;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getResource() {
        return resource;
    }

    public void setUrl(int resource) {
        this.resource = resource;
    }
}
