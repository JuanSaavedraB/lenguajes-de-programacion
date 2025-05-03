pertenece(X, [X|_]).          % Caso base: X es el primer elemento de la lista
pertenece(X, [_|T]) :-        % Caso recursivo: X está en la cola de la lista
    pertenece(X, T).

sumar([], 0).            % Caso base: la lista vacía tiene suma 0
sumar([H|T], S) :-       % Caso recursivo: la suma de la cabeza + la suma de la cola
    sumar(T, S1),
    S is H + S1.