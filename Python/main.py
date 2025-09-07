from client import Client

def main():
    clientes = []
    n = int(input("Ingrese número de clientes: "))

    for i in range(n):
        print(f"\nCliente {i + 1}")
        cedula = input("Cédula: ")
        nombre = input("Nombre: ")
        telefono = input("Teléfono: ")
        tipo_cliente = input("Tipo de Cliente (Particular/EPS/Prepagada): ")
        tipo_atencion = input("Tipo de Atención (Limpieza/Calzas/Extracción/Diagnóstico): ")
        cantidad = int(input("Cantidad: "))
        prioridad = input("Prioridad (Normal/Urgente): ")
        fecha_cita = input("Fecha de la Cita: ")

        clientes.append(Client(cedula, nombre, telefono, tipo_cliente,
                                tipo_atencion, cantidad, prioridad, fecha_cita))

    print("\n--- Reportes ---")
    print("Total Clientes:", len(clientes))

    ingresos_totales = sum(c.valor_total for c in clientes)
    print("Ingresos Totales:", ingresos_totales)

    extracciones = sum(1 for c in clientes if c.tipo_atencion.lower() == "extracción")
    print("Número de clientes para extracción:", extracciones)

    clientes.sort(key=lambda c: c.valor_total, reverse=True)
    print("\nLista ordenada (de mayor a menor valor):")
    for c in clientes:
        print(c)

    buscar = input("\nBuscar cliente por cédula: ")
    encontrado = next((c for c in clientes if c.cedula == buscar), None)

    if encontrado:
        print("Cliente encontrado:", encontrado)
    else:
        print("Cliente no encontrado.")

if __name__ == "__main__":
    main()
