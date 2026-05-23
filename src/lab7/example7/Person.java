package lab7.example7;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name  = name;
        this.age   = age;
        this.email = email;
    }

    public String getName()  { return name; }
    public int    getAge()   { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
