// GCD code, Itay fleshler
import java.util.Scanner;
public class Main {
    public static Scanner input = new Scanner (System.in);
    public static void main(String[] args) {
        long x, y, m, a = 0;
        System.out.print("please input the first number: ");
        x = input.nextLong();
        System.out.print("please input the second number: ");
        y = input.nextLong();
        m = Math.min(x,y);
        for(long i = 2; i <= m; i++)
        {
            if (x % i == 0 && y % i == 0)
                a = i;
        }
       System.out.println("GCD: " + a);
    }
}