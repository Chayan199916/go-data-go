import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        int points[][] = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        int k = 2;
        findKClosestPoints(points, k);
    }

    static void findKClosestPoints(int points[][], int k) {
        Map<List<Integer>, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            List<Integer> point = new ArrayList<>();
            int distance = calculateSquaredDistanceFromOrigin(points[i][0], points[i][1]);
            point.add(points[i][0]);
            point.add(points[i][1]);
            distanceMap.put(point, distance);
        }
        // System.out.println(distanceMap); // {[0, 1]=1, [1, 3]=10, [5, 8]=89, [-2,
        // 2]=8}

        Comparator<List<Integer>> comparator = new Comparator<>() {
            public int compare(List<Integer> point1, List<Integer> point2) {
                if (distanceMap.get(point1) > distanceMap.get(point2)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }; /** max heap logic */
        PriorityQueue<List<Integer>> pQueue = new PriorityQueue<>(comparator);
        Set<Map.Entry<List<Integer>, Integer>> entries = distanceMap.entrySet();
        for (Map.Entry<List<Integer>, Integer> entry : entries) {
            pQueue.add(entry.getKey());
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }
        while (pQueue.size() > 0) {
            List<Integer> point = pQueue.poll();
            System.out.println(point + " -> " + String.format("%.3f", (Math.sqrt(distanceMap.get(point)))));
        }
    }

    static int calculateSquaredDistanceFromOrigin(int x, int y) {
        return x * x + y * y;
    }
}
