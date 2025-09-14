from collections import deque

def generate_queue(clients):
    queue = deque(sorted(clients, key=lambda c: c.appointment_date))
    return queue

def attend_queue(queue):
    print("\n--- Agenda Queue ---")
    while queue:
        client = queue.popleft()
        print("Attending:", client)
