import java.util.ArrayList;
import java.util.Arrays;

public class FirstNegativeNumberOfWindowSizeK {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(printFirstNegativeInteger(new long[] { 12, -1, -7, 8, -15, 30, 16, 28 }, 8, 3)));
    }

    static long[] printFirstNegativeInteger(long A[], int N, int K) {
        int start = 0;
        int end = 0;
        ArrayList<Long> temp = new ArrayList<Long>();
        ArrayList<Long> result = new ArrayList<Long>();
        while (end < N) {
            if (A[end] < 0) {
                temp.add(A[end]);
            }
            if (end - start + 1 < K) {
                end++;
            } else if (end - start + 1 == K) {
                if (temp.isEmpty())
                    result.add(0l);
                else {
                    result.add(temp.get(0));
                    if (A[start] == temp.get(0)) {
                        temp.remove(0);
                    }
                }
                start++;
                end++;
            }
        }
        return result.stream().mapToLong(l -> l).toArray();
    }
}