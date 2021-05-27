/**
 * Move all negative numbers to beginning and positive to end with constant
 * extra space Difficulty Level : Easy ; An array contains both positive and
 * negative numbers in random order. Rearrange the array elements so that all
 * negative numbers appear before all positive numbers. Examples :
 * 
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6 Output: -12 -13 -5 -7 -3 -6 11 6 5
 * Note: Order of elements is not important here.
 */

class Problem11 {
    public static void main(String[] args) {
        rearrangeNegatives(new int[] { -12, 11, -13, -5, 6, -7, 5, -3, -6 });
    }

    static void rearrangeNegatives(int inputArr[]) {
        int low = 0;
        int high = inputArr.length - 1;
        while (low <= high) {
            if (inputArr[low] < 0) {
                low++;
            } else if (inputArr[low] > 0) {
                swapTwo(inputArr, low, high);
                high--;
            }
        }
        displayIntArray(inputArr);
    }

    static void displayIntArray(int inputArr[]) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }

    static void swapTwo(int inputArr[], int first, int second) {
        int temp = inputArr[first];
        inputArr[first] = inputArr[second];
        inputArr[second] = temp;
    }
}
