import java.util.Arrays;

public class MedianOfMedians {
    public static int findMedianOfMedians(int[] arr) {
        int n = arr.length;

        // If the array is small enough, we can simply sort it and find the median.
        if (n <= 5) {
            Arrays.sort(arr);
            return arr[n / 2];
        }

        // Divide the array into groups of 5 elements each and find the median of each
        // group.
        int numGroups = (int) Math.ceil((double) n / 5);
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int groupSize = Math.min(5, n - i * 5);
            int[] group = new int[groupSize];

            for (int j = 0; j < groupSize; j++) {
                group[j] = arr[i * 5 + j];
            }

            Arrays.sort(group);
            medians[i] = group[groupSize / 2];
        }

        // Recursively find the median of medians.
        return findMedianOfMedians(medians);
    }

    public static void main(String[] args) {
        int[] arr = { 12, 3, 7, 5, 19, 26, 32, 16, 24, 67, 88, 45 };
        int median = findMedianOfMedians(arr);
        System.out.println("Median of the array is: " + median);
    }
}
/**
 * The time complexity of the "median of medians" algorithm for finding the
 * median of an array is O(n).
 * 
 * Here's a breakdown of the time complexity:
 * 
 * Divide into Groups: The initial step involves dividing the array into groups
 * of 5 elements each. This operation takes O(n/5) time, which simplifies to
 * O(n) because constant factors are typically dropped in big O notation.
 * 
 * Finding Medians of Groups: For each group, we find the median, which involves
 * sorting a small subgroup of 5 elements. Sorting 5 elements is a constant-time
 * operation since the group size is fixed. Since we have O(n/5) groups, the
 * total time for finding medians is O(n).
 * 
 * Recursion: After finding the medians of the groups, we recursively apply the
 * algorithm on these medians. The size of the problem is reduced to roughly n/5
 * at each level of recursion. The number of recursive levels is logarithmic,
 * specifically log(n). Therefore, the total time spent on recursion is O(log
 * n).
 * 
 * Pivot Selection: Finally, the median of medians algorithm selects a pivot
 * element in O(1) time.
 * 
 * Adding up the time complexity components:
 * 
 * O(n) (Divide into Groups) + O(n) (Finding Medians of Groups) + O(log n)
 * (Recursion) + O(1) (Pivot Selection) = O(n + log n) = O(n).
 * 
 * So, the overall time complexity of the median of medians algorithm is O(n),
 * making it a linear-time algorithm for finding the median. This linear-time
 * guarantee is what makes the median of medians algorithm useful for certain
 * selection problems.
 * 
 * 
 * 
 * 
 * 
 */
