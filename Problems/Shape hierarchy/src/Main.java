abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    private  double sideA;
    private  double sideB;
    private  double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        double square = s * (s - sideA) * (s - sideB) * (s - sideC);
        return Math.sqrt(square);
    }
}

class Circle extends Shape {
    private double radii;
    public Circle(double radius) {
        radii = radius;
    }
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radii;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(radii, 2);
    }
}

class  Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    double getArea() {
        return length * width;
    }
}