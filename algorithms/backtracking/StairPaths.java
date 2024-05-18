package backtracking;

public class StairPaths {
    public static void main(String[] args) {
        printPaths(5, "");
    }

    static void printPaths(int numOfSteps, String op) {
        if (numOfSteps == 0) {
            System.out.println(op);
            return;
        }
        if (numOfSteps >= 0) {
            printPaths(numOfSteps - 1, "1" + op);
        }
        if (numOfSteps >= 0) {
            printPaths(numOfSteps - 2, "2" + op);
        }
        if (numOfSteps >= 0) {
            printPaths(numOfSteps - 3, "3" + op);
        }
    }
}
