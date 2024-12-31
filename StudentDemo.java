// Create a class Student with attributes roll no, name, age, and course. Initialize values through parameterized constructor. If age of student is not in between 15 and 21 then generate user-defined exception 'AgeNotWithinRangeException'. If name contains numbers or special symbols raise exception 'NameNotValidException'. Define the two exception classes.

// Custom Exception for Age Validation
class AgeNotWithinRangeException extends Exception {
  public AgeNotWithinRangeException(String message) {
      super(message);
  }
}

// Custom Exception for Name Validation
class NameNotValidException extends Exception {
  public NameNotValidException(String message) {
      super(message);
  }
}

// Student Class
class Student {
  private int rollNo;
  private String name;
  private int age;
  private String course;

  // Parameterized Constructor
  public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
      if (age < 15 || age > 21) {
          throw new AgeNotWithinRangeException("Age must be between 15 and 21.");
      }

      if (!name.matches("[a-zA-Z ]+")) {
          throw new NameNotValidException("Name should only contain alphabets and spaces.");
      }

      this.rollNo = rollNo;
      this.name = name;
      this.age = age;
      this.course = course;
  }

  // Display Student Details
  public void display() {
      System.out.println("Roll No: " + rollNo);
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Course: " + course);
  }
}

// Main Class
public class StudentDemo {
  public static void main(String[] args) {
      try {
          // Creating a valid Student
          Student student1 = new Student(101, "John Doe", 20, "Computer Science");
          student1.display();

          // Creating a Student with invalid age
          Student student2 = new Student(102, "Alice", 22, "Mathematics");

          // Creating a Student with invalid name
          Student student3 = new Student(103, "J@ne123", 19, "Physics");
      } catch (AgeNotWithinRangeException | NameNotValidException e) {
          System.out.println("Error: " + e.getMessage());
      }
  }
}
