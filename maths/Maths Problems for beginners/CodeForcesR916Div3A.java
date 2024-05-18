import java.util.Scanner;

public class CodeForcesR916Div3A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int _TEST = scanner.nextInt();
        while (_TEST-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();

            int ans = 0, x = 1;

            for (char ch = 'A'; ch <= 'Z'; ch++) {
                ans += (countOccurrences(s, ch) >= x ? 1 : 0);
                x++;
            }

            System.out.println(ans);
        }
    }

    private static int countOccurrences(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
