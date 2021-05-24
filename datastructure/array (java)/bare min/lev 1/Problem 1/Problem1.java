/**
 * Check if a key is present in every segment of size k in an array Difficulty
 * Level : Easy Last Updated : 15 Mar, 2021 Given an array arr[] and size of
 * array is n and one another key x, and give you a segment size k. The task is
 * to find that the key x present in every segment of size k in arr[]. Examples:
 * 
 * Input : arr[] = { 3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3} x = 3 k = 3 Output :
 * Yes There are 4 non-overlapping segments of size k in the array, {3, 5, 2},
 * {4, 9, 3}, {1, 7, 3} and {11, 12, 3}. 3 is present all segments. Input :
 * arr[] = { 21, 23, 56, 65, 34, 54, 76, 32, 23, 45, 21, 23, 25} x = 23 k = 5
 * Output :Yes There are three segments and last segment is not full {21, 23,
 * 56, 65, 34}, {54, 76, 32, 23, 45} and {21, 23, 25}. 23 is present all window.
 * Input :arr[] = { 5, 8, 7, 12, 14, 3, 9} x = 8 k = 2 Output : No
 */

class Problem1 {
    public static void main(String[] args) {
        int arr[] = { 5, 8, 7, 12, 14, 3, 9 };
        int x = 8;
        int k = 2;
        if (checkPresence(arr, x, k)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean checkPresence(int inputArr[], int item, int segmentSize) {
        boolean checkFlag = true;
        int noOfFullSizedSegments = inputArr.length / segmentSize;
        int remainingElements = inputArr.length % segmentSize;
        int i;
        for (i = 0; i < noOfFullSizedSegments && checkFlag; i++) {
            checkFlag = false;
            for (int j = 0; j < segmentSize; j++) {
                if (inputArr[i * segmentSize + j] == item) {
                    checkFlag = true;
                    break;
                }
            }
        }
        if (!checkFlag) {
            return false;
        } else {
            checkFlag = false;
            for (int j = 0; j < remainingElements; j++) {
                if (inputArr[i * segmentSize + j] == item) {
                    checkFlag = true;
                    break;
                }
            }
            if (!checkFlag && remainingElements != 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}

// Time complexity : O(n)