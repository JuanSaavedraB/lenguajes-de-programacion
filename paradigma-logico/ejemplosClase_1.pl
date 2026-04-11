progenitor(jose,juan).
progenitor(juan,maria).
progenitor(maria,pedro).

abuelo(X,Y):-progenitor(X,Z),progenitor(Z,Y).
bisabuelo(X,Y):-progenitor(X,Z),abuelo(Z,Y).