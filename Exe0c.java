import java.util.Scanner;

public class Exe0c {
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
        int n, count = 0;
        System.out.println("Please enter a natural number that is bigger than 4");
        n = input.nextInt();

        for (int i = 2; i <= n; i++)
        {
            if (isPrime(i)) {
                count++;
            }
        }

        System.out.println(count + " Prime numbers in [2," + n + ")");
    }
}

