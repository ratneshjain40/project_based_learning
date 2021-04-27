import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Date_of_birth {
    int day, month, year;

    Boolean valid = true;

    Date_of_birth() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter date of birth in dd-mm-yy format :");
            String date_input = new String(input.readLine());
            String[] split_date = date_input.split("-");

            this.day = Integer.parseInt(split_date[0]);
            this.month = Integer.parseInt(split_date[1]);
            this.year = Integer.parseInt(split_date[2]);
            if (this.year <= 2021 && this.month <= 12 && this.day <= 31) {
                System.out.println("The date is " + date_input);
            } else {
                this.valid = false;
                System.out.println("Invalid date");
            }
        } catch (Exception e) {
            this.valid = false;
            System.out.println("Invalid date format");
        }
    }
}

class Student {
    String name;
    String prn;
    int marks;
    Date_of_birth dob;

    Boolean valid = true;

    Student() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nEnter name : ");
            this.name = input.readLine();
            System.out.print("Enter PRN : ");
            this.prn = input.readLine();
            System.out.print("Enter marks out of 100 : ");
            this.marks = Integer.parseInt(input.readLine());
            this.dob = new Date_of_birth();
            if (!this.dob.valid) {
                this.valid = false;
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

    public String get_grade() {
        if (marks <= 100 && marks > 80) {
            return "A";
        } else if (marks <= 80 && marks > 60) {
            return "B";

        } else if (marks <= 60 && marks > 40) {
            return "C";

        } else if (marks <= 40 && marks > 20) {
            return "D";

        }
        return "F";
    }

    public void show() {
        System.out.println("Name :" + this.name);
        System.out.println("Prn : " + this.prn);
        System.out.println("Marks out of 100 : " + this.marks);
        System.out.printf("DOB is %d-%d-%d\n", this.dob.day, this.dob.month, this.dob.year);
    }
}

class StudentList {
    ArrayList<Student> students;

    StudentList() {
        students = new ArrayList<Student>();
    }

    public void add_student(Student a) {
        if (a.valid) {
            students.add(a);
        } else {
            System.out.println("Invalid Entry");
        }
    }

    public void display_students() {
        int i = 0;
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()) {
            Student st = iter.next();
            System.out.println("\nStudent " + (i + 1) + " : ");
            st.show();
            i += 1;
        }
    }

    public Student search_student() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Give Name/Prn/Position to get Student : ");
        try {
            String input_str = input.readLine();
            try {
                Integer.parseInt(Character.toString(input_str.charAt(0)));
                if (input_str.length() > 3) {
                    for (Student st : students) {
                        if (st.prn.equals(input_str)) {
                            return st;
                        }
                    }
                    System.out.println("No Prn found");
                    return null;
                } else {
                    if (Integer.parseInt(input_str) <= (students.size() - 1)) {
                        return students.get(Integer.parseInt(input_str));
                    }
                    System.out.println("Position out of range");
                    return null;
                }
            } catch (Exception e) {
                for (Student st : students) {
                    if (st.name.equals(input_str)) {
                        return st;
                    }
                }
                System.out.println("No Name found");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error taking input");
        }
        return null;
    }

    public void update_student() {
        Student st = search_student();
        if (st != null) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            boolean loop = true;
            try {
                while (loop) {
                    System.out.println("\nWhat do you want to update? : ");
                    System.out.println("1. Name");
                    System.out.println("2. Prn");
                    System.out.println("3. Marks");
                    System.out.println("4. Save and continue");

                    System.out.print("Enter Choice :");
                    int ch = Integer.parseInt(input.readLine());
                    switch (ch) {
                    case 1: {
                        System.out.println("\nEnter new name : ");
                        st.name = input.readLine();
                        break;
                    }
                    case 2: {
                        System.out.println("Enter new PRN : ");
                        st.prn = input.readLine();
                        break;
                    }
                    case 3: {
                        System.out.println("Enter new name : ");
                        st.marks = Integer.parseInt(input.readLine());
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

            st.show();
        } else {
            System.out.println("Can't Find Student to Update!");
        }
    }

    public void remove_student() {
        Student st = search_student();
        if (st != null) {
            System.out.println("Removing student : ");
            st.show();
            students.remove(st);
        } else {
            System.out.println("Can't Find Student to Remove!");
        }
    }

    public void sort_students() {
        Collections.sort(this.students, new sortbymarks());
        this.display_students();
    }

    public void get_grade_data() {
        int A = 0, B = 0, C = 0, D = 0, F = 0;
        for (Student st : students) {
            if (st.get_grade().equals("A")) {
                A++;
            } else if (st.get_grade().equals("B")) {
                B++;
            } else if (st.get_grade().equals("C")) {
                C++;
            } else if (st.get_grade().equals("D")) {
                D++;
            } else if (st.get_grade().equals("F")) {
                F++;
            }
        }
        System.out.printf("\nA grade : %d students", A);
        System.out.printf("B grade : %d students", B);
        System.out.printf("C grade : %d students", C);
        System.out.printf("D grade : %d students", D);
        System.out.printf("F grade : %d students", F);
    }
}

class sortbymarks implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.marks - b.marks;
    }
}

public class Program_1 {
    public static void main(String[] args) {
        StudentList slist = new StudentList();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Students");
                System.out.println("4. Update Students");
                System.out.println("5. Remove Students");
                System.out.println("6. Sort Students");
                System.out.println("7. Get grades");

                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    slist.add_student(new Student());
                    break;
                }

                case 2: {
                    slist.display_students();
                    break;
                }

                case 3: {
                    Student st = slist.search_student();
                    System.out.println("Found Student : ");
                    st.show();
                    break;
                }

                case 4: {
                    slist.update_student();
                    break;
                }

                case 5: {
                    slist.remove_student();
                    break;
                }

                case 6: {
                    slist.sort_students();
                    break;
                }

                case 7: {
                    slist.get_grade_data();
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
