package Interfaces;

import java.util.*;

public class ComparableComparator {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A", 50, 10000000));
        employees.add(new Employee("E", 80, 500));
        employees.add(new Employee("B", 20, 200000000));

        Collections.sort(employees);
        System.out.println(employees);

        Collections.sort(employees, new EmployeeNameComparator());
        System.out.println(employees);
        Collections.sort(employees, new EmployeeAgeComparator());
        System.out.println(employees);
        Collections.sort(employees, new EmployeeSalaryComparator());
        System.out.println(employees);

    }
}

class EmployeeNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return ((Employee) e1).getName().compareTo(((Employee) e2).getName());
    }
}

class EmployeeAgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return ((Employee) e1).getAge() - ((Employee) e2).getAge();
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return ((Employee) e1).getSalary() - ((Employee) e2).getSalary();
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
