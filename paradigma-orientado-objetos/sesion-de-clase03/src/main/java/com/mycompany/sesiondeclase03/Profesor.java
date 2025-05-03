package com.mycompany.sesiondeclase03;

public class Profesor extends Persona {
    private double calificacion;

    public Profesor() {
        super();
    }
    
    public Profesor(int dni, String nombre, int edad, double sueldo, double calificacion) {
        super(dni, nombre, edad, sueldo);
        this.calificacion = calificacion;
    }
    
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Calificacion: " + calificacion);
    }
}
