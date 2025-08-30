package felina;

public class Queue {
	private Node front;
	private Node rear;

	private static class Node {
		Student data;
		String eventName;
		Node next;

		public Node(Student data, String eventName) {
			this.data = data;
			this.eventName = eventName;
			this.next = null;
		}
	}

	public void enqueue(Student student, String eventName) {
		try {
			Node newNode = new Node(student, eventName);
			if (rear == null) {
				front = newNode;
				rear = newNode;
			} else {
				rear.next = newNode;
				rear = newNode;
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void enqueueWithPriority(Student student, String eventName) {
		Node newNode = new Node(student, eventName);
		if (front == null || student.getAge() > front.data.getAge()) {
			newNode.next = front;
			front = newNode;
			if (rear == null) {
				rear = newNode;
			}
		} else {
			Node current = front;
			while (current.next != null && current.next.data.getAge() >= student.getAge()) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			if (newNode.next == null) {
				rear = newNode;
			}
		}
	}

	public Student dequeue() {
		try {
			if (front == null) {
				throw new IllegalStateException("Queue is empty");
			}
			Student item = front.data;
			front = front.next;
			if (front == null) {
				rear = null;
			}
			return item;
		} catch (Exception e) {
			System.err.println("Error dequeueing: " + e.getMessage());
			return null;
		}
	}

	public Student dequeueWithPriority() {
		if (isEmpty())
			return null;

		Node highestPriorityNode = front;
		Node current = front;

		while (current != null) {
			if (current.data.getAge() > highestPriorityNode.data.getAge()) {
				highestPriorityNode = current;
			}
			current = current.next;
		}

		if (highestPriorityNode == front) {
			return dequeue();
		} else {
			Node prev = front;
			while (prev.next != highestPriorityNode) {
				prev = prev.next;
			}
			prev.next = highestPriorityNode.next;
			if (highestPriorityNode == rear) {
				rear = prev;
			}
			return highestPriorityNode.data;
		}
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		} else {
			return false;
		}
	}

	public void display() {
		try {
			Node current = front;
			while (current != null) {
				System.out.println("Events: " + current.eventName);
				current = current.next;
			}
		} catch (Exception e) {
			System.out.println("Error displaying queue: " + e.getMessage());
		}
	}

}
