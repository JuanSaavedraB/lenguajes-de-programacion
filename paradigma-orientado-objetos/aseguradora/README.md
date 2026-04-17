# Aseguradora de Vehiculos

Aplicacion de consola Java para cotizacion y emision de polizas vehiculares, sin servidores y con persistencia local en CSV.

## Patrones aplicados

1. **Decorator**: para agregar coberturas dinamicas sobre `SeguroBasico`.
2. **Builder**: para construir `SolicitudCotizacion` de forma legible e inmutable.
3. **Abstract Factory**: para crear la familia de servicios locales (cotizador, repositorios CSV, notificador, evaluador de riesgo).
4. **Adapter**: para adaptar `ServicioRiesgoLegacy` (niveles de texto) al contrato interno `EvaluadorRiesgo` (puntaje numerico).
5. **Chain of Responsibility**: para aprobacion por niveles (`Automatico -> Supervisor -> Gerente`).
6. **Singleton**: `CadenaAprobacionSingleton` garantiza una sola cadena de aprobacion compartida.
7. **Command**: acciones del proceso (`Cargar`, `Cotizar`, `Aprobar`, `Guardar`, `Notificar`) encapsuladas en comandos.

## Estructura principal

- `src/pe/edu/pucp/inf13/Program.java`: menu de consola.
- `src/pe/edu/pucp/inf13/dominio`: entidades de negocio.
- `src/pe/edu/pucp/inf13/seguros`: modelo de seguros y decoradores.
- `src/pe/edu/pucp/inf13/aplicacion`: contratos, fabrica, comandos y aprobacion.
- `src/pe/edu/pucp/inf13/infraestructura`: implementaciones CSV, cotizacion, notificacion y riesgo legado.
- `data/solicitudes.csv`: entrada de solicitudes.
- `data/polizas.csv`: salida de polizas emitidas.

## Flujo

1. Carga inicial de `data/solicitudes.csv`.
2. Menu con opciones para listar, recargar bajo demanda, cotizar/procesar y listar polizas.
3. Si la solicitud es aprobada, se guarda una linea en `data/polizas.csv`.
4. La notificacion se muestra en consola.

