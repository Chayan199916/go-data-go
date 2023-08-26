/**
 * A celebrity is a person who is known to all but does not know anyone at a
 * party. If you go to a party of N people, find if there is a celebrity in the
 * party or not.
 * A square NxN matrix M[][] is used to represent people at the party such that
 * if an element of row i and column j is set to 1 it means ith person knows jth
 * person. Here M[i][i] will always be 0.
 * Note: Follow 0 based indexing.
 * Follow Up: Can you optimize it to O(N)
 */
public class CelebrityProblem {
    public static void main(String[] args) {
        System.out
                .println(celebrity(new int[][] { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } }, 3));
    }

    // Function to find if there is a celebrity in the party or not.
    static int celebrity(int M[][], int n) {
        // code here
        int i = 0;
        int j = M.length - 1;
        int potentialCeleb = getPotentialCelebrity(M, i, j);
        for (int k = 0; k < M.length; k++) {
            if (k != potentialCeleb && (M[k][potentialCeleb] != 1 || M[potentialCeleb][k] != 0)) {
                return -1;
            }
        }
        return potentialCeleb;
    }

    static int getPotentialCelebrity(int M[][], int start, int end) {
        if (start == end) {
            return start;
        }
        if (start + 1 == end) {
            if (M[start][end] == 0) {
                return start;
            } else {
                return end;
            }
        } else {
            int mid = start + (end - start) / 2;
            int potentialCelebLeft = getPotentialCelebrity(M, start, mid);
            int potentialCelebRight = getPotentialCelebrity(M, mid + 1, end);
            if (M[potentialCelebLeft][potentialCelebRight] == 0) {
                return potentialCelebLeft;
            } else {
                return potentialCelebRight;
            }
        }
    }
}
