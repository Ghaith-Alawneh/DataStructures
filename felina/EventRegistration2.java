package felina;

public class EventRegistration2 {
	
	
    private Queue registrations = new Queue();

    public void register(Student student, String eventName) {
        try {
            registrations.enqueue(student, eventName);
            System.out.println("Registered: " + student.getName() + " for " + eventName);
        } catch (Exception e) {
            System.err.println("Error registering: " + e.getMessage());
        }
    }

    public void processRegistration() {
        try {
            Student student = registrations.dequeue();
            if (student != null) {
                System.out.println("Processed registration for: " + student.getName());
            } else {
                System.out.println("No registrations to process");
            }
        } catch (Exception e) {
            System.err.println("Error processing registration: " + e.getMessage());
        }
    }

    public void viewRegistrations() {
        try {
            if (registrations.isEmpty()) {
                System.out.println("No pending registrations");
            } else {
                System.out.println("Pending registrations:");
                registrations.display();
            }
        } catch (Exception e) {
            System.err.println("Error viewing registrations: " + e.getMessage());
        }
    }
}