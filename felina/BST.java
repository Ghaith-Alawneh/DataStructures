package felina;

public class BST {

	class Node {
		Student student;
		Node left, right;

		public Node(Student student) {
			this.student = student;
			this.left = null;
			this.right = null;
		}
	}

	Node root;

	private Node insertTree(Node root, Student student) {
		if (root == null) {
			root = new Node(student);
			return root;
		}
		if (student.getID() < root.student.getID())
			root.left = insertTree(root.left, student);
		else if (student.getID() > root.student.getID())
			root.right = insertTree(root.right, student);
		else
			System.out.println("Student ID " + student.getID() + " already has a locker.");
		return root;
	}

	public void insert(Student student) {
		root = insertTree(root, student);
	}

	private boolean searchTree(Node root, int studentID) {
		if (root == null) {
			return false;
		}
		if (root.student.getID() == studentID) {
			return true;
		}
		if (studentID < root.student.getID()) {
			return searchTree(root.left, studentID);
		} else {
			return searchTree(root.right, studentID);
		}
	}

	public boolean search(int studentID) {
		return searchTree(root, studentID);
	}

	private Node findMin(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	private Node removeTree(Node root, int studentID) {
		if (root == null) {
			return null;
		}

		if (studentID < root.student.getID()) {
			root.left = removeTree(root.left, studentID);
		} else if (studentID > root.student.getID()) {
			root.right = removeTree(root.right, studentID);
		} else {

			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			Node minNode = findMin(root.right);
			root.student = minNode.student;
			root.right = removeTree(root.right, minNode.student.getID());
		}
		return root;
	}

	public void remove(int studentID) {
		if (search(studentID)) {
			root = removeTree(root, studentID);
			System.out.println("Removed locker for Student ID: " + studentID);
		} else {
			System.out.println("Student ID " + studentID + " not found.");
		}
	}

}
