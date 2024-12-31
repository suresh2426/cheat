// Define class MyDate with member's day, month, and year. Define default and parameterized constructors. Accept values from the command line and create a date object. Throw user defined exceptions - 'InvalidDayException' or 'InvalidMonthException' if the day and month are invalid. If the date is valid, display message 'Valid date'.

// Custom Exception for Invalid Day
class InvalidDayException extends Exception {
  public InvalidDayException(String message) {
      super(message);
  }
}

// Custom Exception for Invalid Month
class InvalidMonthException extends Exception {
  public InvalidMonthException(String message) {
      super(message);
  }
}

// MyDate Class
class MyDate {
  private int day;
  private int month;
  private int year;

  // Default Constructor
  public MyDate() {
      this.day = 1;
      this.month = 1;
      this.year = 2000;
  }

  // Parameterized Constructor
  public MyDate(int day, int month, int year) throws InvalidDayException, InvalidMonthException {
      if (month < 1 || month > 12) {
          throw new InvalidMonthException("Month must be between 1 and 12.");
      }

      if (day < 1 || day > getDaysInMonth(month, year)) {
          throw new InvalidDayException("Day is not valid for the given month and year.");
      }

      this.day = day;
      this.month = month;
      this.year = year;
  }

  // Utility Method: Get Days in a Month
  private int getDaysInMonth(int month, int year) {
      switch (month) {
          case 1: case 3: case 5: case 7: case 8: case 10: case 12:
              return 31;
          case 4: case 6: case 9: case 11:
              return 30;
          case 2:
              return isLeapYear(year) ? 29 : 28;
          default:
              return 0;
      }
  }

  // Utility Method: Check if Leap Year
  private boolean isLeapYear(int year) {
      return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
  }

  // Display Date
  public void display() {
      System.out.println("Date: " + day + "/" + month + "/" + year);
      System.out.println("Valid date.");
  }
}

// Main Class
public class DateValidation {
  public static void main(String[] args) {
      try {
          // Accept day, month, and year from command line arguments
          if (args.length != 3) {
              System.out.println("Please provide day, month, and year as command line arguments.");
              return;
          }

          int day = Integer.parseInt(args[0]);
          int month = Integer.parseInt(args[1]);
          int year = Integer.parseInt(args[2]);

          // Create a MyDate object
          MyDate date = new MyDate(day, month, year);
          date.display();

      } catch (InvalidDayException | InvalidMonthException e) {
          System.out.println("Error: " + e.getMessage());
      } catch (NumberFormatException e) {
          System.out.println("Error: Please enter numeric values for day, month, and year.");
      }
  }
}
