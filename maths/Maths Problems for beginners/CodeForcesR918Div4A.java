import java.util.Scanner;

public class CodeForcesR918Div4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int _TEST = scanner.nextInt();
        while (_TEST-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int res = a ^ b ^ c;
            System.out.println(res);
        }
    }
}