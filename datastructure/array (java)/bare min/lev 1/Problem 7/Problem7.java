
/**
 * K’th Smallest/Largest Element in Unsorted Array | Set 1 :
 * 
 * Given an array and a number k where k is smaller than the size of the array,
 * we need to find the k’th smallest element in the given array. It is given
 * that all array elements are distinct.
 * 
 * Examples:
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 3 Output: 7
 * 
 * Input: arr[] = {7, 10, 4, 3, 20, 15} k = 4 Output: 10
 */

import java.util.concurrent.ThreadLocalRandom;

class Problem7 {
    public static void main(String[] args) {
        int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        for (int i = 0; i < arr.length; i++)
            System.out.println(" nth (" + i + ") element is : " + kThSmallestElement(arr, 0, arr.length - 1, i));
    }

    static int randomizedPartition(int inputArr[], int start, int end) {
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

    static int kThSmallestElement(int inputArr[], int start, int end, int k) {
        if (start == end) {
            if (start == k) {
                return inputArr[start];
            }
        }
        int partitionIndex = randomizedPartition(inputArr, start, end);
        if (k == partitionIndex)
            return inputArr[k];
        else if (k < partitionIndex)
            return kThSmallestElement(inputArr, start, partitionIndex - 1, k);
        else
            return kThSmallestElement(inputArr, partitionIndex + 1, end, k);

    }

    // static int kThSmallestElement(int inputArr[], int start, int end, int k) {
    // for (;;) {
    // if (start == end)
    // return inputArr[start];

    // int partitionIndex = randomizedPartition(inputArr, start, end);

    // if (k == partitionIndex)
    // return inputArr[k];
    // else if (k < partitionIndex)
    // end = partitionIndex - 1;
    // else
    // start = partitionIndex + 1;
    // }
    // }
}