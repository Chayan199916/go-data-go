import java.util.ArrayList;
import java.util.Arrays;

class GetIndices {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAllIndices(new int[] { 2, 2, 2, 2, 2, 2, 2 }, 0, 2, 0)));
    }

    public static int getFirstIndex(int[] nums, int index, int key) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] == key) {
            return index;
        }
        return getFirstIndex(nums, index + 1, key);
    }

    public static int getLastIndex(int[] nums, int index, int key) {
        // if (index == -1) { // starting from last index
        // return -1;
        // }
        // if (nums[index] == key) {
        // return index;
        // } else {
        // return getLastIndex(nums, index - 1, key);
        // }
        if (index == nums.length) {
            return -1;
        }
        int lastIndex = getLastIndex(nums, index + 1, key);
        if (lastIndex == -1) {
            if (nums[index] == key) {
                return index;
            } else {
                return -1;
            }
        } else {
            return lastIndex;
        }
    }

    public static ArrayList<Integer> getAllIndices(int[] nums, int index, int key, ArrayList<Integer> indices) {
        if (index == nums.length) {
            return indices;
        }
        if (nums[index] == key) {
            indices.add(index);
        }
        return getAllIndices(nums, index + 1, key, indices);
    }

    public static int[] getAllIndices(int[] nums, int index, int key, int keyCount) {
        if (index == nums.length) {
            return new int[keyCount];
        }
        if (nums[index] == key) {
            int[] indices = getAllIndices(nums, index + 1, key, keyCount + 1);
            indices[keyCount] = index;
            return indices;
        } else {
            int[] indices = getAllIndices(nums, index + 1, key, keyCount);
            return indices;
        }
    }
}