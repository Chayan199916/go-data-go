
/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 *  Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Sorted: [-4, -1, -1, 0, 1, 2]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0)
            return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
            }

        }
        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSumRecursive(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<Integer> sol = threeSumRecursiveUtil(nums, i, i + 1, nums.length - 1);
            if (sol != null) {
                res.add(sol);
            }
        }
        return new ArrayList<>(res);
    }

    public static List<Integer> threeSumRecursiveUtil(int[] nums, int current, int start, int end) {
        if (start >= end) {
            return null;
        }
        int sum = nums[current] + nums[start] + nums[end];
        if (sum == 0) {
            return new ArrayList<>(Arrays.asList(nums[current], nums[start], nums[end]));
        } else if (sum > 0) {
            return threeSumRecursiveUtil(nums, current, start, end - 1);
        } else {
            return threeSumRecursiveUtil(nums, current, start + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        Arrays.sort(nums);
        List<List<Integer>> res = threeSumRecursive(nums);
        System.out.println(res.size());
        for (List<Integer> list : res) {
            for (Integer element : list) {
                System.out.print(element + " ");
            }
            System.out.println(); // Print a newline after each inner list
        }
    }
}
