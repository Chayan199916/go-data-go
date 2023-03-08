import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */
public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer element : nums) {
            // if (map.containsKey(element)) {
            // map.put(element, map.get(element) + 1);
            // } else {
            // map.put(element, 1);
            // }
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> {
            // if (map.get(a) > map.get(b)) {
            // return 1;
            // } else {
            // return -1;
            // }
            return map.get(a) - map.get(b); // min heap
            // return map.get(b) - map.get(a); // max heap
        });

        for (Integer element : map.keySet()) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                pQueue.poll();
            } // for min heap
        }
        // int index = 0;
        // while (index < k) {
        // res[index++] = pQueue.poll();
        // } // max heap logic
        while (pQueue.size() > 0) {
            res[--k] = pQueue.poll();
        }
        return res;
    }
}

/**
 * Thought process :
 * heap can be used to optimize performance.
 * both heaps can be used: max heap , min heap;
 * Here, we are looking for top k frequent elements. If we use max heap, where
 * frequencies of the elements are the nodes in the heap so we will poll k
 * elements from max heap so that we get top k frequent elements from the heap.
 * If we use min heap, we will restrict the size of the heap at k and all other
 * elements (n - k) will be discarded from the queue as those will be having
 * less frequencies. Then we can traverse that k size heap to get top k freq
 * elements.
 * 
 */
