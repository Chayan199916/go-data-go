import java.util.PriorityQueue;

public class OptimalMergePattern {
    public static void main(String[] args) {
        System.out.println(getOptimalCost(new int[] { 2, 3, 4, 5, 6, 7 }));
    }

    public static int getOptimalCost(int[] costs) {
        int optimalCost = 0;
        int currentCost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
                (a, b) -> a - b); // min heap
        for (Integer cost : costs) {
            queue.add(cost);
        }
        while (queue.size() > 1) {
            int smallest = queue.poll();
            int secondSmallest = queue.poll();
            currentCost = smallest + secondSmallest;
            queue.add(currentCost);
            optimalCost += currentCost;
        }
        return optimalCost;
    }
}
