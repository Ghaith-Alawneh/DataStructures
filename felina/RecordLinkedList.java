package felina;

public class RecordLinkedList {

	class Record {
		String description;
		String location;
		Record next;
		Record prev;

		public Record(String description, String location) {
			this.description = description;
			this.location = location;
			this.next = null;
			this.prev = null;

		}
	}

	private Record head;
	private Record tail;

	public RecordLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addRecord(String description, String location) {
		Record newRecord = new Record(description, location);
		if (head == null) {
			head = newRecord;
			tail = newRecord;
		} else {
			tail.next = newRecord;
			newRecord.prev = tail;
			tail = newRecord;
		}
		System.out.println("Record added: " + description + " at " + location);
	}

	public void viewRecords() {
		if (head == null) {
			System.out.println("No records found.");
			return;
		}

		Record current = head;
		System.out.println("The records are:");
		while (current != null) {
			System.out.println("Description: " + current.description + ", Location: " + current.location);
			current = current.next;
		}
	}
	public void removeLast() {
	    if (head == null) {
	        System.out.println("The list is empty.");
	        return;
	    }

	    if (head == tail) { 
	        head = null;
	        tail = null;
	    } else {
	        tail = tail.prev;
	        tail.next = null;
	    }
	}
	
}
