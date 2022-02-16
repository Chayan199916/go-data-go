class Main {
    public static void main(String[] args) {
        System.out.println(removeAllPatterns("helloapplehelloapplehelloappleappleapplehello", "", "apple"));
        System.out.println(removeAllPatterns("", "", "apple"));
    }

    static String removeAllAs(String input, int index, String output) {
        if (index == input.length())
            return output;
        if (input.charAt(index) != 'a')
            return removeAllAs(input, index + 1, output + input.charAt(index));
        return removeAllAs(input, index + 1, output);
    }

    static String removeAllAs(String input, String output) {
        if (input.isEmpty())
            return output;
        if (input.charAt(0) != 'a')
            return removeAllAs(input.substring(1), output + input.charAt(0));
        return removeAllAs(input.substring(1), output);
    }

    static String removeAllPatterns(String input, String output, String pattern) {
        if (input.isEmpty())
            return output;
        if (input.startsWith(pattern))
            return removeAllPatterns(input.substring(pattern.length()), output, pattern);
        return removeAllPatterns(input.substring(1), output + input.charAt(0), pattern);
    }
}
/**
 * helloapplehello = 15 (0 - 14)
 * applehello
 */