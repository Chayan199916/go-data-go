import java.util.ArrayList;
import java.util.Scanner;

public class CodeForcesR916Div3B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int _TEST = scanner.nextInt();
        while (_TEST-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 1; i <= k; i++) {
                ans.add(i);
            }

            for (int i = n; i > k; i--) {
                ans.add(i);
            }

            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
