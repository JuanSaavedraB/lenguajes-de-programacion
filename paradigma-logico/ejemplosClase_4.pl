%caso base
pertenece(X,[X|_]).
%caso recursivo
pertenece(X,[_|T]):-pertenece(X,T).