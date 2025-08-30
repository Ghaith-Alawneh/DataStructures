package felina;

public class RoomBooking2 {
	private Queue bookings = new Queue();
	private UndoRedoManager undoRedoManager;

	public RoomBooking2(UndoRedoManager undoRedoManager) {
		this.undoRedoManager = undoRedoManager;
	}

	public void requestBooking(Student student, int roomNumber) {
		try {
			student.setRoomNumber(roomNumber);
			bookings.enqueueWithPriority(student, "Room " + roomNumber);
			System.out.println("Booking requested with priority: " + student.getName() + " for Room " + roomNumber);
			undoRedoManager.performAction("Requested booking: " + student.getName() + " for Room " + roomNumber);
		} catch (Exception e) {
			System.out.println("Error requesting booking: " + e.getMessage());
		}
	}

	public void processBooking() {
		try {
			Student student = bookings.dequeue();
			if (student != null) {
				System.out.println("Booking processed for: " + student.getName());
				undoRedoManager.performAction(student.getName());
			} else {
				System.out.println("No bookings to process");
			}
		} catch (Exception e) {
			System.out.println("Error processing booking: " + e.getMessage());
		}
	}

	public void viewBookings() {
		try {
			if (bookings.isEmpty()) {
				System.out.println("No pending bookings");
			} else {
				System.out.println("Pending bookings:");
				bookings.display();
			}
		} catch (Exception e) {
			System.out.println("Error viewing bookings: " + e.getMessage());
		}
	}
}
