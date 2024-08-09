package Lambda;

import java.util.*;

public class DSA {
    public static void main(String[] args) {

        Employee e1 = new Employee("A", 50, 90000);
        Employee e2 = new Employee("C", 10, 80000);
        Employee e3 = new Employee("B", 20, 70000);

        Map<String, Employee> map = new HashMap<String, Employee>();
        map.put("A", e1);
        map.put("C", e2);
        map.put("B", e3);

        Set<Employee> set = new TreeSet<>(map.values()); // using comparable
        System.out.println(set);

        List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder((a, b) -> a.getKey().compareTo(b.getKey())));
        System.out.println(list);

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
