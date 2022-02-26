class FirstUppercaseLetter {
    public static void main(String[] args) {
        System.out.println(getLetter("geeksforZgeeKs"));
        System.out.println(getLetter("Z"));
        System.out.println(getLetter(""));
        System.out.println(getLetter("geeksforgeeks"));
    }

    static String getLetter(String input) {
        if (input.isEmpty())
            return "";
        if (input.charAt(0) >= 65 && input.charAt(0) <= 90)
            return input.charAt(0) + "";
        return getLetter(input.substring(1));
    }
}
