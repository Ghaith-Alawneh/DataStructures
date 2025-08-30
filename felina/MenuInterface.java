package felina;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInterface {
	public static void main(String[] args) {
		UndoRedoManager UndoRedo = new UndoRedoManager();
		RoomBooking2 roomBooking = new RoomBooking2(UndoRedo);
		EventRegistration2 eventRegistration = new EventRegistration2();
		RecordLinkedList recordList = new RecordLinkedList();
		BST bst = new BST();
		Graph graph = new Graph(5);
		String[] buildingNames = { "Library", "Cafeteria", "Gym", "Lab", "Offices" };
		Scanner scanner = new Scanner(System.in);

		Student alice = new Student(100, "Alice", 20);
		Student bob = new Student(200, "Bob", 21);
		Student carol = new Student(300, "Carol", 22);

		// Locker insertion
		bst.insert(alice);
		bst.insert(bob);
		bst.insert(carol);

		// Weighing the graph edges
		graph.addWeightedEdge(0, 1, 5); // Library - Cafeteria
		graph.addWeightedEdge(1, 3, 3); // Cafeteria - Lab
		graph.addWeightedEdge(2, 3, 7); // Gym - Lab
		graph.addWeightedEdge(3, 4, 4); // Lab - Offices

		while (true) {
			try {
				System.out.println("Campus Management System");
				System.out.println("1. Lost and Found Records");
				System.out.println("2. Room Booking");
				System.out.println("3. Undo/Redo Last Room Booking Action");
				System.out.println("4. View Campus Map (Graph)");
				System.out.println("5. Find Shortest Path Between Buildings");
				System.out.println("6. Event Registration");
				System.out.println("7. Locker Management");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Lost and Found Records:");
					recordList.addRecord("Lost Wallet", "Cafeteria");
					recordList.addRecord("Found Umbrella", "Library");
					recordList.viewRecords();
					break;

				case 2:
					System.out.println("Room Booking:");
					roomBooking.requestBooking(alice, 101);
					roomBooking.requestBooking(bob, 102);
					roomBooking.viewBookings();
					roomBooking.processBooking();
					roomBooking.viewBookings();
					break;

				case 3:
					System.out.println("Undo last Room Booking action:");
					UndoRedo.undo();
					System.out.println("Redo last Room Booking action:");
					UndoRedo.redo();
					break;

				case 4:
					System.out.println("Campus Map (Graph):");
					graph.printGraph();
					break;

				case 5:
					System.out.println("Finding Shortest Path from Library to Offices:");
					graph.Starttofinish(0, 4, graph.graphMatrix, buildingNames);
					break;

				case 6:
					System.out.println("Event Registration:");
					eventRegistration.viewRegistrations();
					eventRegistration.processRegistration();
					eventRegistration.viewRegistrations();
					break;

				case 7:
					System.out.println("Locker Management:");
					System.out.print("Enter Student ID to search locker: ");
					int searchId = scanner.nextInt();
					if (bst.search(searchId)) {
						System.out.println("Locker found for Student ID " + searchId + ".");
					} else {
						System.out.println("Locker NOT found for Student ID " + searchId + ".");
					}

					System.out.print("Enter Student ID to remove locker: ");
					int removeId = scanner.nextInt();
					bst.remove(removeId);
					System.out.println("Locker removed for Student ID " + removeId + ".");

					if (!bst.search(removeId)) {
						System.out.println("Confirmed: Locker successfully removed.");
					}
					break;

				case 0:
					System.out.println("Exiting System. Goodbye!");
					scanner.close();
					return;

				default:
					System.out.println("Invalid choice. Please try again.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();
			}
		}
	}
}