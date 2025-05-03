package com.mycompany.sesiondeclase03;

/**
 *
 * @author erichuiza
 */
public class SesionDeClase03 {

    public static void main(String[] args) {
        Persona p1 = new Alumno(12345678, "Juan", 20, 2000.00, 8, 18.00);
        Persona p2 = new Profesor(87654321, "Pedro", 30, 3000.00, 98.00);
        
        p1.imprimir();
        p2.imprimir();
        
        
    }
}
