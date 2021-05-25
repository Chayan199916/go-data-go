
/**
 * k largest(or smallest) elements in an array
 */

import java.util.concurrent.ThreadLocalRandom;

class Problem6 {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 5, 7, 2, 6, 0, 1 };
        int k = 3;
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
    }

    static void findKLargestSmallestElements(int inputArr[], int start, int end, int k) {
        if (start < end) {
            int partitionIndex = randomizedPartition(inputArr, start, end);
            if (k == partitionIndex) {
                System.out.println("smallest " + k + " elements : ");
                for (int i = 0; i < k; i++) {
                    System.out.print(inputArr[i] + " ");
                }
                System.out.println();
                System.out.println("largest " + k + " elements : ");
                for (int i = inputArr.length - k; i < inputArr.length; i++) {
                    System.out.print(inputArr[i] + " ");
                }
            } else if (k < partitionIndex) {
                findKLargestSmallestElements(inputArr, start, partitionIndex - 1, k);
            } else {
                findKLargestSmallestElements(inputArr, partitionIndex + 1, end, k);
            }
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
