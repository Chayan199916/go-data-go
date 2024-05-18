import java.util.Scanner;

public class PrintEncodings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ip = scanner.nextLine();
        printEncodings(ip, "");
        scanner.close();
    }

    static void printEncodings(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        } else if (ip.length() == 1) {
            char ch = ip.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                System.out.println(op + code);
                return;
            }
        } else {
            // single digit
            char ch = ip.charAt(0);
            String restOfTheString = ip.substring(1);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncodings(restOfTheString, op + code);
            }
            // two digits
            String ch12 = ip.substring(0, 2);
            restOfTheString = ip.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char) ('a' + ch12v - 1);
                printEncodings(restOfTheString, op + code);
            }
        }
    }
}
