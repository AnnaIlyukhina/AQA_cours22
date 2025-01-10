interface Shape {
    double area(); // Метод для расчета площади
    double perimeter(); // Метод для расчета периметра

    String getFillColor(); // Метод для получения цвета заливки
    String getBorderColor(); // Метод для получения цвета границы

    // Дефолтный метод для вывода характеристик фигуры
    default void printCharacteristics() {
        System.out.println("Площадь: " + area());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }
}
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius; // Площадь круга
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius; // Периметр круга
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        return width * height; // Площадь прямоугольника
    }

    @Override
    public double perimeter() {
        return 2 * (width + height); // Периметр прямоугольника
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
class Triangle implements Shape {
    private double a; // Сторона A
    private double b; // Сторона B
    private double c; // Сторона C
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double area() {
        double s = (a + b + c) / 2; // Полупериметр
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Площадь по формуле Герона
    }

    @Override
    public double perimeter() {
        return a + b + c; // Периметр треугольника
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Зеленый", "Синий");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Фиолетовый");

        System.out.println("Характеристики круга:");
        circle.printCharacteristics();

        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.printCharacteristics();

        System.out.println("\nХарактеристики треугольника:");
        triangle.printCharacteristics();

        System.out.println("\nВсего фигур: " + 3);
    }
}
