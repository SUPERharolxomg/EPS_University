from client import Client
import storage
import urgency_stack
import agenda_queue
from datetime import datetime

def register_client():
    client_id = input("ID: ")
    name = input("Name: ")
    phone = input("Phone: ")
    client_type = input("Client type (EPS/Particular/Prepaid): ")
    service_type = input("Service type (Extraction/Cleaning/Diagnosis/Filling): ")
    quantity = int(input("Quantity: "))
    priority = input("Priority (Urgent/Normal): ")
    appointment_date = input("Appointment date (yyyy-MM-dd): ")
    service_value = float(input("Service value: "))

    return Client(client_id, name, phone, client_type, service_type,
                  quantity, priority, appointment_date, service_value)

def main():
    clients = storage.load_clients()
    if clients:
        print("Clients loaded from CSV.")
    else:
        print("No clients registered, starting fresh.")

    while True:
        print("\n===== CLINIC MENU =====")
        print("1. Register new client")
        print("2. Show urgency stack")
        print("3. Show and attend agenda queue")
        print("4. Save and exit")
        option = input("Choose an option: ")

        if option == "1":
            new_client = register_client()
            clients.append(new_client)
            print("Client registered and added.")
        elif option == "2":
            stack = urgency_stack.generate_stack(clients)
            urgency_stack.show_stack(stack)
        elif option == "3":
            queue = agenda_queue.generate_queue(clients)
            agenda_queue.attend_queue(queue)
        elif option == "4":
            storage.save_clients(clients)
            print("Data saved to clients.csv. Goodbye!")
            break
        else:
            print("Invalid option.")

if __name__ == "__main__":
    main()
