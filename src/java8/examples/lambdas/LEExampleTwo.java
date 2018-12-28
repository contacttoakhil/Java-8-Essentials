package java8.examples.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
    public int compareName(Employee e2) {
        return name.compareTo(e2.getName());
    }
}

public class LEExampleTwo {
    public static void main(String[] args) {
        List<Employee> employees = getEmployees();
        System.out.println(employees);
        //employees.sort((e1,e2) -> e1.getName().compareTo(e2.getName()));
        employees.sort(Employee::compareName);
        System.out.println(employees);

        //employees.forEach(System.out::println);
        //employees.stream().forEach(System.out::println);
        //System.out.println(employees);
    }

    private static List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee("Brain"),
                new Employee("Adam"),
                new Employee("Carrie"),
                new Employee("Donald")
                ));
        return employeeList;
    }
}
