/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class SpecialFibonacci {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int[] buffer = new int[n + 1];
            Arrays.fill(buffer, -1);
            buffer[0] = a;
            buffer[1] = b;
            System.out.println(specialFib(a, b, n, buffer));
        }
        scanner.close();
    }

    static int specialFib(int a, int b, int n, int[] buffer) {
        if (n == 0)
            return buffer[n];
        else if (n == 1)
            return buffer[n];
        if (buffer[n] != -1)
            return buffer[n];
        return buffer[n] = specialFib(a, b, n - 1, buffer) ^ specialFib(a, b, n - 2, buffer);
    }
}
