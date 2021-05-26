/**
 * Given an array A[] consisting 0s, 1s and 2s. The task is to write a function
 * that sorts the given array. The functions should put all 0s first, then all
 * 1s and all 2s in last. Examples:
 * 
 * 
 * Input: {0, 1, 2, 0, 1, 2} Output: {0, 0, 1, 1, 2, 2}
 * 
 * Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1} Output: {0, 0, 0, 0, 0, 1, 1, 1,
 * 1, 1, 2, 2}
 */

class Problem9 {
    public static void main(String[] args) {
        segregateZeroesOnesAndTwoes(new int[] { 1, 2, 2, 1, 0, 1, 0, 0 });
    }

    static void sortArrayOfZeroesOnesAndTwoesSimpleCounting(int inputArr[]) {
        int zeroesCounter = 0;
        int onesCounter = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == 0) {
                zeroesCounter++;
            } else if (inputArr[i] == 1) {
                onesCounter++;
            }
        }
        int i = 0;
        while (i < zeroesCounter) {
            inputArr[i++] = 0;
        }
        while (i < zeroesCounter + onesCounter) {
            inputArr[i++] = 1;
        }
        while (i < inputArr.length) {
            inputArr[i++] = 2;
        }
        displayIntArray(inputArr);
    }

    static void segregateZeroesOnesAndTwoes(int inputArr[]) {
        int low = 0;
        int mid = 0;
        int high = inputArr.length - 1;

        for (; mid <= high;) {
            if (inputArr[mid] == 0) {
                swapTwoNumbers(inputArr, low, mid);
                low++;
                mid++;
            } else if (inputArr[mid] == 1) {
                mid++;
            } else if (inputArr[mid] == 2) {
                swapTwoNumbers(inputArr, mid, high);
                high--;
            }
        }
        displayIntArray(inputArr);
    }

    static void swapTwoNumbers(int inputArr[], int first, int second) {
        inputArr[first] = inputArr[first] ^ inputArr[second];
        inputArr[second] = inputArr[first] ^ inputArr[second];
        inputArr[first] = inputArr[first] ^ inputArr[second];
    }

    static void displayIntArray(int inputArr[]) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.println(inputArr[i]);
        }
    }
}