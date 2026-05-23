package lab7.task8;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int    age;
    private String group;
    private double gpa;

    public Student(String name, int age, String group, double gpa) {
        this.name  = name;
        this.age   = age;
        this.group = group;
        this.gpa   = gpa;
    }

    public String getName()  { return name; }
    public int    getAge()   { return age; }
    public String getGroup() { return group; }
    public double getGpa()   { return gpa; }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, group='%s', gpa=%.2f}",
                name, age, group, gpa);
    }
}
