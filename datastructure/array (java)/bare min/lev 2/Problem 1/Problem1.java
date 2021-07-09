/**
 * Given an array, cyclically rotate the array clockwise by one.
 * 
 * Examples:
 * 
 * Input: arr[] = {1, 2, 3, 4, 5} Output: arr[] = {5, 1, 2, 3, 4}
 */

class Problem1 {
    public static void main(String[] args) {
        rotateClockwiseByOnePos(new int[] { 1, 2, 3, 4, 5 }); // right shift by 1 place
        reverseAlgorithm(new int[] { 1, 2, 3, 4, 5 }, 2); // left shift by 2 places
    }

    static void rotateClockwiseByOnePos(int inputArr[]) {
        int temp = inputArr[inputArr.length - 1];
        for (int i = inputArr.length - 2; i >= 0; i--) {
            inputArr[i + 1] = inputArr[i];
        }
        inputArr[0] = temp;
        displayIntArray(inputArr);
    }

    static void displayIntArray(int inputArr[]) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }
        System.out.println();
    }

    static void reverseArray(int[] inputArr, int start, int end) {
        while (start < end) {
            swapTwoNumbers(inputArr, start, end);
            start++;
            end--;
        }
    }

    static void reverseAlgorithm(int[] inputArr, int byPos) {
        if (byPos <= 0) {
            return;
        }
        byPos = byPos % inputArr.length;
        reverseArray(inputArr, 0, byPos - 1);
        reverseArray(inputArr, byPos, inputArr.length - 1);
        reverseArray(inputArr, 0, inputArr.length - 1);
        displayIntArray(inputArr);
    }

    static void swapTwoNumbers(int inputArr[], int first, int second) {
        int temp = inputArr[first];
        inputArr[first] = inputArr[second];
        inputArr[second] = temp;
    }
}
/**
 * Time complexity = O(n) Space complexity = O(1)
 */