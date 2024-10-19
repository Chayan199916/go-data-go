# Implement a stack that has the following methods:

# push(val), which pushes an element onto the stack
# pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
# max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
# Each method should run in constant time.

# solve it in the most optimized way. provide time and space complexity
# code in python

class MaxStack:
    def __init__(self):
        self.main_stack = []  # Stack to store the actual values
        self.max_stack = []   # Stack to store the maximum values

    def push(self, val):
        """Push an element onto the stack."""
        self.main_stack.append(val)
        # If max_stack is empty, push the current value as the maximum
        if not self.max_stack:
            self.max_stack.append(val)
        else:
            # Push the maximum of the current value and the current max
            self.max_stack.append(max(val, self.max_stack[-1]))

    def pop(self):
        """Pop the top element off the stack and return it."""
        if not self.main_stack:
            return None  # Return None if the stack is empty
        self.max_stack.pop()  # Remove the top from max_stack
        return self.main_stack.pop()  # Remove and return the top from main_stack

    def max(self):
        """Return the maximum element in the stack."""
        if not self.max_stack:
            return None  # Return None if the stack is empty
        return self.max_stack[-1]  # The top of max_stack is the current maximum

# Example usage:
stack = MaxStack()
stack.push(3)
stack.push(5)
print(stack.max())  # Output: 5
stack.push(2)
stack.push(8)
print(stack.max())  # Output: 8
stack.pop()
print(stack.max())  # Output: 5
stack.pop()
print(stack.max())  # Output: 5
