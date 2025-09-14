import java.util.*;

public class UrgencyStack {
    private Stack<Client> stack = new Stack<>();

    public void generateStack(List<Client> clients) {
        clients.stream()
                .filter(c -> c.getServiceType().equalsIgnoreCase("Extraction")
                        && c.getPriority().equalsIgnoreCase("Urgent"))
                .sorted(Comparator.comparing(Client::getAppointmentDate))
                .forEach(stack::push);
    }

    public void showStack() {
        System.out.println("\n--- Urgency Stack ---");
        while (!stack.isEmpty()) {
            System.out.println("Attending: " + stack.pop());
        }
    }
}
