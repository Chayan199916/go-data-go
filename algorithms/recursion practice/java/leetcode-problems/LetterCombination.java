import java.util.ArrayList;

class LetterCombination {
    public static void main(String[] args) {
        // getResult("23", "");
        System.out.println(getResult("2", ""));
    }

    static String numbers = "23456789";
    static String[] letters = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    // static void getResult(String input, String output) {
    // if (input.isEmpty()) {
    // System.out.println(output);
    // return;
    // }
    // String ch = input.charAt(0) + "";
    // String letterCombination = letters[numbers.indexOf(ch)];
    // for (int i = 0; i < letterCombination.length(); i++) {
    // getResult(input.substring(1), output + letterCombination.charAt(i));
    // }
    // }
    static ArrayList<String> getResult(String input, String output) {
        if (input.isEmpty()) {
            ArrayList<String> indiv = new ArrayList<String>();
            indiv.add(output);
            return indiv;
        }
        ArrayList<String> result = new ArrayList<String>();
        String ch = input.charAt(0) + "";
        String letterCombination = letters[numbers.indexOf(ch)];
        for (int i = 0; i < letterCombination.length(); i++) {
            result.addAll(getResult(input.substring(1), output + letterCombination.charAt(i)));
        }
        return result;
    }
}