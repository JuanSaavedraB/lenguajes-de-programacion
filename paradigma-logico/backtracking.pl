color(rojo).
color(azul).
color(verde).

gusta(maria, rojo).
gusta(maria, azul).
gusta(maria, verde).
gusta(diego, azul).

padre(juan, maria).
padre(juan, jose).
padre(juan, ana).

padre(carlos, maria).
padre(carlos, jose).
padre(carlos, ana).

hijo(X, Y):- padre(Y, X).