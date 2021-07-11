import java.util.HashMap;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        findTopKFrequentNumbers(new int[] { 1, 1, 1, 2, 3, 4, 2, 5, 5 }, 3);
    }

    static void findTopKFrequentNumbers(int inputArr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer element : inputArr) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> {
            if (map.get(a) > map.get(b)) {
                return 1;
            } else {
                return -1;
            }
        }); // min heap

        for (Integer element : map.keySet()) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        while (pQueue.size() > 0) {
            System.out.print(pQueue.poll() + " ");
        }
    }
}
