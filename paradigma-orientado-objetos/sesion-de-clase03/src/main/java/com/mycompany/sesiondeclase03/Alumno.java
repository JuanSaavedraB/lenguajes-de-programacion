package com.mycompany.sesiondeclase03;

/**
 *
 * @author erichuiza
 */
public class Alumno extends Persona {
    private int ciclo;
    private double promedio;
    
    public Alumno() {
        super();
    }
    
    public Alumno(int dni, String nombre, int edad, double sueldo, int ciclo, double promedio) {
        super(dni, nombre, edad, sueldo);
        this.ciclo = ciclo;
        this.promedio = promedio;
    }
    
    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Ciclo: " + ciclo);
        System.out.println("Promedio" + promedio);
    }
}






