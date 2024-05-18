public class PrintPermutations {
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    static void printPermutations(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }
        for (int i = 0; i < ip.length(); i++) {
            char ch = ip.charAt(i);
            String remainingString = ip.substring(0, i) + ip.substring(i + 1);
            printPermutations(remainingString, op + ch);
        }
    }
}
