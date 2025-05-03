% hechos
parent(john, mary).
parent(mary, susan).
parent(susan, james).

% reglas
grandparent(X, Y):- parent(X, Z), parent(Z, Y).

hello :- write('Hello World!'), nl.

% Entrada de usuario.
ask_age :- write('¿Qué edad tienes?'), nl,
            read(X), write('Tienes '), write(X), write(' años de edad.'), nl.

suma(X, Y, Z) :- Z is X + Y.

padre(juan, maria).
padre(juan, pedro).
padre(juan, jose).

hermano(X, Y) :- padre(Z, X), padre(Z, Y), X \= Y.