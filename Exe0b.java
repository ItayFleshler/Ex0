import java.util.Scanner;

public class Exe0b {
    public static Scanner input = new Scanner(System.in);

    public static boolean isPrime(int a)
    {
        if (a < 2)
            return false;
        if (a == 2 || a == 3)
            return true;
        if (a % 2 == 0 || a % 3 == 0)
            return false;
        for (int i = 5; i * i <= a; i += 6)
        {
            if (a % i == 0 || a % (i + 2) == 0)
                return false;
        }
        return true;
    }


    public static void main(String[] args)
    {
        int n, p3, p4;
        boolean found = false;
        System.out.println("Please enter a natural number that is bigger than 4");
        n = input.nextInt();

        for (int k = n + 1; true; k++)
        {
            p3 = k;
            for (int j = 3; j < n; j += 2)
            {
                p4 = j;
                if (isPrime(p3) && isPrime(p4) && p3 - p4 == n)
                {
                    System.out.println(p3 + " - " + p4 + " = " + n);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
    }
}
