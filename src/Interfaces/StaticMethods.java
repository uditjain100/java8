package Interfaces;

public class StaticMethods implements Employee {
    public static void main(String[] args) {
        Employee.displaySalary();
        displaySalary();
    }

    static void displaySalary() {
        System.out.println("Salary: Rs. 50,000");
    }
}

interface Employee {
    static void displaySalary() {
        System.out.println("Salary: $50,000");
    }
}
