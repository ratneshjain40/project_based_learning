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
    public String toString() {
        String area = "Area is : " + getArea() + "\n";
        String peremeter = "Peremeter is : " + getPeremeter();
        String str = area.concat(peremeter);
        return str;
    }

    abstract double getArea();

    abstract double getPeremeter();
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

    double getArea() {
        // TODO Auto-generated method stub
        return 0;
    }

    double getPeremeter() {
        // TODO Auto-generated method stub
        return 0;
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

    double getArea() {
        // TODO Auto-generated method stub
        return 0;
    }

    double getPeremeter() {
        // TODO Auto-generated method stub
        return 0;
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
                    System.out.println("1. Circle");
                    System.out.println("2. Rectange");
                    System.out.println("3. Square");

                    System.out.print("Enter Choice : ");
                    String sh = input.readLine();

                    if (sh.equals("1")) {
                        System.out.print("Enter Radius : ");
                        double rad = Integer.parseInt(input.readLine());

                        Circle cir = new Circle(rad);
                        circle = cir;
                    } else if (sh.equals("2")) {
                        System.out.print("Enter Length : ");
                        double length = Integer.parseInt(input.readLine());
                        System.out.print("Enter Width : ");
                        double width = Integer.parseInt(input.readLine());

                        Rectangle rect = new Rectangle(length, width);
                        rectangle = rect;
                    } else if (sh.equals("3")) {
                        System.out.print("Enter Side : ");
                        double length = Integer.parseInt(input.readLine());

                        Square squ = new Square(length);
                        square = squ;
                    } else {
                        System.out.println("Not an Option !");
                    }

                    break;
                }
                case 2: {
                    if (circle != null) {
                        System.out.println("Shape : Circle");
                        System.out.println("Color : " + circle.getColor());
                        System.out.println("Filled : " + circle.getFilled());
                        System.out.println("Area : " + circle.getArea());
                        System.out.println("Peremeter: " + circle.getPeremeter());
                    }
                    if (rectangle != null) {
                        System.out.println("Shape : Rectangle");
                        System.out.println("Color : " + rectangle.getColor());
                        System.out.println("Filled : " + rectangle.getFilled());
                        System.out.println("Area : " + rectangle.getArea());
                        System.out.println("Peremeter: " + rectangle.getPeremeter());
                    }
                    if (square != null) {
                        System.out.println("Shape : Square");
                        System.out.println("Color : " + square.getColor());
                        System.out.println("Filled : " + square.getFilled());
                        System.out.println("Area : " + square.getArea());
                        System.out.println("Peremeter: " + square.getPeremeter());
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
