import java.util.Stack;

public class ReversePolishEvaluation {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (checkInteger(token)) {
                stack.push(token);
            } else {
                int lastOperand = Integer.parseInt(stack.pop());
                int secondLastOperand = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    stack.push((secondLastOperand + lastOperand) + "");
                } else if (token.equals("-")) {
                    stack.push((secondLastOperand - lastOperand) + "");
                } else if (token.equals("*")) {
                    stack.push((secondLastOperand * lastOperand) + "");
                } else {
                    stack.push((secondLastOperand / lastOperand) + "");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public boolean checkInteger(String token) {
        try {
            int number = Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            // TODO: handle exception
            return false;
        }
    }
}
