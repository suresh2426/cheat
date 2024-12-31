// Q. Develop a payroll system in Java to illustrate the concept of multi-inheritance. 
// 1. Design an interface called as "NetPayCalculation" with the following method declarations:
// a. void grossPayCalculation();
// b. void taxCalculation();
// c. float netPayCalculation();

// 2. Design a simple class called as "Employee" with the following variables and methods.
// Variables are: int idNo, String name, doj, designation, panNo, department, float basicPay.
// Methods are: void getData() - get all the variables defined/mentioned above.

// 3. Deisgn a main class which is called "PayRoll" extends and implements the above mentioned class and interface respect with following variables and methods.
// Variables are: float grossPay, taxableAmount, netPay.
// Methods are: void displayDetails() - to display all the details about an employee.

// Specifications: grossPayCalculation() method:
// Define 2 float variables da, hra
// where da = 50% of basicPay
//       hra = 20% of basicPay
//       grossPay = sum of da, hra, and basicPay

// taxCalculation() method:
// If the total income for 12 months is between >= 1,00,000 & 2,00,000 then
// taxableAmount = 20% of grossPay
// else if > 3,00,000
// taxableAmount = 30% of grossPay

// netPayCalculation() method:
// from this method, call the grossPayCalculation() and taxCalculation() methods and calculate the netPay as grossPay - taxableAmount;
// return the netPay.

// In the main() method,
// create an object and call the getData() and displayDetails() methods.

import java.util.*;

interface NetPayCalculation {
    void grossPayCalculation();
    void taxCalculation();
    float netPayCalculation();
}

class Employee {
    int idNo;
    String name, doj, designation, panNo, department;
    float basicPay;

    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee ID: ");
        idNo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Employee Name: ");
        name = scanner.nextLine();

        System.out.println("Enter Date of Joining (DD/MM/YYYY): ");
        doj = scanner.nextLine();

        System.out.println("Enter Designation: ");
        designation = scanner.nextLine();

        System.out.println("Enter PAN Number: ");
        panNo = scanner.nextLine();

        System.out.println("Enter Department: ");
        department = scanner.nextLine();

        System.out.println("Enter Basic Pay: ");
        basicPay = scanner.nextFloat();
    }
}

public class PayRoll extends Employee implements NetPayCalculation {
    float grossPay, taxableAmount, netPay;

    public void grossPayCalculation() {
        float da = 0.50f * basicPay; 
        float hra = 0.20f * basicPay; 
        grossPay = basicPay + da + hra;
    }

    public void taxCalculation() {
        float annualIncome = grossPay * 12;
        if (annualIncome >= 100000 && annualIncome <= 200000) {
            taxableAmount = 0.20f * grossPay; 
        } else if (annualIncome > 300000) {
            taxableAmount = 0.30f * grossPay; 
        } else {
            taxableAmount = 0; 
        }
    }

    public float netPayCalculation() {
        grossPayCalculation(); 
        taxCalculation();     
        netPay = grossPay - taxableAmount; 
        return netPay;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + idNo);
        System.out.println("Employee Name: " + name);
        System.out.println("Date of Joining: " + doj);
        System.out.println("Designation: " + designation);
        System.out.println("PAN Number: " + panNo);
        System.out.println("Department: " + department);
        System.out.println("Basic Pay: " + basicPay);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Taxable Amount: " + taxableAmount);
        System.out.println("Net Pay: " + netPay);
    }

    public static void main(String[] args) {
        PayRoll payroll = new PayRoll();  

        payroll.getData();                
        payroll.netPayCalculation();      
        payroll.displayDetails();         
    }
}
