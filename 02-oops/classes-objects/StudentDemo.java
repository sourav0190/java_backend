
class Student {
    String name;
    int rollNo;

    // Local Constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // Creating an object
        Student s1 = new Student("Sourav", 101);
        s1.display();
    }
}
