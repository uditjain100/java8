package Interfaces;

import java.util.*;

public class ComparableComparator {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A", 50, 10000000));
        employees.add(new Employee("E", 80, 500));
        employees.add(new Employee("B", 20, 200000000));

        // Using Comparable
        Collections.sort(employees);
        System.out.println(employees);

        // Using Comparator

        // Method - 1 - Explicit Class
        Collections.sort(employees, new EmployeeNameComparator());
        System.out.println(employees);

        // Method - 2 - Anonymous Class
        Comparator<Employee> employeeAgeComparator = new Comparator<>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge();
            }
        };
        Collections.sort(employees, employeeAgeComparator);
        System.out.println(employees);

        // Method - 3 - Lambda Expression
        Collections.sort(employees, (e1, e2) -> e1.getSalary() - e2.getSalary());
        System.out.println(employees);
    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo(Employee other) {
        return this.salary - other.salary;
    }

}
