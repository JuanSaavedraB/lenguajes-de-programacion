const pertenece = (x, lista) => {
    if (lista.length === 0) return false;   // Caso base: lista vacía
    if (lista[0] === x) return true;        // Caso base: primer elemento coincide
    return pertenece(x, lista.slice(1));    // Caso recursivo: revisar el resto
};

console.log(pertenece(6, [1, 2, 3, 4, 5]));
