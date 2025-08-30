package felina;

public class Student {
	private int id;
	private String name;
	private int age;
	private int roomNumber;

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.roomNumber = 0;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getRoomNumber() {
		return roomNumber;
	}
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Age: " + age;
	}
}