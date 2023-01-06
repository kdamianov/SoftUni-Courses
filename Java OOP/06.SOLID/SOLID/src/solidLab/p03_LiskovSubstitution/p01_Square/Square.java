package solidLab.p03_LiskovSubstitution.p01_Square;

public class Square implements Shape {
    private double side;


    @Override
    public double getArea() {
        return side * side;
    }
}
