import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {
    public static void main(String[] args) {
        List<Boolean> result = kidsWithCandies(new int[] { 12, 2, 12 }, 10);
        for (Boolean b : result) {
            System.out.print(b + " ");
        }
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}

// https:// leetcode.com/problems/kids-with-the-greatest-number-of-candies/