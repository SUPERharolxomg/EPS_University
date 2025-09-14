import java.time.LocalDate;

public class Client {
    private String id;
    private String name;
    private String phone;
    private String clientType;
    private String serviceType;
    private int quantity;
    private String priority;
    private LocalDate appointmentDate;
    private double serviceValue;

    public Client(String id, String name, String phone,
                  String clientType, String serviceType, int quantity,
                  String priority, LocalDate appointmentDate, double serviceValue) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.clientType = clientType;
        this.serviceType = serviceType;
        this.quantity = quantity;
        this.priority = priority;
        this.appointmentDate = appointmentDate;
        this.serviceValue = serviceValue;
    }

    public String getId() { return id; }
    public String getServiceType() { return serviceType; }
    public String getPriority() { return priority; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public double getServiceValue() { return serviceValue; }

    public String toCSV() {
        return id + "," + name + "," + phone + "," + clientType + "," + serviceType + "," +
               quantity + "," + priority + "," + appointmentDate + "," + serviceValue;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + serviceType +
               " - " + priority + " - " + appointmentDate;
    }
}
