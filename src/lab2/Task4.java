package lab2;

public class Task4 {
    private String name;
    private int age;
    private String gender;

    public Task4(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age + ", gender=" + gender;
    }

    public static void main(String[] args) {
        Task4 person = new Task4("Иван", 25, "Мужской");
        System.out.println(person);

        person.setAge(26);
        System.out.println("Обновленный возраст: " + person.getAge());
    }
}
