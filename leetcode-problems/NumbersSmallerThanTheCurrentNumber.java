// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

class NumbersSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
        int[] result = smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
        for (int num : result) {
            System.out.println(num);
        }
    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        /**
         * this part has to be reviewed
         */
        // Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        // int val, freq;
        // for (int num : nums) {
        // if (map.containsKey(num)) {
        // Set<Integer> set = map.keySet();
        // for (Integer key : set) {
        // if (num < key) {
        // val = map.get(key).get(0);
        // map.get(key).set(0, val + 1);
        // }
        // }
        // freq = map.get(num).get(1) + 1;
        // map.get(num).set(1, freq);
        // } else {
        // Set<Integer> set = map.keySet();
        // int curSize = set.size();
        // System.out.println(curSize);
        // map.put(num, Arrays.asList(0, 1));
        // System.out.println(map);
        // if (curSize > 0) {
        // System.out.println("Hello");
        // for (Integer key : set) {
        // if (num < key) {
        // val = map.get(key).get(0);
        // map.get(key).set(0, val + 1);
        // } else if (num > key) {
        // val = map.get(num).get(0);
        // freq = map.get(key).get(1) + 1;
        // if (freq > 1) {
        // val++;
        // }
        // map.get(num).set(0, val + 1);
        // }
        // }
        // }
        // }
        // // System.out.println("for " + num + " " + map);
        // }
        // int size = map.size();
        // Set<Integer> set = map.keySet();
        // for (Integer key : set) {
        // if (map.get(key).get(1) > 1) {
        // size += map.get(key).get(1);
        // }
        // }
        // // System.out.println(size);
        // int[] result = new int[size];
        // for (int i = 0; i < nums.length; i++) {
        // result[i] = map.get(nums[i]).get(0);
        // }
        // return result;
        int[] record = new int[101];
        for (int num : nums) {
            record[num]++;
        }
        int count = 0;
        for (int i = 0; i < record.length; i++) {
            int temp = record[i];
            record[i] = count;
            count += temp;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = record[nums[i]];
        }
        return res;
    }
}