import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            printKLargestELments(new int[] { 4, 2, 3, 1, 9, 5, 0 }, i);
        }
    }

    static void printKLargestELments(int inputArr[], int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); // min heap
        for (Integer element : inputArr) {
            pQueue.add(element);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        while (pQueue.size() > 0) {
            System.out.print(pQueue.poll() + " ");
        }
        System.out.println();
    }
}
