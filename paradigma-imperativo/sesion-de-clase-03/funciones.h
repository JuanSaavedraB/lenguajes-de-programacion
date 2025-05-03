/* 
 * File:   funciones.h
 * Author: erichuiza
 *
 * Created on April 11, 2025, 7:50 PM
 */

#ifndef FUNCIONES_H
#define FUNCIONES_H

#include "estructuras.h"
#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

void cargarClientes(const char*, Cliente*&, int&);
bool operator>>(ifstream&, Cliente&);

ostream& operator<<(ostream&, const Cliente&);
void imprimirClientes(const Cliente*, int);

char* leerCadena(ifstream&);

#endif /* FUNCIONES_H */
