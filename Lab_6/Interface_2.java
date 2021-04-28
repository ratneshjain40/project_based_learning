package Lab_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Lab_6.pkg_Stack.Stack_Interface;

class FixedStack implements Stack_Interface {
    private int stk[];
    private int top;

    FixedStack(int size) {
        this.stk = new int[size];
        top = -1;
    }

    @Override
    public void push(int item) {
        if (this.isFull()) {
            System.out.println(("Stack is full. Stack Overflow."));
        } else {
            System.out.println("Adding: " + item);
            this.stk[++top] = item;
        }
    }

    @Override
    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack underflow. Stack is empty.");
        } else {
            int entry = this.stk[top--];
            System.out.println("Removed entry: " + entry);
            return entry;
        }
        return -9999;
    }

    @Override
    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (this.top == (stk.length - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("----------------- Fixed Stack -----------------");
        System.out.println("Capacity -> " + (stk.length - 1));
        System.out.println("top -> " + stk[top]);

        System.out.print("Contents of stack are -> ");
        for (int i = top; i >= 0; i--) {
            System.out.print(this.stk[i] + " ");
        }
    }

}

class DynamicStack implements Stack_Interface {
    private int stk[];
    private int top;

    DynamicStack(int size) {
        this.stk = new int[size];
        top = -1;
    }

    public void expand_stack() {
        int temp[] = new int[this.stk.length * 2];
        for (int i = 0; i < this.stk.length; i++) {
            temp[i] = this.stk[i];
        }
        this.stk = temp;
    }

    @Override
    public void push(int item) {
        if (this.isFull()) {
            System.out.println(("Stack is full. Increasing the capacity."));
            this.expand_stack();
        }
        System.out.println("Adding: " + item);
        this.stk[++top] = item;
    }

    @Override
    public int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack underflow. Stack is empty.");
        } else {
            int entry = this.stk[top--];
            System.out.println("Removed entry: " + entry);
            return entry;
        }
        return -9999;
    }

    @Override
    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (this.top == (stk.length - 1)) {
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("----------------- Dynamic Stack -----------------");
        System.out.println("Capacity -> " + (stk.length - 1));
        System.out.println("top -> " + this.stk[top]);

        System.out.println("Contents of stack are -> ");
        for (int i = this.top; i >= 0; i--) {
            System.out.print(this.stk[i] + " ");
        }
    }

}

public class Interface_2 {
    public static void main(String[] args) {
        FixedStack f_stk = null;
        DynamicStack d_stk = null;

        Stack_Interface my_stack = null;

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Select Stack");
                System.out.println("2. Push");
                System.out.println("3. Pop");
                System.out.println("4. Display");


                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    System.out.println("\nStacks : ");
                    System.out.println("1. Fixed Stack");
                    System.out.println("2. Dynamic Stack");

                    System.out.print("Enter Choice : ");
                    String sh = input.readLine();

                    if (sh.equals("1")) {
                        if (f_stk == null) {
                            System.out.print("Enter size of stack : ");
                            int size = Integer.parseInt(input.readLine());
                            f_stk = new FixedStack(size);
                        }
                        my_stack = f_stk;
                    } else if (sh.equals("2")) {
                        if (d_stk == null) {
                            System.out.print("Enter size of stack : ");
                            int size = Integer.parseInt(input.readLine());
                            d_stk = new DynamicStack(size);
                        }
                        my_stack = d_stk;
                    } else {
                        System.out.println("Invalid Choice!");
                    }
                    break;
                }
                case 2: {
                    if (my_stack != null) {
                        System.out.print("Enter int to push: ");
                        int item = Integer.parseInt(input.readLine());
                        my_stack.push(item);
                    } else {
                        System.out.println("No stack is selected.");
                    }
                    break;
                }
                case 3: {
                    if (my_stack != null) {
                        my_stack.pop();
                    } else {
                        System.out.println("No stack is selected.");
                    }
                    break;

                }
                case 4: {
                    if (my_stack != null) {
                        my_stack.display();
                    } else {
                        System.out.println("No stack is selected.");
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
