import java.util.Scanner;

public class WeirdAlgorithm {
    public static String getSequence(long num) {
        String res = "";
        while (num != 1) {
            res += num + " ";
            if (num % 2 != 0) {
                num = num * 3 + 1;
            } else {
                num = num / 2;
            }
        }
        res += num;
        return res;
    }

    public static String getSequenceRecursive(long num, String res) {
        if (num == 1) {
            res += "1";
            return res;
        } else {
            if (num % 2 != 0)
                return getSequenceRecursive(num * 3 + 1, res + num + " ");
            return getSequenceRecursive(num / 2, res + num + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getSequenceRecursive(scanner.nextLong(), ""));
        scanner.close();
    }
}