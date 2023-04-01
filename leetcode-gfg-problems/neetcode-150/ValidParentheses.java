import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMapper = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (parenthesesMapper.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.size() != 0 && parenthesesMapper.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
