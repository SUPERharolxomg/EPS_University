import java.util.*;

public class AgendaQueue {
    private Queue<Client> queue = new LinkedList<>();

    public void generateQueue(List<Client> clients) {
        clients.stream()
                .sorted(Comparator.comparing(Client::getAppointmentDate))
                .forEach(queue::offer);
    }

    public void attendQueue() {
        System.out.println("\n--- Agenda Queue ---");
        while (!queue.isEmpty()) {
            System.out.println("Attending: " + queue.poll());
        }
    }
}
