import java.util.ArrayList;
import java.util.List;

public class GenerateValidParentheses {
    private static int MAX_OPEN, MAX_CLOSE;

    public static List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<String>() {
                {
                    add("");
                }
            };
        }
        MAX_OPEN = n;
        MAX_CLOSE = n;
        return generateParenthesesUtil("(", 1, 0);
    }

    public static List<String> generateParenthesesUtil(String output, int open, int close) {
        if (open == MAX_OPEN && close == MAX_CLOSE) {
            List<String> indivRes = new ArrayList<String>();
            indivRes.add(output);
            return indivRes;
        }
        List<String> results = new ArrayList<String>();
        if (open < MAX_OPEN) {
            results.addAll(generateParenthesesUtil(output + "(", open + 1, close));
        }
        if (close < MAX_CLOSE && close < open) {
            results.addAll(generateParenthesesUtil(output + ")", open, close + 1));
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }
}
