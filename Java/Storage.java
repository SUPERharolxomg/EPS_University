import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Storage {
    private static final String FILENAME = "clients.csv";

    public static List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Skip header if present
                if (line.toLowerCase().contains("id,")) continue;
                String[] data = line.split(",");
                clients.add(new Client(data[0], data[1], data[2], data[3], data[4],
                        Integer.parseInt(data[5]), data[6], LocalDate.parse(data[7]),
                        Double.parseDouble(data[8])));
            }
        } catch (IOException e) {
            // file not found is fine
        }
        return clients;
    }

    public static void saveClients(List<Client> clients) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILENAME))) {
            pw.println("id,name,phone,clientType,serviceType,quantity,priority,appointmentDate,serviceValue");
            for (Client c : clients) {
                pw.println(c.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
