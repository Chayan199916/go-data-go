import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int inputs[] = { 1, 3, 12, 5, 15, 11 };
        int thirdSmallest = findKThSmallestElement(inputs, 3);
        int sixthSmallest = findKThSmallestElement(inputs, 6);
        System.out.println(calculateSum(thirdSmallest, sixthSmallest, inputs));
    }

    static int calculateSum(int first, int second, int inputs[]) {
        int sum = 0;
        for (Integer element : inputs) {
            if (element > first && element < second) {
                sum += element;
            }
        }
        return sum;
    }

    static int findKThSmallestElement(int inputArr[], int k) {
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
