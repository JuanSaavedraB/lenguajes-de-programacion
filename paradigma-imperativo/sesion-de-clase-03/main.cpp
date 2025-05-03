/* 
 * File:   main.cpp
 * Author: erichuiza
 *
 * Created on April 11, 2025, 7:39 PM
 */

#include <cstdlib>
#include <iostream>

#include "funciones.h"

using namespace std;

//int sumar(int a, int b) {
//    return a + b;
//}
//
//double sumar(double a, double b) {
//    return a + b;
//}

int main(int argc, char** argv) {
    Cliente* clientes;
    int numClientes;
    cargarClientes("clientes.csv", clientes, numClientes);
    
    imprimirClientes(clientes, numClientes);
    
//    int a = 5;
//    int b = 6;
//    int c = sumar(a, b);
//    
//    cout << c << endl;
//    
//    double d = 8.9;
//    double f = 7.6;
//    double g = sumar(d, f);
//    
//    cout << g << endl;
    
    return 0;
}

