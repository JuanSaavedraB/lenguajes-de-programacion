%hechos
padre(juan,maria).
padre(juan,pedro).
padre(juan,jose).
%regla
hermano(X,Y):-padre(Z,X),padre(Z,Y),X\=Y.