package Lab_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

abstract class Shapes {
    private String color;
    private Boolean filled;

    Shapes() {
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

    Circle() {
    }

    Circle(double radius) {
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

    Rectangle() {
    }

    Rectangle(double length, double width) {
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
    Square() {
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

public class Program_1 {
    public static void main(String[] args) {
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
                    break;
                }
                case 2: {
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
