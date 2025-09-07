public class Client {
    String cedula;
    String nombre;
    String telefono;
    String tipoCliente;  // Particular, EPS, Prepagada
    String tipoAtencion; // Limpieza, Calzas, Extracción, Diagnóstico
    int cantidad;
    String prioridad;    // Normal, Urgente
    String fechaCita;
    double valorTotal;

    public Client(String cedula, String nombre, String telefono, String tipoCliente,
                   String tipoAtencion, int cantidad, String prioridad, String fechaCita) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
        this.tipoAtencion = tipoAtencion;
        this.cantidad = cantidad;
        this.prioridad = prioridad;
        this.fechaCita = fechaCita;
        this.valorTotal = calcularValor();
    }

    private double calcularValor() {
        double base = 0, unitario = 0;

        switch (tipoAtencion.toLowerCase()) {
            case "limpieza":
                base = 30000;
                cantidad = 1; // obligatorio
                break;
            case "diagnóstico":
                base = 20000;
                cantidad = 1; // obligatorio
                break;
            case "calzas":
                base = 10000;
                unitario = 50000;
                break;
            case "extracción":
                base = 15000;
                unitario = 80000;
                break;
        }
        return base + (unitario * cantidad);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoAtencion='" + tipoAtencion + '\'' +
                ", cantidad=" + cantidad +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
