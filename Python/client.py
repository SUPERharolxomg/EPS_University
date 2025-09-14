from datetime import datetime

class Client:
    def __init__(self, client_id, name, phone, client_type, service_type,
                 quantity, priority, appointment_date, service_value):
        self.client_id = client_id
        self.name = name
        self.phone = phone
        self.client_type = client_type
        self.service_type = service_type
        self.quantity = quantity
        self.priority = priority
        self.appointment_date = datetime.strptime(appointment_date, "%Y-%m-%d").date()
        self.service_value = float(service_value)

    def to_csv(self):
        return [self.client_id, self.name, self.phone, self.client_type,
                self.service_type, str(self.quantity), self.priority,
                str(self.appointment_date), str(self.service_value)]

    @staticmethod
    def from_csv(row):
        return Client(row[0], row[1], row[2], row[3], row[4],
                      int(row[5]), row[6], row[7], float(row[8]))

    def __str__(self):
        return (f"{self.client_id} - {self.name} - {self.service_type} "
                f"- {self.priority} - {self.appointment_date}")
