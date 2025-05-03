import re

# Definir patrones de tokens
token_patterns = [
    (r'\bint\b', 'KEYWORD'),
    (r'\b[a-zA-Z_][a-zA-Z0-9_]*\b', 'IDENTIFIER'),
    (r'\d+', 'NUMBER'),
    (r'[=+*;]', 'SYMBOL'),
    (r'\s+', None)  # Ignorar espacios
]

def lexer(code):
    tokens = []
    while code:
        matched = False
        for pattern, token_type in token_patterns:
            match = re.match(pattern, code)
            if match:
                if token_type:
                    tokens.append((match.group(), token_type))
                code = code[len(match.group()):]  # Avanzar en el código
                matched = True
                break
        if not matched:
            raise SyntaxError(f"Carácter inesperado: {code[0]}")
    return tokens

# Prueba con código de ejemplo
code = "int suma = a + b * 5;"
print(lexer(code))