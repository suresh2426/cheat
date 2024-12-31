// Write a predicate method:

//   public static Boolean isLeapYear(int year)

//   That tests whether a year is a leap year; that is, a year with 366 days. Leap years are  necessary to keep the calendar synchronized with the sun, because the earth revolves  around the sun once every 365.25 days. That figure is not entirety precise, and for  dates after 1582 the Gregorian correction applies. Usually, years that are divisible by  are leap years, for example 1996. However, years that are divisible by 100 (for  example, 1900) are not leap years, but years that are divisible by 400 are leap years  (for example. 2000). Now, test the method with a set of years taken from the user until a negative number is entered.

import java.util.*;

public class LeapYearChecker {

    public static Boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter years to check if they are leap years (enter a negative number to stop):");

        while (true) {
            System.out.print("Enter a year: ");
            int year = scanner.nextInt();

            if (year < 0) {
                System.out.println("Exiting program.");
                break;
            }

            if (isLeapYear(year)) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        }

        scanner.close();
    }
}
