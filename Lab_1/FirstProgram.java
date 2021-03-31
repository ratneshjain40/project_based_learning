package Lab_1;

import java.util.*;
import java.io.*;

public class FirstProgram {
    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                int num = Integer.parseInt(args[0]);
                if (num % 2 == 0) {
                    System.out.println("It is an Even Number");
                } else {
                    System.out.println("It is an Odd Number");
                }
            } catch (Exception e) {
                System.out.println("Not an Integer!");
            }
        } else {
            boolean loop = true;
            Scanner sc = new Scanner(System.in);
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Check whether given number is even or odd.(cmd line program)");
                System.out.println("2. Fibonacci Series");
                System.out.println("3. Factorial of Given Number");
                System.out.println("4. Check whether given number is Prime or not");
                System.out.println("5. Check Leap Year");
                System.out.println("Enter Choice :");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: {
                        System.out.println("Command line program");
                        break;
                    }
                    case 2: {
                        System.out.println("Find fibonacci upto :");
                        int num = sc.nextInt();
                        int a = 0, b = 1, c = 0;
                        System.out.print(a + " " + b);
                        for (int i = 0; i < num - 2; i++) {
                            c = a + b;
                            a = b;
                            b = c;
                            System.out.print(" " + c);
                        }
                        break;
                    }
                    case 3: {
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            System.out.println("Find factorial for num :");
                            String input = br.readLine();
                            int num = Integer.parseInt(input);
                            int fact = 1;
                            for (int i = num; i > 0; i--) {
                                fact = i * fact;
                            }
                            System.out.println("Factorial is : " + fact);
                        } catch (Exception e) {
                            System.out.println("Invaild Input!");
                        }
                        break;
                    }
                    case 4: {
                        //try {
                        //    DataInputStream ds = new DataInputStream(System.in);
                        //    int num = Integer.parseInt(ds.readLine());
                        //    System.out.println("Enter a num to check prime or not : ");
                        //    System.out.println(num);
                        //    boolean flag = false;
                        //    for (int i = 2; i <= num / 2; ++i) {
                        //        if (num % i == 0) {
                        //            flag = true;
                        //            break;
                        //        }
                        //    }
                        //    if (!flag) {
                        //        System.out.println(num + " is a prime number.");
                        //    } else {
                        //        System.out.println(num + " is not a prime number.");
                        //    }
                        //} catch (Exception e) {
                        //    System.out.println("Invaild Input!");
                        //}
                        break;
                    }
                    case 5: {
                        Console con = System.console();
                        System.out.println("Enter Year : ");
                        int year = Integer.parseInt(con.readLine());
                        boolean leap = false;

                        if (year % 4 == 0) {

                            if (year % 100 == 0) {

                                if (year % 400 == 0) {
                                    leap = true;
                                } else {
                                    leap = false;
                                }
                            } else {
                                leap = true;
                            }
                        } else {
                            leap = false;
                        }
                        if (leap) {
                            System.out.println(year + " is a leap year.");
                        } else {
                            System.out.println(year + " is not a leap year.");
                        }
                        break;
                    }
                    default: {
                        loop = false;
                        break;
                    }
                }
            }
            sc.close();
        }
    }
}