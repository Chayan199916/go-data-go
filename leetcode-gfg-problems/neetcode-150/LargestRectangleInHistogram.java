/**
 * Given an array of integers heights representing the histogram's bar height
 * where the width of each bar is 1, return the area of the largest rectangle in
 * the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }

    static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length && heights[j] >= heights[i]; j++) {
                int currentArea = (j - i + 1) * Math.min(heights[i], heights[j]);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }
}
