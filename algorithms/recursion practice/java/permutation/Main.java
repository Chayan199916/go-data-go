import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println(countPermutation("", "abcd"));
    }

    // static void findPermutation(String output, String input) {
    // if (input.isEmpty()) {
    // System.out.println(output);
    // return;
    // }
    // char ch = input.charAt(0);
    // for (int i = 0; i <= output.length(); i++) {
    // String first = output.substring(0, i);
    // String second = output.substring(i, output.length());
    // findPermutation(first + ch + second, input.substring(1));
    // }
    // }
    // static ArrayList<String> findPermutation(String output, String input) {
    // if (input.isEmpty()) {
    // ArrayList<String> indivPermutation = new ArrayList<String>();
    // indivPermutation.add(output);
    // return indivPermutation;
    // }
    // ArrayList<String> permutations = new ArrayList<String>();
    // char ch = input.charAt(0);
    // for (int i = 0; i <= output.length(); i++) {
    // String first = output.substring(0, i);
    // String second = output.substring(i, output.length());
    // permutations.addAll(findPermutation(first + ch + second,
    // input.substring(1)));
    // }
    // return permutations;
    // }
    static int countPermutation(String output, String input) {
        if (input.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = input.charAt(0);
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String second = output.substring(i, output.length());
            count += countPermutation(first + ch + second, input.substring(1));
        }
        return count;
    }
}