import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
class MinStack {
    public static Stack<List<Integer>> stack = null;

    public MinStack() {
        stack = new Stack<List<Integer>>();
    }

    public void push(int val) {
        List<Integer> entry = new ArrayList<Integer>();
        entry.add(val);
        if (stack.isEmpty()) {
            entry.add(val);
        } else {
            List<Integer> lastEntry = stack.peek();
            entry.add(Math.min(val, lastEntry.get(lastEntry.size() - 1)));
        }
        stack.push(entry);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().get(0);
    }

    public int getMin() {
        return stack.peek().get(1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */