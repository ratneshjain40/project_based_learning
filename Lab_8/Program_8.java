package Lab_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Sql {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    static final String url = "jdbc:sqlite:D:/Projects/Year 2/SEM 4/PBL/Lab_Files/src/Lab_8/db/test.db";;

    public void createTable() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql_run = "CREATE TABLE Employee " + "(empno INTEGER not NULL, " + " ename VARCHAR(20), "
                    + " department VARCHAR(20), " + " job VARCHAR(20), " + " salary FLOAT not NULL)";
            stmt.executeUpdate(sql_run);
            System.out.println("Created table in given database");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void dropTable() throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            String sql_run = "DROP TABLE Employee";
            stmt.executeUpdate(sql_run);
            System.out.println("Dropped table in given database");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Connection conn() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addData() throws SQLException, IOException, NumberFormatException {
        System.out.print("Enter name:");
        String name = input.readLine();
        System.out.print("Enter ID:");
        int id = Integer.parseInt(input.readLine());
        System.out.print("Enter Department:");
        String dept = input.readLine();
        System.out.print("Enter Job:");
        String job = input.readLine();
        System.out.print("Enter Salary:");
        Float sal = Float.parseFloat(input.readLine());
        String sql = "INSERT INTO employee VALUES('" + id + "','" + name + "','" + dept + "','" + job + "','" + sal
                + "')";
        Statement stmt = conn().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Data inserted!!!");
    }

    public void display() throws SQLException {
        String sql = "SELECT * FROM employee";
        Statement stmt = conn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("ID\tName\tDepartment\tJob\t\tSalary");
        while (rs.next()) {
            int id = rs.getInt(1);
            String n = rs.getString(2);
            String dept = rs.getString(3);
            String job = rs.getString(4);
            Float s = rs.getFloat(5);
            System.out.println(id + "\t" + n + "\t" + dept + "\t\t" + job + "\t\t" + s);
        }
    }

    public void searchName() throws SQLException, IOException {
        System.out.println("Enter the name:");
        String n = input.readLine();
        String sql = "SELECT * FROM employee WHERE ename='" + n + "'";
        Statement stmt = conn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("ID\tName\tDepartment\tJob\t\tSalary");
        while (rs.next()) {
            int id = rs.getInt(1);
            String nam = rs.getString(2);
            String dept = rs.getString(3);
            String job = rs.getString(4);
            Float s = rs.getFloat(5);
            System.out.println(id + "\t" + nam + "\t" + dept + "\t\t" + job + "\t\t" + s);
        }
    }

    public void updateSalary() throws SQLException, IOException, NumberFormatException {
        System.out.println("Enter the Employee ID:");
        int i = Integer.parseInt(input.readLine());
        System.out.println("Enter the salary: ");
        Float sal = Float.parseFloat(input.readLine());
        String sql = "UPDATE employee SET salary=" + sal + " WHERE empno=" + i + "";
        Statement stmt = conn().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Salary Updated!!!");
    }

    public void deleteData() throws SQLException, IOException {
        System.out.println("Enter the Employee ID:");
        int i = Integer.parseInt(input.readLine());
        String sql = "DELETE FROM employee WHERE empno=" + i + "";
        Statement stmt = conn().createStatement();
        stmt.executeUpdate(sql);
        System.out.println("Data removed from table.");
    }
}

public class Program_8 {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, IOException, NumberFormatException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        Sql s = new Sql();
        // s.createTable();
        while (true) {
            System.out.println("------Menu-----");
            System.out.println("1. Create Table");
            System.out.println("2. Drop Table");
            System.out.println("3. Add");
            System.out.println("4. Display");
            System.out.println("5. Search by name");
            System.out.println("6. Update salary");
            System.out.println("7. Delete");
            System.out.println("8. Exit");

            int choice = Integer.parseInt(input.readLine());
            switch (choice) {
                case 1: {
                    s.createTable();
                    break;
                }
                case 2: {
                    s.dropTable();
                    break;
                }
                case 3: {
                    s.addData();
                    break;
                }
                case 4: {
                    s.display();
                    break;
                }
                case 5: {
                    s.searchName();
                    break;
                }
                case 6: {
                    s.updateSalary();
                    break;
                }
                case 7: {
                    s.deleteData();
                    break;
                }
                case 8: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Enter a valid number!!");
                }
            }
        }
    }
}
