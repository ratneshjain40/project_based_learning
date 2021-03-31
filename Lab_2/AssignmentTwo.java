package Lab_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentTwo {
    public static void main(String[] args) {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. First Program    : Odd-Even Array");
                System.out.println("2. Second program   : Closest Neighbours in an array");
                System.out.println("3. Third program    : Second largest number in an array");
                System.out.println("4. Fourth program   : Convert Array to ArrayList");
                System.out.println("5. Fifth program    : Convert ArrayList to Array ");
                System.out.println("Enter Choice :");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    first_program first = new first_program();
                    first.add_elements();
                    first.display();
                    break;
                }

                case 2: {
                    second_program second = new second_program();
                    second.enter_elements();
                    second.display();
                    break;
                }

                case 3: {
                    third_program third = new third_program();
                    third.enter_elements();
                    third.display();
                    break;
                }

                case 4: {
                    fourth_program fourth = new fourth_program();
                    fourth.enter_elements();
                    fourth.convert();
                    break;
                }

                case 5: {
                    fifth_program fifth = new fifth_program();
                    fifth.enter_elements();
                    fifth.convert();
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

class first_program {
    int[] even;
    int[] odd;

    public void add_elements() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No. of elements you want to enter : ");
        try {
            int n = Integer.parseInt(input.readLine());
            even = new int[n];
            odd = new int[n];
            int even_index = 0;
            int odd_index = 0;
            while (n > 0) {
                System.out.print("Enter element : ");
                int element = Integer.parseInt(input.readLine());
                if (element % 2 == 0) {
                    even[even_index] = element;
                    even_index += 1;
                } else {
                    odd[odd_index] = element;
                    odd_index += 1;
                }
                n -= 1;
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void display() {
        System.out.print("even : ");
        for (int i : even) {
            if (i == 0) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.print("odd : ");
        for (int i : odd) {
            if (i == 0) {
                break;
            }
            System.out.print(i + " ");
        }
    }
}

class second_program {
    int[] arr;
    int index;

    public void enter_elements() {
        int diff = 999;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No. of elements you want to enter : ");
        try {
            int n = Integer.parseInt(input.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element : ");
                int element = Integer.parseInt(input.readLine());
                arr[i] = element;
                if (i > 0) {
                    int temp = Math.abs(arr[i] - arr[i - 1]);
                    if (temp < diff) {
                        diff = temp;
                        index = i - 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void display() {
        System.out.print("Elements with the closest distance are : ");
        System.out.print(arr[index] + " ");
        System.out.print(arr[index + 1]);
    }
}

class third_program {
    int[] arr;
    int large = -1, second_large = -2;

    public void enter_elements() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No. of elements you want to enter : ");
        try {
            int n = Integer.parseInt(input.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element : ");
                int element = Integer.parseInt(input.readLine());
                arr[i] = element;
                if (element > large) {
                    second_large = large;
                    large = element;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void display() {
        System.out.print("Second Greatest Element: " + second_large);
    }

}

class fourth_program {
    String[] arr;

    public void enter_elements() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No. of elements you want to enter : ");
        try {
            int n = Integer.parseInt(input.readLine());
            arr = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element : ");
                String element = input.readLine();
                arr[i] = element;
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void convert() {
        ArrayList<String> arr_list = new ArrayList<String>(Arrays.asList(arr));
        System.out.println("converted array to array list :");
        for (String str : arr_list) {
            System.out.println(str);
        }
    }
}

class fifth_program {
    ArrayList<String> arr_list = new ArrayList<String>();

    public void enter_elements() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("No. of elements you want to enter : ");
        try {
            int n = Integer.parseInt(input.readLine());
            for (int i = 0; i < n; i++) {
                System.out.println("Enter the element you want to enter :");
                String str = input.readLine();
                arr_list.add(str);
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }
    }

    public void convert() {
        String[] arr = arr_list.toArray(new String[arr_list.size()]);
        System.out.println("converted array list to array :");
        for (String str : arr) {
            System.out.println(str);
        }
    }
}