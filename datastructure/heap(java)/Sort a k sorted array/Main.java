import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        sortKSortedArray(new int[] { 6, 5, 3, 2, 8, 9, 10 }, 3);
    }

    static void sortKSortedArray(int inputArr[], int k) {
        /**
         * we'll use min heap and restrict the size to k as we know that min will be
         * present inside i+k loc. each poll() will give exact val at that loc while
         * traversing through each loc
         */
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); // min heap
        for (Integer element : inputArr) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                System.out.print(pQueue.poll() + " ");
            }
        }
        while (pQueue.size() > 0) {
            System.out.print(pQueue.poll() + " ");
        }
    }
}
