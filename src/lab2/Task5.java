package lab2;

public class Task5 {
    private double length;
    private double width;

    public Task5(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return String.format("length=%.2f, width=%.2f, area=%.2f, perimeter=%.2f",
                length, width, getArea(), getPerimeter());
    }

    public static void main(String[] args) {
        Task5 rect = new Task5(5, 3);
        System.out.println(rect);
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }
}
