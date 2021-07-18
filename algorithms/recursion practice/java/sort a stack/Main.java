// Stack implementation in Java

class Stack {

    // store elements of stack
    private int arr[];
    // represent top of stack
    private int top;
    // total capacity of the stack
    private int capacity;

    // Creating a stack
    Stack(int size) {
        // initialize the array
        // initialize the stack variables
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // push elements to the top of stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack OverFlow");

            // terminates the program
            System.exit(1);
        }

        // insert element on top of stack
        arr[++top] = x;
    }

    // pop elements from top of stack
    public int pop() {

        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("Stack Empty");
            // terminates the program
            System.exit(1);
        }

        // pop element from top of stack
        return arr[top--];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == capacity - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // gives the top element of stack
    public int peek() {
        // if stack is empty
        // no element to pop
        if (isEmpty()) {
            System.out.println("Stack Empty");
            // terminates the program
            System.exit(1);
        }

        // element from top of stack
        return arr[top];
    }

    // sort the stack
    public void sortStack() {
        if (getSize() == 1) {
            return;
        } else {
            int lastElement = pop();
            sortStack();
            insertIntoSortedStack(lastElement);
        }
    }

    // inserting a new element into the sorted Stack
    public void insertIntoSortedStack(int element) {
        if (getSize() == 0 || peek() <= element) {
            push(element);
            return;
        } else {
            int lastElement = pop();
            insertIntoSortedStack(element);
            push(lastElement);
            return;
        }
    }

    // Driver method
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(5);
        stack.push(6);
        stack.push(9);
        stack.push(2);
        stack.push(7);

        // System.out.print("Stack: ");
        // stack.printStack();

        // remove element from stack
        // stack.pop();
        // System.out.println("\nAfter popping out");
        System.out.println("Before sorting");
        stack.printStack();
        stack.sortStack();
        System.out.println("After sorting");
        stack.printStack();

    }
}