package Lab_7;

import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class RationalNumbers {
    int numerator;
    int denominator;

    public RationalNumbers(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    public void reduce() {
        int gcd = calculateGCD(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public RationalNumbers add(RationalNumbers fraction) {
        int newNumerator = (numerator * fraction.denominator) + (fraction.numerator * denominator);
        int newDenominator = denominator * fraction.denominator;
        RationalNumbers result = new RationalNumbers(newNumerator, newDenominator);
        return result;
    }

    public RationalNumbers subtract(RationalNumbers fraction) {
        int newNumerator = (numerator * fraction.denominator) - (fraction.numerator * denominator);
        int newDenominator = denominator * fraction.denominator;
        RationalNumbers result = new RationalNumbers(newNumerator, newDenominator);
        return result;
    }

    public RationalNumbers multiply(RationalNumbers fraction) {
        int newNumerator = numerator * fraction.numerator;
        int newDenominator = denominator * fraction.denominator;
        RationalNumbers result = new RationalNumbers(newNumerator, newDenominator);
        return result;
    }

    public RationalNumbers divide(RationalNumbers fraction) {
        int newNumerator = numerator * fraction.denominator;
        int newDenominator = denominator * fraction.numerator;
        RationalNumbers result = new RationalNumbers(newNumerator, newDenominator);
        return result;
    }

    public boolean compare() {
        if (this.numerator > 0 && this.denominator > 0) {
            return true;
        }
        return false;
    }

    public float floatingPoint() {
        float n1 = this.numerator;
        float d1 = this.denominator;
        return n1 / d1;
    }

    public static void absolute(RationalNumbers fraction) {
        if (fraction.numerator < 0) {
            System.out.println("Absolute Value of " + fraction + " is: " + Math.abs(fraction.numerator) + "/"
                    + fraction.denominator);
        } else {
            System.out.println("Absolute Value of " + fraction + " is: " + fraction.numerator + "/"
                    + Math.abs(fraction.denominator));
        }
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

public class Program_7_1 {

    public static void main(String[] args) throws ArithmeticException, InputMismatchException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n1, n2, d1, d2;
            while (true) {
                try {
                    System.out.print("Enter Numerator and Denominator of Rational Number 1:");
                    n1 = Integer.parseInt(input.readLine());
                    d1 = Integer.parseInt(input.readLine());
                    break;
                } catch (InputMismatchException i) {
                    System.out.println("\nEnter an Integer Value for both Numerator and Denominator\n");
                    input.readLine();
                } catch (ArithmeticException a) {
                    System.out.println("\nDon't enter the Denominator as 0\n");
                }
            }
            while (true) {
                try {
                    System.out.print("Enter Numerator and Denominator of Rational Number 2:");
                    n2 = Integer.parseInt(input.readLine());
                    d2 = Integer.parseInt(input.readLine());
                    break;
                } catch (ArithmeticException a) {
                    System.out.println("\nDenominator cannot be 0\n");
                } catch (InputMismatchException i) {
                    System.out.println("\nEnter an Integer Value for both Numerator and Denominator\n");
                    input.readLine();
                }
            }
            RationalNumbers r1 = new RationalNumbers(n1, d1);
            System.out.println("Rational number 1: " + r1.toString());
            RationalNumbers r2 = new RationalNumbers(n2, d2);
            System.out.println("Rational number 2: " + r2.toString());
            RationalNumbers r3;
            System.out.println("\n-----/MENU/-----\n");
            System.out.println("1.Add");
            System.out.println("2.Subtract");
            System.out.println("3.Multiply");
            System.out.println("4.Divide");
            System.out.println("5.Compare");
            System.out.println("6.Convert to Floating Point");
            System.out.println("7.Find Absolute Value");
            System.out.println("8.Exit\n");
            while (true) {
                System.out.print("Enter your Choice:");
                int choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                        r3 = r1.add(r2);
                        System.out.println("Result of addition of " + r1 + " and " + r2 + " is : " + r3);
                        break;
                    case 2:
                        r3 = r1.subtract(r2);
                        System.out.println("Result of subtraction of " + r1 + " and " + r2 + " is : " + r3);
                        break;
                    case 3:
                        r3 = r1.multiply(r2);
                        System.out.println("Result of multiplication of " + r1 + " and " + r2 + " is : " + r3);
                        break;
                    case 4:
                        r3 = r1.divide(r2);
                        System.out.println("Result of division of " + r1 + " and " + r2 + " is : " + r3);
                        break;
                    case 5:
                        r3 = r1.subtract(r2);
                        boolean cmp = r3.compare();
                        if (cmp == true) {
                            System.out.println(r1 + " is greater than " + r2);
                        } else {
                            System.out.println(r2 + " is greater than " + r1);
                        }
                        break;
                    case 6:
                        System.out.print(r1 + " = ");
                        System.out.format("%.2f", r1.floatingPoint());
                        System.out.println();
                        System.out.print(r2 + " = ");
                        System.out.format("%.2f", r2.floatingPoint());
                        System.out.println();
                        break;
                    case 7:
                        RationalNumbers.absolute(r1);
                        RationalNumbers.absolute(r2);
                        break;
                    case 8:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Inavlid Input");
        }
    }
}