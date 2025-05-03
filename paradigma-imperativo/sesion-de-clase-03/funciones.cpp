#include "funciones.h"

void cargarClientes(const char* nombreArchivo, Cliente*& clientes, int& numClientes) {
    Cliente buffer[20];
    numClientes = 0;
    
    ifstream archivo(nombreArchivo);
    
    while (archivo >> buffer[numClientes]) {
        numClientes++;
    }
 
    clientes = new Cliente[numClientes];
    
    for (int i = 0; i < numClientes; i++) {
        clientes[i] = buffer[i];
    }
}

bool operator>>(ifstream& archivo, Cliente& cliente) {
    if (!archivo.eof() && archivo >> cliente.dni) {
        archivo.ignore();
        cliente.nombre = leerCadena(archivo);
        archivo >> cliente.edad;
        archivo.ignore();
        archivo >> cliente.sueldo;
        archivo.ignore();
        
        return true;
    }
    
    return false;
}

char* leerCadena(ifstream& archivo) {
    char buffer[20];
    archivo.getline(buffer, 20, ',');
    
    char* cadena = new char[strlen(buffer) + 1];
    strcpy(cadena, buffer);
    
    return cadena;
}

ostream& operator<<(ostream& os, const Cliente& cliente) {
    os << "DNI: " << cliente.dni << endl;
    os << "Nombre: " << cliente.nombre << endl;
    os << "Edad: " << cliente.edad << endl;
    os << "Sueldo: " << cliente.sueldo << endl;
    
    return os;
}

void imprimirClientes(const Cliente* clientes, int numClientes) {
    for (int i = 0; i < numClientes; i++) {
        cout << clientes[i] << endl;
    }
}