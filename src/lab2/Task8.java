package lab2;

class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Животное издает звук");
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }
}

class Dog extends Animal {
    private final String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }

    public void fetch() {
        System.out.println(breed + " " + name + " приносит палку");
    }
}

class Cat extends Animal {
    private final String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Мяу-мяу!");
    }

    public void scratch() {
        System.out.println(color + " " + name + " точит когти");
    }
}

abstract class ShapeBase {
    public abstract double getArea();
    public abstract double getPerimeter();

    public void display() {
        System.out.println("Площадь: " + getArea() + ", Периметр: " + getPerimeter());
    }
}

class Circle2 extends ShapeBase {
    private final double radius;

    public Circle2(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class InheritanceTest {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик", 3, "Овчарка");
        Cat cat = new Cat("Мурка", 2, "Рыжий");

        dog.displayInfo();
        dog.makeSound();
        dog.fetch();

        cat.displayInfo();
        cat.makeSound();
        cat.scratch();

        Circle2 circle = new Circle2(5);
        circle.display();
    }
}