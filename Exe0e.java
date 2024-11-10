import java.util.Scanner;

public class Exe0e {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        boolean firstNum = true;
        System.out.println("Please enter a natural number that is bigger than 4");
        n = input.nextInt();
        System.out.print(n + " = ");

        while (n % 2 == 0)
        {
            if (!firstNum)
            {
                System.out.print(" * ");
            }
            System.out.print(2);
            n /= 2;
            firstNum = false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            while (n % i == 0)
            {
                if (!firstNum)
                {
                    System.out.print(" * ");
                }
                System.out.print(i);
                n /= i;
                firstNum = false;
            }
        }

        if (n > 2)
        {
            if (!firstNum)
            {
                System.out.print(" * ");
            }
            System.out.print(n);
        }
    }
}
