fibonacci(0, 0).           % Caso base: F(0) = 0
fibonacci(1, 1).           % Caso base: F(1) = 1
fibonacci(N, F) :-         % Caso recursivo: F(N) = F(N-1) + F(N-2)
    N > 1,                  % Asegurarse de que N sea mayor que 1
    N1 is N - 1,            % N1 es N-1
    N2 is N - 2,            % N2 es N-2
    fibonacci(N1, F1),      % Llamar recursivamente para F(N-1)
    fibonacci(N2, F2),      % Llamar recursivamente para F(N-2)
    F is F1 + F2.           % F(N) = F(N-1) + F(N-2)