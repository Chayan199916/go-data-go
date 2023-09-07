/**
 * You are given an array A consisting of n positive integers.
 * In one operation, you can choose any index i such that 1 <= i <=n and Ai is
 * even, then you can assign Ai = Ai / 2.
 * 
 * Your task is to make total sum of array even using minimum number of
 * operations (possibly 0) or return -1 if it is not possible.
 */
class EvenSumGFGWeekly_118 {
    static int findMin(int A[], int n) {
        int totalSum = 0;
        int minOperations = -1; // Initialize to a large value.

        for (int Ai : A) {
            totalSum += Ai;
        }

        // If the total sum is already even, return 0 operations.
        if (totalSum % 2 == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                int operations = 0;
                while (A[i] % 2 == 0) {
                    A[i] /= 2;
                    operations++;
                }
                if (minOperations == -1) {
                    minOperations = operations;
                } else {
                    minOperations = Math.min(minOperations, operations);
                }
            }
        }
        return minOperations;
    }
}