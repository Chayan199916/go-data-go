/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int max = height[0];
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = rightMax[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        int trappedWaterAmount = 0;
        for (int i = 0; i < height.length; i++) {
            int amountAtPos = Math.min(leftMax[i], rightMax[i]) - height[i];
            trappedWaterAmount += amountAtPos < 0 ? 0 : amountAtPos;
        }
        return trappedWaterAmount;
    }

    public int trapTwoPointers(int[] height) {
        int trappedWater = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int leftMaxHeight = height[leftPointer];
        int rightMaxHeight = height[rightPointer];
        while (leftPointer <= rightPointer) {
            if (leftMaxHeight < rightMaxHeight) {
                trappedWater += leftMaxHeight - height[leftPointer] < 0 ? 0 : leftMaxHeight - height[leftPointer];
                leftMaxHeight = Math.max(leftMaxHeight, height[leftPointer]);
                leftPointer++;
            } else {
                trappedWater += rightMaxHeight - height[rightPointer] < 0 ? 0 : rightMaxHeight - height[rightPointer];
                rightMaxHeight = Math.max(rightMaxHeight, height[rightPointer]);
                rightPointer--;
            }
        }
        return trappedWater;
    }
}
