import java.util.*;

/**
 * to count the number of integers in the interval [1, r] that are relatively
 * prime to n (their GCD is 1)
 */
public class RelativelyPrimeCount {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int countRelativelyPrime(int n, int r) {
        int phiN = n; // Initialize with n for prime numbers

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                phiN -= phiN / i;
            }
        }

        if (n > 1) {
            phiN -= phiN / n;
        }

        int result = phiN * (r / n);
        for (int i = 1; i <= r % n; i++) {
            if (gcd(i, n) == 1) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 12;
        int r = 30;
        int result = countRelativelyPrime(n, r);
        System.out.println("Number of integers in [1, " + r + "] relatively prime to " + n + ": " + result);
    }
}
