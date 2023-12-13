import java.util.*;
class Shape {
    public Shape() {
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
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

class Square extends Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }
}


class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}

public class ShapesCalculator {
    public static void main(String[] args) {
        
        double radius = 5.0;
        Shape circle = new Circle(radius);
        System.out.println("Area of the circle: " + circle.getArea());
        System.out.println("Perimeter of the circle: " + circle.getPerimeter());

       
        double sideLengthSquare = 4.0;
        Shape square = new Square(sideLengthSquare);
        System.out.println("Area of the square: " + square.getArea());
        System.out.println("Perimeter of the square: " + square.getPerimeter());

       
        double lengthRectangle = 6.0;
        double widthRectangle = 3.0;
        Shape rectangle = new Rectangle(lengthRectangle, widthRectangle);
        System.out.println("Area of the rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of the rectangle: " + rectangle.getPerimeter());
    }
}

