package felina;

class EventRegistrationNode {

    int studentID;
    String eventName;
    EventRegistrationNode next;

    public EventRegistrationNode(int studentID, String eventName) {
        this.studentID = studentID;
        this.eventName = eventName;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Event: " + eventName;
    }
}


public class EventRegistration{

    private EventRegistrationNode front;
    private EventRegistrationNode rear;

    public EventRegistration() {
        this.front = null;
        this.rear = null;
    }

    public void register(int studentID, String eventName) {
        EventRegistrationNode newNode = new EventRegistrationNode(studentID, eventName);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Registered: " + newNode);
    }

    public void enterRegistration() {
        if (front == null) {
            System.out.println("No registrations to Enter.");
            return;
        }

        System.out.println("Processing registration: " + front);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public void viewRegistrations() {
        if (front == null) {
            System.out.println("No registrations.");
            return;
        }

        System.out.println("Pending Registrations:");
        EventRegistrationNode current = front;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

