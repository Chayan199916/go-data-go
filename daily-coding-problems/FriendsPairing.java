import java.util.Arrays;

public class FriendsPairing {
    public static void main(String[] args) {
        int n = 4;
        // int[] mem = new int[n + 1];
        // Arrays.fill(mem, -1);
        // System.out.println(getNumberOfPairsTopBottom(n, mem));
        System.out.println(getNumberOfPairsBottomUpV2(n));
    }

    public static int getNumberOfPairs(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        if (n <= 2)
            return n;
        return getNumberOfPairs(n - 1) + (n - 1) * getNumberOfPairs(n - 2);
    }

    public static int getNumberOfPairsBottomUp(int n) {
        int[] mem = new int[n + 1];
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i - 1] + (i - 1) * mem[i - 2];
        }
        return mem[n];
    }

    public static int getNumberOfPairsBottomUpV2(int n) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        int prev1 = 1;
        int prev2 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev2 + (i - 1) * prev1;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    public static int getNumberOfPairsTopBottom(int n, int mem[]) {
        if (n < 1)
            throw new IllegalArgumentException("n must be greater than 0");
        if (mem[n] != -1)
            return mem[n];
        if (n <= 2)
            return mem[n] = n;
        return mem[n] = getNumberOfPairsTopBottom(n - 1, mem) + (n - 1) * getNumberOfPairsTopBottom(n - 2, mem);
    }

}
