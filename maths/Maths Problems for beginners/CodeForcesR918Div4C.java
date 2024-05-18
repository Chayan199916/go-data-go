import java.util.Scanner;

public class CodeForcesR918Div4C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = scanner.nextInt();
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += (long) scanner.nextInt();
            }

            long sq = (long) Math.sqrt(sum);

            if (sq * sq == sum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}