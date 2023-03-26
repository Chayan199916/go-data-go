/**
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        /*
         * BRUTE FORCE - O(n^2)
         */
        // int maxArea = 0;
        // for (int i = 0; i < height.length; i++) {
        // for (int j = i + 1; j < height.length; j++) {
        // maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
        // }
        // }
        // return maxArea;
        /*
         * two pointers - O(n)
         */
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
