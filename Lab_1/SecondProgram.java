import java.io.BufferedReader;
import java.io.InputStreamReader;
public class SecondProgram {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Additon");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Divison");
                System.out.println("5. Square root");
                System.out.println("6. Power");
                System.out.println("7. Mean");
                System.out.println("8. GCD");
                System.out.println("Enter Choice :");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                    case 1: {
                        calc.add();
                        break;
                    }
                    case 2: {
                        calc.subtract();
                        break;
                    }
                    case 3: {
                        calc.multipication();
                        break;
                    }
                    case 4: {
                        calc.divison();
                        break;
                    }
                    case 5: {
                        calc.sqrt();
                        break;
                    }
                    case 6: {
                        calc.power();
                        break;
                    }
                    case 7: {
                        calc.mean();
                        break;
                    }
                    case 8: {
                        calc.gcd();
                        break;
                    }
                    default: {
                        loop = false;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }
}

class Calculator {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void add() {
        try {
            System.out.println("Enter Numbers to be Added (A + B): ");
            float a = Integer.parseInt(input.readLine());
            float b = Integer.parseInt(input.readLine());
            System.out.println("Addition is : " + (a + b));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void subtract() {
        try {
            System.out.println("Enter Numbers to be Subtracted (A - B): ");
            float a = Integer.parseInt(input.readLine());
            float b = Integer.parseInt(input.readLine());
            System.out.println("Subtraction is : " + (a - b));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void multipication() {
        try {
            System.out.println("Enter Numbers to be Multiplied (A * B): ");
            float a = Integer.parseInt(input.readLine());
            float b = Integer.parseInt(input.readLine());
            System.out.println("Multiplication is : " + (a * b));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void divison() {
        try {
            System.out.println("Enter Numbers to be divided (A / B): ");
            float a = Integer.parseInt(input.readLine());
            float b = Integer.parseInt(input.readLine());
            System.out.println("Division is : " + (a / b));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void sqrt() {
        try {
            System.out.println("Enter Number to find square root for : ");
            float a = Integer.parseInt(input.readLine());
            System.out.println("Square root is : " + Math.sqrt(a));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void power() {
        try {
            System.out.println("Enter Number to find power for : ");
            float a = Integer.parseInt(input.readLine());
            System.out.println("Enter power : ");
            float b = Integer.parseInt(input.readLine());
            System.out.println("Power is : " + Math.pow(a, b));
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void mean() {
        System.out.println("Enter numbers to find the mean :");
        int i = 0, sum = 0;
        while (true) {
            System.out.print("Entry " + (i + 1) + " : ");
            String str = "";
            try {
                str = input.readLine();
                int num = Integer.parseInt(str);
                sum += num;
                i += 1;
            } catch (Exception e) {
                if (str.equals("end")) {
                    break;
                }
                System.out.println("Invalid Input !");
                break;
            }
        }
        float mean = (float) sum / i;
        System.out.println("Mean is " + mean);
    }

    public void gcd() {
        try {
            System.out.println("Enter numbers to find GCD of :");
            System.out.print("Entry A: ");
            int n1 = Integer.parseInt(input.readLine());
            System.out.print("Entry B: ");
            int n2 = Integer.parseInt(input.readLine());
            int gcd = 1;

            for (int i = 1; i <= n1 && i <= n2; ++i) {
                if (n1 % i == 0 && n2 % i == 0)
                    gcd = i;
            }
            System.out.println("G.C.D  is "+ gcd);
        } catch (Exception e) {
            System.out.println("Invalid Input !");
        }

    }
}
