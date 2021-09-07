import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfNumber {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[] { 1, 2, 3, 4 }, 34));
    }

    private static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = num.length - 1; i >= 0; i--) {
            res.add((num[i] + k) % 10);
            k = (num[i] + k) / 10;
        }
        while (k > 0) {
            res.add(k % 10);
            k = k / 10;
        }
        Collections.reverse(res);
        return res;
    }
}
