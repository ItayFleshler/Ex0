/**
 Student name: Itay Fleshler
 Student ID: 215878661

 Spec requirements (as per me):
 a) Find two primes (p1, p2) such that p1 + p2 == even natural number n > 4
 b) to get the minimum pair of prime p3, p4 where p4 - p3 = n
 c) Count and display how many prime numbers are in the interval [2, n).
 d) Find and show the prime factors of number n

 Pseudocode:

 a) A prime number sum;
 1. Input (n > 4) // Input after checking that n is an even natural number greater than 4
 2. For p1 = 2 to n/2 // [Note: The smallest prime number is 2.]
 3. p2 = n - p1 # makes p2 the complement of p1 to reach n
 4. if isPrime(p1) and isPrime(p2): # will verify whether p1 and p2 are prime?
 5. SystemOutPrintln (p1 + " + " + p2 + " = "+ n)
 6. Return // Find the first pair found only

 b) Subtract the second-smallest prime from the smallest:
 1. if (n > 4 && n % 2 == 0) // Inputting only after conditions about n being an even natural number greater than 4
 2. Let p3 = n + 1 // Initialize p3 with the next prime after n.
 3. Infinite loop on the first matching pair true
 4. for p4:=2 to p3 // Initial Loop iterate through potential prime numbers less than p3
 5. if isPrime(p3) and isPrime(p4) and (p3 - p4 == n) # then both of them are prime & difference = n
 6. But when I print it: (p3 + " - " + p4 + " = " + n)o
 7. Return // exit after found the first pair
 8. p3 = p3 + 1 // Advance to the next prime candidate after p3

 c) number of primes in [ 2, n )
 1. Input (n > 4) // After condition check of the n for even natural number greater than 4
 2. count = 0 // Prime counter
 3. For i = 2 to n − 1 // Loop through range [2, n)
 4. if (isPrime(i))  // if i was prime
 5. count = count + 1 // Count variable increment for prime
 6. Print ( (count + " primes in [2," + n + "))

 d) Prime factorization of n:
 1. Input (n > 4) // Inputting after checking if n is an even natural number greater than 4
 2. Set factors = "" // Initialize an empty string to store factors
 3. While n % 2 == 0 // Check the division remainder by 2
 4. Append “2 * “ to factors // Add 2 to the factors list
 5. n = n / 2 // Divide n by 2, to break down the number as much as possible
 6. For i = 3 to sqrt(n) step 2 // Check only odd numbers up to sqrt(n)
 7. While n % i == 0 // Check the division remainder by i
 8. Append i + “ * ” to factors // Add i to the factors list
 9. n = n / i // Divide n by i
 10. If n > 2 // If remaining n is a prime greater than 2
 11. Append n to factors // Add n to the factors list
 12. Print factors (without the last “ * ”) // Print the result without the trailing “” */

import java.util.Scanner;

public class Ex0 {
    public static Scanner input = new Scanner(System.in);

    /**
     * Checks if a number is prime.
     * @param a The number to check.
     * @return true if the number is prime, false otherwise.
     */

    public static boolean isPrime(int a) {
        if (a < 2)
            return false;
        if (a == 2 || a == 3)
            return true;
        if (a % 2 == 0 || a % 3 == 0)
            return false;
        for (int i = 5; i * i <= a; i += 6) {
            if (a % i == 0 || a % (i + 2) == 0)
                return false;
        }
        return true;
    }

    /**
     * Main method - Executes each section based on the Goldbach Conjecture task.
     * @param args command-line arguments (not used here).
     */

    public static void main(String[] args) {
        System.out.print("Please enter an even natural number greater than 4: ");
        int n = input.nextInt();

        // Check if input is an even number greater than 4, if not, print error message and exit.
        if (n % 2 != 0 || n <= 4) {
            System.out.println("Error: You should enter an even number greater than 4.");
            System.exit(0);
        }

        // Record the start time to measure the program's runtime later
        long startTime = System.nanoTime();

        System.out.println("a) " + sectionA(n));
        System.out.println("b) " + sectionB(n));
        System.out.println("c) " + sectionC(n));
        System.out.println("d) " + sectionD(n));
        System.out.println("e) " + sectionE(startTime));
        System.out.println("f) " + sectionF());

        input.close();
    }

    /**
     * Section A: Finds two prime numbers (p1, p2) such that p1 + p2 = n.
     * This section addresses part (a) of the task.
     * @param n The even natural number input.
     * @return A formatted string with the result in the form "n = p1 + p2".
     */

    public static String sectionA(int n) {
        int p1, p2;

        // Loop through odd numbers starting from 3 to find two primes that sum to n
        for (p1 = 3; p1 < n; p1 += 2) {
            if (isPrime(p1)) {
                p2 = n - p1;
                if (isPrime(p2)) {
                    return n + " = " + p1 + " + " + p2;
                }
            }
        }
        return "";
    }

    /**
     * Section B: Finds the smallest two prime numbers (p3, p4) such that p4 - p3 = n.
     * This section addresses part (b) of the task.
     * @param n The even natural number input.
     * @return A formatted string with the result in the form "n = p3 - p4".
     */

    public static String sectionB(int n) {
        int p3, p4;

        // Loop to find the smallest prime pair with difference n
        for (int k = n + 1; true; k++) {
            p3 = k;
            for (int j = 3; j < n; j += 2) {
                p4 = j;
                if (isPrime(p3) && isPrime(p4) && p3 - p4 == n) {
                    return n + " = " + p3 + " - " + p4;
                }
            }
        }
    }

    /**
     * Section C: Counts the number of prime numbers in the range [2, n).
     * This section addresses part (c) of the task.
     * @param n The upper bound of the range (exclusive).
     * @return A formatted string showing the count of primes in the range [2, n).
     */

    public static String sectionC(int n) {
        int count = 0;

        // Count prime numbers in the range [2, n)
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count + " prime numbers in [2, " + n + ")";
    }

    /**
     * Section D: Computes the prime factorization of n.
     * This section addresses part (d) of the task.
     * @param n The number to factorize.
     * @return A formatted string with the prime factorization of n in the form "n = q1 * q2 * ... * qk".
     */

    public static String sectionD(int n) {
        StringBuilder result = new StringBuilder(n + " = ");
        boolean firstNum = true;

        // Factor out 2 from n as much as possible
        while (n % 2 == 0) {
            if (!firstNum) {
                result.append(" * ");
            }
            result.append(2);
            n /= 2;
            firstNum = false;
        }

        // Factor out odd numbers up to sqrt(n)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                if (!firstNum) {
                    result.append(" * ");
                }
                result.append(i);
                n /= i;
                firstNum = false;
            }
        }

        // If n is a prime greater than 2, add it as the last factor
        if (n > 2) {
            if (!firstNum) {
                result.append(" * ");
            }
            result.append(n);
        }
        return result.toString();
    }

    /**
     * Section E: Computes the runtime of the program in seconds.
     * This section measures the duration of the program from start to end.
     * @param startTime The start time in nanoseconds.
     * @return A formatted string with the runtime in seconds.
     */

    public static String sectionE(long startTime) {
        long endTime = System.nanoTime();

        // Calculate runtime in seconds
        double RunTime = (endTime - startTime) / 1_000_000_000.0;
        return String.format("%.3f seconds, the program runtime (Mac m3)", RunTime);
    }

    /**
     * Section F: Displays the student's ID.
     * This section addresses part (f) of the task.
     * @return A formatted string with the student's ID.
     */

    public static String sectionF() {
        return "My ID: 215878661";
    }
}
