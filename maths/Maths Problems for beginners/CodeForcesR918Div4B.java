
import java.util.Scanner;

public class CodeForcesR918Div4B {

    public static void main(String[] args) {
        char[][] a = new char[3][3];

        Scanner scanner = new Scanner(System.in);

        int _TEST = scanner.nextInt();
        scanner.nextLine();
        while (_TEST-- > 0) {
            int[] freq = new int[3];
            for (int i = 0; i < 3; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < 3; j++) {
                    a[i][j] = line.charAt(j);
                    if (a[i][j] >= 'A' && a[i][j] <= 'C') {
                        freq[a[i][j] - 'A']++;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                if (freq[i] == 2) {
                    System.out.println((char) ('A' + i));
                }
            }
        }
    }
}
