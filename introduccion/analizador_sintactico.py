def parse_expression(tokens):
    """Verifica que la expresión sea válida"""
    if len(tokens) == 1 and tokens[0][1] == "IDENTIFIER":
        return True  # Es un identificador válido
    elif len(tokens) == 3 and tokens[1][0] in "+-*":
        return parse_expression([tokens[0]]) and parse_expression([tokens[2]])
    return False  # Error sintáctico

tokens = [("a", "IDENTIFIER"), ("+", "SYMBOL"), ("b", "IDENTIFIER")]
print(parse_expression(tokens))  # True