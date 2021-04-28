package Lab_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Account {
    public String cust_name;
    public int acc_num;

    public void setData(String cust_name, int acc_num) {
        this.cust_name = cust_name;
        this.acc_num = acc_num;
    }

    public void getData() {
        System.out.print("Customer Name: " + cust_name + "\nAccount Number: " + acc_num);
    }
}

class savingAcc extends Account {
    public double min_balance;
    public double sav_bal;

    public savingAcc() {
        this.min_balance = 5000;
    }

    public void setData(String cust_name, int acc_num, double sav_bal) {
        super.setData(cust_name, acc_num);
        if (sav_bal < min_balance) {
            System.out.println("Saving Balance is less than minimum balance!");
        }
        this.sav_bal = sav_bal;
    }

    public void getData() {
        super.getData();
        System.out.println("\nSaving account Balance: " + sav_bal);
    }
}

class accDetail extends savingAcc {
    private double withdraw;
    private double deposit;

    public accDetail() {
        super();
    }

    public void setData(String cust_name, int acc_num, double sav_bal) {
        super.setData(cust_name, acc_num, sav_bal);
    }

    public void setData(double money, String choice) {
        if (choice.equals("withdraw")) {
            this.withdraw = money;
            this.sav_bal = this.sav_bal - this.withdraw;
        } else if (choice.equals("deposit")) {
            this.deposit = money;
            this.sav_bal = this.sav_bal + this.deposit;
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void getData() {
        System.out.println("------------ Info ------------");
        super.getData();
        if (this.sav_bal < this.min_balance) {
            System.out.println("Please Deposit atleast Rs." + (this.min_balance - this.sav_bal)
                    + " to keep your account above minimum balance.");
        }

    }
}

class AccountList {
    public ArrayList<accDetail> accounts;

    AccountList() {
        this.accounts = new ArrayList<accDetail>();
    }

    public accDetail create_account() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        accDetail acc_temp = null;

        try {
            System.out.print("\nEnter name : ");
            String name = input.readLine();
            System.out.print("Enter account number : ");
            int num = Integer.parseInt(input.readLine());
            System.out.print("Enter savings : ");
            int bal = Integer.parseInt(input.readLine());

            for (accDetail acc : accounts) {
                if (acc.acc_num == num || acc.cust_name.equals(name)) {
                    System.out.println("Acc alreday exists! ");
                    return acc_temp;
                }
            }

            acc_temp = new accDetail();
            acc_temp.setData(name, num, bal);

        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        return acc_temp;
    }

    public accDetail search_account() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        accDetail acc_temp = null;

        try {

            System.out.print("\nEnter name or number to search account : ");
            String str_input = input.readLine();
            try {
                int acc_num = Integer.parseInt(str_input);
                for (accDetail acc : accounts) {
                    if (acc.acc_num == acc_num) {
                        acc_temp = acc;
                    }
                }
            } catch (NumberFormatException e) {
                for (accDetail acc : accounts) {
                    if (acc.cust_name.equals(str_input)) {
                        acc_temp = acc;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        return acc_temp;
    }

}

public class Inheritance_2 {
    public static void main(String[] args) {
        AccountList aList = new AccountList();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        try {
            while (loop) {
                System.out.println("\nMenu");
                System.out.println("1. Create account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Account info");

                System.out.print("Enter Choice : ");
                int ch = Integer.parseInt(input.readLine());
                switch (ch) {
                case 1: {
                    accDetail temp_acc = aList.create_account();
                    if (temp_acc != null) {
                        aList.accounts.add(temp_acc);
                    }
                    break;
                }
                case 2: {
                    accDetail temp_acc = aList.search_account();
                    System.out.print("\nHow much do you want to deposit? : ");
                    int money = Integer.parseInt(input.readLine());
                    temp_acc.setData(money, "deposit");
                    break;
                }
                case 3: {
                    accDetail temp_acc = aList.search_account();
                    System.out.print("\nHow much do you want to withdraw? : ");
                    int money = Integer.parseInt(input.readLine());
                    temp_acc.setData(money, "withdraw");
                    break;
                }
                case 4: {
                    accDetail temp_acc = aList.search_account();
                    temp_acc.getData();
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
