import java.util.Scanner;

/**
 * ProductOfThreeNums
 */
public class ProductOfThreeNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            getSolution(scanner.nextLong());
        }
        scanner.close();
    }

    static void getSolution(long num) {
        long a = num, b = num, c = num;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                a = i;
                break;
            }
        }
        num = num / a;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (i != a) {
                    b = Math.min(i, b);
                }
                if ((num / i) != i) {
                    b = Math.min(b, (num / i));
                }
            }
        }
        c = num / b;
        if (a != b && b != c && c != a && c > 1) {
            System.out.println("YES");
            System.out.println(a + " " + b + " " + c);
        } else {
            System.out.println("NO");
        }
    }
}