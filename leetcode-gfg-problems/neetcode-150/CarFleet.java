import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * There are n cars going to the same destination along a one-lane road. The
 * destination is target miles away.
 * 
 * You are given two integer array position and speed, both of length n, where
 * position[i] is the position of the ith car and speed[i] is the speed of the
 * ith car (in miles per hour).
 * 
 * A car can never pass another car ahead of it, but it can catch up to it and
 * drive bumper to bumper at the same speed. The faster car will slow down to
 * match the slower car's speed. The distance between these two cars is ignored
 * (i.e., they are assumed to have the same position).
 * 
 * A car fleet is some non-empty set of cars driving at the same position and
 * same speed. Note that a single car is also a car fleet.
 * 
 * If a car catches up to a car fleet right at the destination point, it will
 * still be considered as one car fleet.
 * 
 * Return the number of car fleets that will arrive at the destination.
 */
public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> cars = new HashMap<Integer, Integer>();
        Stack<Double> carFleet = new Stack<Double>();
        if (position.length == 1)
            return 1;
        for (int i = 0; i < position.length; i++) {
            cars.put(position[i], speed[i]);
        }
        List<Integer> sortedCarPositions = new ArrayList<Integer>(cars.keySet());
        Collections.sort(sortedCarPositions);
        for (int i = sortedCarPositions.size() - 1; i >= 0; i--) {
            double currentTime = (double) (target - sortedCarPositions.get(i))
                    / (double) cars.get(sortedCarPositions.get(i));
            if (carFleet.isEmpty()) {
                carFleet.push(currentTime);
            } else {
                double previousTime = carFleet.peek();
                if (currentTime <= previousTime) {
                    continue;
                } else {
                    carFleet.push(currentTime);
                }
            }
        }
        return carFleet.size();
    }

    public static void main(String[] args) {
        System.out.println(carFleet(10, new int[] { 6, 8 }, new int[] { 3, 2 }));
    }
}
