package Lab_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

abstract class Shapes {
    private String color;
    private Boolean filled;

    Shapes() {
        this.color = "No Color";
        this.filled = false;
    }

    Shapes(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    @Override
    public abstract String toString();

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Circle extends Shapes {
    private double radius;

    Circle(double radius) {
        super();
        this.radius = radius;
    }

    Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = 3.14 * Math.pow(radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 2 * 3.14 * radius;
        return perimeter;
    }

    @Override
    public String toString() {
        return String.format("Area: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nColor: " + getColor()
                + "\nFilled: " + getFilled());
    }
}

class Rectangle extends Shapes {
    private double width;
    private double length;

    Rectangle(double length, double width) {
        super();
        this.length = length;
        this.width = width;

    }

    Rectangle(double length, double width, String color, Boolean filled) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        double area = length * width;
        return area;
    }

    public double getPerimeter() {
        double perimeter = 2 * (length + width);
        return perimeter;
    }

    @Override
    public String toString() {
        return String.format("Area: " + getArea() + "\nPerimeter: " + getPerimeter() + "\nColor: " + getColor()
                + "\nFilled: " + getFilled());
    }
}

class Square extends Rectangle {

    Square(double side) {
        super(side, side);
    }

    Square(double side, String color, Boolean filled) {
        super(side, side, color, filled);
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public double getSide() {
        return super.getLength();
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setLength(width);
        super.setWidth(width);
    }
}

public class Inheritance_1 {
    public static void main(String[] args) {
        Circle circle = null;
        Rectangle rectangle = null;
        Square square = null;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Create Shape");
                System.out.println("2. Print Shape");

                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    System.out.println("\nShape : ");
                    System.out.println("1. Circle");
                    System.out.println("2. Rectange");
                    System.out.println("3. Square");

                    System.out.print("Enter Choice : ");
                    String sh = input.readLine();

                    if (sh.equals("1")) {
                        System.out.print("Enter Radius : ");
                        double radius = Integer.parseInt(input.readLine());
                        System.out.print("Enter color : ");
                        String color = input.readLine();
                        System.out.print("Is it filled? True / False : ");
                        boolean filled = Boolean.parseBoolean(input.readLine());

                        Circle cir = new Circle(radius, color, filled);
                        circle = cir;

                    } else if (sh.equals("2")) {
                        System.out.print("Enter Length : ");
                        double length = Integer.parseInt(input.readLine());
                        System.out.print("Enter Width : ");
                        double width = Integer.parseInt(input.readLine());
                        System.out.print("Enter color : ");
                        String color = input.readLine();
                        System.out.print("Is it filled? True / False : ");
                        boolean filled = Boolean.parseBoolean(input.readLine());

                        Rectangle rect = new Rectangle(length, width, color, filled);
                        rectangle = rect;

                    } else if (sh.equals("3")) {
                        System.out.print("Enter Side : ");
                        double length = Integer.parseInt(input.readLine());
                        System.out.print("Enter color : ");
                        String color = input.readLine();
                        System.out.print("Is it filled? True / False : ");
                        boolean filled = Boolean.parseBoolean(input.readLine());

                        Square squ = new Square(length, color, filled);
                        square = squ;

                    } else {
                        System.out.println("Not an Option !");
                    }

                    break;
                }
                case 2: {
                    int counter = 0;
                    if (circle != null) {
                        System.out.println("\nShape : Circle");
                        System.out.println("Color : " + circle.toString());
                    } else {
                        counter = counter + 1;
                    }
                    if (rectangle != null) {
                        System.out.println("\nShape : Rectangle");
                        System.out.println("Color : " + rectangle.toString());
                    } else {
                        counter = counter + 1;
                    }
                    if (square != null) {
                        System.out.println("\nShape : Square");
                        System.out.println("Color : " + square.toString());
                    } else {
                        counter = counter + 1;
                    }

                    if (counter == 3) {
                        System.out.println("Any Shape not created");
                    }
                    break;
                }
                default: {
                    break;
                }
                }
            }
        } catch (Exception e) {

        }
    }
}
