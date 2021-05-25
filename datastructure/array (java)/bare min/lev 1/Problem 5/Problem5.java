
/**
 * Randomized Quick Sort Method
 */

import java.util.concurrent.ThreadLocalRandom;

class Problem5 {
    public static void main(String[] args) {
        int arr[] = { 5, 8, 7, 12, 14, 3, 9, 1, 0, 2 };
        randomizedQuickSort(arr, 0, arr.length - 1);
        displayIntArray(arr);
    }

    static void randomizedQuickSort(int inputArr[], int start, int end) {
        if (start < end) {
            int partitionIndex = randomizedPartition(inputArr, start, end);
            randomizedQuickSort(inputArr, start, partitionIndex - 1);
            randomizedQuickSort(inputArr, partitionIndex + 1, end);
        }
    }

    static void displayIntArray(int inputArr[]) {
        for (int i = 0; i < inputArr.length; i++) {
            System.out.print(inputArr[i] + " ");
        }
    }

    static int randomizedPartition(int inputArr[], int start, int end) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomPivot = ThreadLocalRandom.current().nextInt(start, end + 1);
        swapTwoNumbers(inputArr, start, randomPivot);
        int pivot = inputArr[start];
        int pivotIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (inputArr[i] <= pivot) {
                pivotIndex++;
                swapTwoNumbers(inputArr, i, pivotIndex);
            }
        }
        swapTwoNumbers(inputArr, start, pivotIndex);
        return pivotIndex;
    }

    static void swapTwoNumbers(int inputArr[], int first, int second) {
        int temp = inputArr[first];
        inputArr[first] = inputArr[second];
        inputArr[second] = temp;
    }
}

/**
 * time complexity : best case : O(nlogn) worst case : O(n^2) avg case :
 * O(nlogn) space complexity : (recursion stack space) best case : O(logn) worst
 * case : O(n)
 */