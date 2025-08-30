package felina;


class BookingNode {
	
	int studentID;
	int roomNumber;
	BookingNode next;

	
	
	public BookingNode(int studentID, int roomNumber) {
		this.studentID= studentID;
		this.roomNumber = roomNumber;
		this.next = null;
		}
	  public String toString() {
	        return "Student ID: " + studentID + ", Room: " + roomNumber;
	    }
		
}
public class RoomBooking {

	BookingNode front;
	BookingNode rear;
	BookingNode crt;

	public RoomBooking() {
		this.front = null;
		this.rear = null;

	}

	public void requestBooking(int studentID, int roomNumber) {
		BookingNode newNode = new BookingNode(studentID, roomNumber);
		if (rear == null) {
			front = newNode;
			rear = newNode;

		} else if (front == null) {
			front = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println("Booking available: " + newNode);
	}

	public void removeBooking() {
		if (front == null) {
			System.out.println("No booking to remove");
			return;
		}
		else {
		BookingNode temp = front;
		front = front.next;
			System.out.println("Booking removed: " + temp);
		}
	}
	

	public void viewBookings() {
		if(front == null) {
			System.out.println("No bookings booked");
		}
		crt = front;
		while(crt != null) {
			System.out.println("The bookings are:" + crt);
			crt = crt.next;
		}

	}
}
