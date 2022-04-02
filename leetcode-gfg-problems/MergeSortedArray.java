import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[] { 1 }, 1, new int[] {}, 0);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int k = 0, i, j;
        for (i = 0, j = 0; i < m && j < n;) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                temp[k++] = nums2[j++];
            } else {
                temp[k++] = nums1[i++];
                temp[k++] = nums2[j++];
            }
        }
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        nums1 = temp;
    }
}
