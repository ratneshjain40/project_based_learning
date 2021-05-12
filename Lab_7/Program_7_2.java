package Lab_7;

class MyExcep extends Exception {
    String str;
    int n;
    public MyExcep(String str, int n) {
        this.str = str;
        this.n = n;
    }
    public String toString() {
        return n+" "+str;
    }
}
public class Program_7_2 {
    public static void main(String[] args) {
        try {
            for(int i=0;i<args.length;i++){
                factorial(Integer.parseInt(args[i]));
            }
        }
        catch (MyExcep e) {
            System.out.println("Exception Occurred: " +e);
        }
        catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("No input provided as CML argument!");
        }
        catch(NumberFormatException nf) {
            System.out.println("\nException occurred: Please Enter only Integer Values");
        }
    }
    static void factorial(int num) throws MyExcep{
        if(num<0 || num>12) {
            throw new MyExcep("is not in Range",num);
        }
        int fact=1;
        for(int i=1;i<num;i++) {
            fact=fact*i;
        }
        System.out.println("Factorial of " +num+ ": " +fact);
    }
}