def generate_stack(clients):
    # only urgent extractions
    urgencies = [c for c in clients if c.service_type.lower() == "extraction"
                 and c.priority.lower() == "urgent"]
    # sort by date, nearest first
    urgencies.sort(key=lambda c: c.appointment_date)
    return urgencies[::-1]  # stack = last in, first out

def show_stack(stack):
    print("\n--- Urgency Stack ---")
    while stack:
        print("Attending:", stack.pop())
