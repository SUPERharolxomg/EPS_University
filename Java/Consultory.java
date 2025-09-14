import java.util.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Clinic {
    public static void main(String[] args) {
        List<Client> clients = Storage.loadClients();
        Scanner sc = new Scanner(System.in);

        if (clients.isEmpty()) {
            System.out.println("No clients registered yet, starting fresh.");
        } else {
            System.out.println("Clients loaded from CSV.");
        }

        boolean running = true;
        while (running) {
            System.out.println("\n===== CLINIC MENU =====");
            System.out.println("1. Register new client");
            System.out.println("2. Show urgency stack");
            System.out.println("3. Show and attend agenda queue");
            System.out.println("4. Save and exit");
            System.out.print("Choose an option: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Client type (Particular/EPS/Prepaid): ");
                    String clientType = sc.nextLine();
                    System.out.print("Service type (Cleaning/Filling/Extraction/Diagnosis): ");
                    String serviceType = sc.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    System.out.print("Priority (Normal/Urgent): ");
                    String priority = sc.nextLine();
                    System.out.print("Appointment date (yyyy-MM-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.print("Service value: ");
                    double value = Double.parseDouble(sc.nextLine());

                    clients.add(new Client(id, name, phone, clientType,
                            serviceType, quantity, priority, date, value));
                    System.out.println("Client registered.");
                    break;

                case "2":
                    UrgencyStack stack = new UrgencyStack();
                    stack.generateStack(clients);
                    stack.showStack();
                    break;

                case "3":
                    AgendaQueue queue = new AgendaQueue();
                    queue.generateQueue(clients);
                    queue.attendQueue();
                    break;

                case "4":
                    Storage.saveClients(clients);
                    System.out.println("Data saved to clients.csv. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
