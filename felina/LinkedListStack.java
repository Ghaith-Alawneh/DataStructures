package felina;

public class LinkedListStack {
	private Node top;
	private int size;

	private static class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			this.next = null;
		}
	}

	public LinkedListStack() {
		this.top = null;
		this.size = 0;
	}

	public void push(String data) {
		if (data == null) {
			System.out.println("There is value");
		}
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		size++;
	}

	public String pop() {
		if (isEmpty()) {
			System.out.println("Empty stack");
			return null;
		}
		String data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}


	public void display() {
		Node current = top;
		System.out.println("Stack contents:");
		while (current != null) {
			System.out.println("| " + current.data + " |");
			current = current.next;
		}
	}
}