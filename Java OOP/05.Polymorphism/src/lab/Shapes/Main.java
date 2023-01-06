package lab.Shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2D, 4D); //вместо 2.00, 4.0
        Shape circle = new Circle(13.4);

        printShape(rectangle);
        printShape(circle);
    }

    private static void printShape(Shape shape) {
        System.out.println(shape.calculatePerimeter());
        System.out.println(shape.calculateArea());
    }
}
