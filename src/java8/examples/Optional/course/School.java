package java8.examples.Optional.course;

import java.util.ArrayList;
import java.util.List;

class Student {
    private int numberOfStudents;
    public Student(int number) {
        this.numberOfStudents = number;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}

class Module {
    private Student students;
    private String moduleName;
    public Module(String moduleName) {
        this.moduleName = moduleName;
    }
    public String getModuleName() {
        return moduleName;
    }
    public Student getStudent() {
        return students;
    }
    public void setStudents(Student students) {
        this.students = students;
    }
}

class Course {
    private List<Module> modules = new ArrayList();
    public void addModule(Module module) {
        modules.add(module);
    }
    public List<Module> getModules() {
        return modules;
    }
}

public class School {
    public static void main(String[] args) {
        Course computerScience = new Course();
        Module algorithms = new Module("Algorithms");
        Student studentsOnAlgorithm = new Student(50);
        algorithms.setStudents(studentsOnAlgorithm);
        computerScience.addModule(algorithms);
        //Module cancelledModules = new Module("Pascal"); // This module is discontinued say (having no students and hence NPE is expected).
        //computerScience.addModule(cancelledModules);
        computerScience.getModules().
                stream().
                forEach( (m) -> System.out.println("Module -> " + m.getModuleName() + " and " + m.getStudent().getNumberOfStudents() + " took this course."));
    }
}

// How to fix this example? Use Optional<Student>?