package Lab_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Employee {
    int id;
    String name;
    String gender;
    int salary;
    String job_title;
    String organization;

    Boolean valid = true;

    Employee() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("\nEnter Employee ID : ");
            this.id = Integer.parseInt(input.readLine());
            System.out.print("Enter name : ");
            this.name = input.readLine();
            System.out.print("Enter Gender (M/F) : ");
            this.gender = input.readLine();
            System.out.print("Enter Salary : ");
            this.salary = Integer.parseInt(input.readLine());
            System.out.print("Enter Job Title : ");
            this.job_title = input.readLine();
            System.out.print("Enter Organization Name : ");
            this.organization = input.readLine();

        } catch (Exception e) {
            this.valid = false;
            System.out.println("Invalid Entry");
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.println("ID : " + this.id);
        System.out.println("Name :" + this.name);
        System.out.println("Gender (M/F) : " + this.gender);
        System.out.println("Salary : " + this.salary);
        System.out.println("Job Title : " + this.job_title);
        System.out.println("Organization Name : " + this.organization);
    }
}

class EmployeeList {
    ArrayList<Employee> employees;

    EmployeeList() {
        employees = new ArrayList<Employee>();
    }

    public void add_employee(Employee a) {
        if (a.valid) {
            employees.add(a);
        } else {
            System.out.println("Invalid Entry");
        }
    }

    public void display_employees() {
        int i = 0;
        for (Employee ep : employees) {
            System.out.println("\nEmployee " + (i + 1) + " : ");
            ep.show();
            i += 1;
        }
    }

    public Employee search_employee(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Give Name/ID to get Employee : ");

        try {
            String input_str = input.readLine();
            try {
                int id_input = Integer.parseInt(input_str);
                for (Employee ep : employees) {
                    if(ep.id == id_input){
                        return ep;
                    }
                }
            } catch (Exception e) {
                for (Employee ep : employees) {
                    if(ep.name.equals(input_str)){
                        return ep;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error taking input");
        }
        return null;
    }

    public void remove_employee() {
        Employee ep = search_employee();
        if (ep != null) {
            System.out.println("Removing employee : ");
            ep.show();
            employees.remove(ep);
        } else {
            System.out.println("Can't Find employee to Remove!");
        }
    }

    public void compare_employees_by_salary(Employee a, Employee b) {
        if (a.salary < b.salary) {
            System.out.printf("%s earns more than %s \n", b.name, a.name);
        } else if (a.salary > b.salary) {
            System.out.printf("%s earns more than %s \n", a.name, b.name);
        } else {
            System.out.printf("%s and %s both earn the same \n", a.name, b.name);
        }
    }

    public void sort_by_name() {
        Collections.sort(this.employees, new sortbyname());
        this.display_employees();
    }

}

class sortbyname implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        return a.name.compareTo(b.name);
    }
}

public class Program_2 {
    public static void main(String[] args) {
        EmployeeList eplist = new EmployeeList();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Add Employee");
                System.out.println("2. Delete Employee");
                System.out.println("3. Display Employee");
                System.out.println("4. Search Employee");
                System.out.println("5. Compare by salary");
                System.out.println("6. Sort by name");

                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    eplist.add_employee(new Employee());
                    break;
                }

                case 2: {
                    eplist.remove_employee();;
                    break;
                }

                case 3: {
                    eplist.display_employees();
                    break;
                }

                case 4: {
                    Employee ep = eplist.search_employee();
                    System.out.println("Found employee : ");
                    ep.show();
                    break;
                }

                case 5: {
                    Employee ep1 = eplist.search_employee();
                    Employee ep2 = eplist.search_employee();
                    eplist.compare_employees_by_salary(ep1,ep2);
                    break;
                }

                case 6: {
                    eplist.sort_by_name();
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
