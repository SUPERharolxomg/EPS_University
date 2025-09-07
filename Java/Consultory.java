import java.util.*;

public class Consultory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();

        System.out.print("Ingrese número de clientes: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nCliente " + (i + 1));
            System.out.print("Cédula: ");
            String cedula = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();
            System.out.print("Tipo de Cliente (Particular/EPS/Prepagada): ");
            String tipoCliente = sc.nextLine();
            System.out.print("Tipo de Atención (Limpieza/Calzas/Extracción/Diagnóstico): ");
            String tipoAtencion = sc.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();
            sc.nextLine();
            System.out.print("Prioridad (Normal/Urgente): ");
            String prioridad = sc.nextLine();
            System.out.print("Fecha de la Cita: ");
            String fechaCita = sc.nextLine();

            clients.add(new Client(cedula, nombre, telefono, tipoCliente,
                                     tipoAtencion, cantidad, prioridad, fechaCita));
        }

        // Reportes
        System.out.println("\n--- Reportes ---");
        System.out.println("Total Clientes: " + clients.size());

        double ingresosTotales = clients.stream().mapToDouble(c -> c.valorTotal).sum();
        System.out.println("Ingresos Totales: " + ingresosTotales);

        long extracciones = clients.stream().filter(c -> c.tipoAtencion.equalsIgnoreCase("extracción")).count();
        System.out.println("Número de clientes para extracción: " + extracciones);

        // Ordenamiento
        clients.sort((a, b) -> Double.compare(b.valorTotal, a.valorTotal));
        System.out.println("\nLista ordenada (de mayor a menor valor):");
        clients.forEach(System.out::println);

        // Búsqueda
        System.out.print("\nBuscar cliente por cédula: ");
        String buscar = sc.nextLine();
        Client encontrado = clients.stream()
                .filter(c -> c.cedula.equals(buscar))
                .findFirst().orElse(null);

        if (encontrado != null) {
            System.out.println("Cliente encontrado: " + encontrado);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
