package Lab_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

interface Exam {
    public void precent_cal();
}

class Student {
    String name;
    String prn;
    int marks[] = new int[3];

    Boolean valid = true;

    Student() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nEnter name : ");
            this.name = input.readLine();
            System.out.print("Enter PRN : ");
            this.prn = input.readLine();
            System.out.println("Enter marks out of 100 : ");
            for (int i = 0; i < 3; i++) {
                System.out.print("Mark " + i + " : ");
                this.marks[i] = Integer.parseInt(input.readLine());
            }
            if (this.prn.length() <= 3) {
                System.out.println("PRN length should be greater than 3 ");
                this.valid = false;
            }
        } catch (Exception e) {
            this.valid = false;
            System.out.println("Invalid Entry");
            System.out.println(e.getMessage());
        }
    }

    Student(Student st) {
        this.name = st.name;
        this.prn = st.prn;
        this.marks = st.marks.clone();
        this.valid = st.valid;
    }

    public void show() {
        System.out.println("Name :" + this.name);
        System.out.println("Prn : " + this.prn);
        System.out.print("Marks : ");
        for (int i : this.marks) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}

class Result extends Student implements Exam {
    double percentage;

    Result() {
        super();
    }

    Result(Student st) {
        super(st);
    }

    public void precent_cal() {
        int total = 0;
        for (int i : this.marks) {
            total += i;
        }
        this.percentage = (total / 300) * 100;
    }
}

public class Interface_1 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Get Marks percentage");
                System.out.println("5. Remove Students");

                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    break;
                }
                }
            }
        } catch (Exception e) {

        }
    }
}