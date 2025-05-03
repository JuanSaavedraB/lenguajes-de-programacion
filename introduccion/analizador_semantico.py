class SemanticAnalyzer:
    def __init__(self):
        self.symbol_table = {}  # Diccionario para almacenar variables y tipos

    def declare_variable(self, name, var_type):
        if name in self.symbol_table:
            raise Exception(f"Error semántico: La variable '{name}' ya fue declarada.")
        self.symbol_table[name] = var_type

    def check_assignment(self, name, value_type):
        if name not in self.symbol_table:
            raise Exception(f"Error semántico: La variable '{name}' no está declarada.")
        if self.symbol_table[name] != value_type:
            raise Exception(f"Error semántico: No se puede asignar '{value_type}' a '{self.symbol_table[name]}'.")

# Pruebas del analizador semántico
analyzer = SemanticAnalyzer()
analyzer.declare_variable("x", "int")
analyzer.check_assignment("x", "int")  # ✅ Correcto

# Esto generará errores:
# analyzer.check_assignment("y", "int")  # ❌ Error: 'y' no está declarada
# analyzer.check_assignment("x", "string")  # ❌ Error: No se puede asignar string a int
