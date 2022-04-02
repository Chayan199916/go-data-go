class BalancedParenthesis {
    public static void main(String args[]) {
        System.out.println(totalChecking("[()]{}{[()()]()}", ""));
        System.out.println(totalChecking("[(])", ""));
        System.out.println(totalChecking("((()))", ""));
        System.out.println(totalChecking(")(", ""));
        System.out.println(totalChecking("()(", ""));
    }

    static boolean totalChecking(String input, String stack) {
        if (input.isEmpty()) {
            if (stack.isEmpty())
                return true;
            return false;
        }
        char ch = input.charAt(0);
        if (ch == '(' || ch == '{' || ch == '[')
            return totalChecking(input.substring(1), stack + ch);
        if (!stack.isEmpty() && pairChecking(stack.charAt(stack.length() - 1), ch))
            return totalChecking(input.substring(1), stack.substring(0, stack.length() - 1));
        else
            return false;
    }

    static boolean pairChecking(char stackInput, char userInput) {
        if (stackInput == '(' && userInput == ')')
            return true;
        if (stackInput == '{' && userInput == '}')
            return true;
        if (stackInput == '[' && userInput == ']')
            return true;
        return false;
    }
}