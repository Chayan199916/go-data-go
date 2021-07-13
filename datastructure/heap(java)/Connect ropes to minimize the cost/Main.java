import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println(minimizeCost(new int[] { 1, 2, 3, 4, 5 }));
    }

    static int minimizeCost(int inputArr[]) {
        int cost1 = 0;
        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        List<List<Integer>> seqOfSelections = new ArrayList<List<Integer>>();
        for (int i = 0; i < inputArr.length; i++) {
            minHeap.add(inputArr[i]);
        }
        while (minHeap.size() >= 2) {
            int minimum = minHeap.poll();
            int secondMinimum = minHeap.poll();
            seqOfSelections.add(new ArrayList<Integer>(Arrays.asList(minimum, secondMinimum)));
            cost1 = minimum + secondMinimum;
            cost += cost1;
            minHeap.add(cost1);
        }
        displayPath(seqOfSelections);
        return cost;
    }

    static void displayPath(List<List<Integer>> paths) {
        for (List<Integer> list : paths) {
            System.out.println(list);
        }
    }
}
