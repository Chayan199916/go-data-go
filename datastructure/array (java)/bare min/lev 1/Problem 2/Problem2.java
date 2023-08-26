//Given an array, write functions to find the minimum and maximum elements in it. 

class Problem2 {
    // time complexity : O(n)
    private static String findMinMax(int inputArray[]) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }
        }
        return minimum + "," + maximum;
    }

    /**
     * if n is even : 3T(n/2) - 2; if n is odd -> 3T(n/2) - 1
     */
    static int[] findMinMaxTournament(int A[], int start, int end) {
        int max;
        int min;
        if (start == end) {
            max = A[start];
            min = A[start];
        } else if (start + 1 == end) {
            if (A[start] < A[end]) {
                max = A[end];
                min = A[start];
            } else {
                max = A[start];
                min = A[end];
            }
        } else {
            int mid = start + (end - start) / 2;
            int left[] = findMinMaxTournament(A, start, mid);
            int right[] = findMinMaxTournament(A, mid + 1, end);
            if (left[0] > right[0])
                max = left[0];
            else
                max = right[0];
            if (left[1] < right[1])
                min = left[1];
            else
                min = right[1];
        }
        // By convention, we assume ans[0] as max and ans[1] as min
        int ans[] = { max, min };
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 0, 2, 9, 3, 8, 4, 7, 5, 6 };
        // String result = findMinMax(arr);
        // String minMax[] = result.split(",");
        // System.out.println(
        // "minimum value : " + Integer.parseInt(minMax[0]) + " maximum value : " +
        // Integer.parseInt(minMax[1]));
        int[] ans = findMinMaxTournament(arr, 0, arr.length - 1);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}