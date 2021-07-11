import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        List<Integer> result = findKClosestNumbers(new int[] { 10, 2, 14, 4, 7, 6 }, 3, 5);
        for (Integer element : result) {
            System.out.print(element + " ");
        }
    }

    static List<Integer> findKClosestNumbers(int inputArr[], int k, int x) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(x - a) > Math.abs(x - b)) {
                return -1;
            } else {
                return 1;
            }
        }); // max heap

        for (Integer element : inputArr) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }

        List<Integer> resultList = new ArrayList<>();

        while (!pQueue.isEmpty()) {
            int top = pQueue.poll();
            resultList.add(top);
        }
        // resultList.sort((a, b) -> (a - b));
        return resultList;
    }
}
