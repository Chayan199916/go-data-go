import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        performFrequencySorting(new int[] { 3, 3, 4, 2, 4, 4, 1, 1, 3, 3 });
    }

    static void performFrequencySorting(int inputArr[]) {
        Map<Integer, Integer> freqCounter = new HashMap<Integer, Integer>();
        /**
         * O(n * m) where n is the number of unique elements in array and m is frequency
         * of elements
         */
        for (Integer elem : inputArr) {
            if (freqCounter.containsKey(elem)) {
                freqCounter.put(elem, freqCounter.get(elem) + 1);
            } else {
                freqCounter.put(elem, 1);
            }
        }
        Comparator<Integer> customComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (freqCounter.get(a) > freqCounter.get(b)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(customComparator);
        /**
         * O(n)
         */
        for (Integer element : freqCounter.keySet()) {
            pQueue.add(element);
        }
        List<Integer> sortedList = new ArrayList<Integer>();
        while (pQueue.size() > 0) {
            int element = pQueue.poll();
            int freq = freqCounter.get(element);
            for (int i = 0; i < freq; i++) {
                sortedList.add(element);
            }
        }
        display(sortedList);
    }

    static void display(List<Integer> sortedList) {
        for (Integer element : sortedList) {
            System.out.print(element + " ");
        }
    }
}
