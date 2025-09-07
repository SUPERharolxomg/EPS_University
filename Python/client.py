class Client:
    def __init__(self, cedula, nombre, telefono, tipo_cliente,
                 tipo_atencion, cantidad, prioridad, fecha_cita):
        self.cedula = cedula
        self.nombre = nombre
        self.telefono = telefono
        self.tipo_cliente = tipo_cliente
        self.tipo_atencion = tipo_atencion
        self.cantidad = cantidad
        self.prioridad = prioridad
        self.fecha_cita = fecha_cita
        self.valor_total = self.calcular_valor()

    def calcular_valor(self):
        base, unitario = 0, 0
        if self.tipo_atencion.lower() == "limpieza":
            base, self.cantidad = 30000, 1
        elif self.tipo_atencion.lower() == "diagnóstico":
            base, self.cantidad = 20000, 1
        elif self.tipo_atencion.lower() == "calzas":
            base, unitario = 10000, 50000
        elif self.tipo_atencion.lower() == "extracción":
            base, unitario = 15000, 80000
        return base + (unitario * self.cantidad)

    def __str__(self):
        return (f"Cliente(cedula={self.cedula}, nombre={self.nombre}, "
                f"tipoAtencion={self.tipo_atencion}, cantidad={self.cantidad}, "
                f"valorTotal={self.valor_total})")
