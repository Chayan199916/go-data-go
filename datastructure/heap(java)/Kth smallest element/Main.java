import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            System.out.println("Kth ( " + i + " ) smallest element : "
                    + findKthSmallestElement(new int[] { 3, 5, 1, 7, 9, 0, 8 }, i));
        }
    }

    static int findKthSmallestElement(int inputArr[], int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Integer element : inputArr) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        return pQueue.peek();
    }
}
/**
 * Time Complexity : O(nlogk)
 */
