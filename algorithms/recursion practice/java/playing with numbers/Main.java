class Main {
    static int sum = 0;

    static void rev1(int num) {
        if (num == 0)
            return;
        int rem = num % 10;
        sum = sum * 10 + rem;
        rev1(num / 10);
    }

    static int rev2(int num) {
        int digits = (int) Math.log10(num) + 1;
        return helper(num, digits);
    }

    static int helper(int num, int digits) {
        if (num % 10 == num)
            return num;
        return (num % 10) * (int) Math.pow(10, digits - 1) + helper(num / 10, digits - 1);
    }

    /**
     * 12345 ; start == end
     * 1234 ; start > end
     */
    /**
     * 12321
     */
    static boolean checkPalindrome(String num, int start, int end) {
        if (start > end)
            return true;
        if (num.charAt(start) != num.charAt(end))
            return false;
        return checkPalindrome(num, start + 1, end - 1);
    }

    static int countZeroes(int num, int count) {
        if (num == 0)
            return count;
        if (num % 10 == 0)
            return countZeroes(num / 10, count + 1);
        return countZeroes(num / 10, count);
    }

    static int helper2(int num, int steps) {
        if (num == 0)
            return steps;
        if (num % 2 == 0)
            return helper2(num / 2, steps + 1);
        return helper2(num - 1, steps + 1);
    }

    static int numberOfStepsToZero(int num) {
        return helper2(num, 0);
    }

    static int minNumberOfMoves(int num, int target, int maxDoubles, int steps) {
        if (num == target)
            return steps;
        if (maxDoubles != 0)
            return minNumberOfMoves(num * 2, target, maxDoubles - 1, steps + 1);
        return minNumberOfMoves(num + 1, target, maxDoubles, steps + 1);
    }

    public static void main(String[] args) {
        // rev1(12345);
        // System.out.println(sum);
        // System.out.println(rev2(12345));
        // System.out.println(countZeroes(10203000, 0));
        // System.out.println(checkPalindrome("1", 0, 0));

    }
}
/**
 * 1234 -> 4321
 * 
 * rev2:
 * 4 * 10 ^ 3 + 3 * 10 ^ 2 + 2 * 10 ^ 1 + 1
 * 
 * rev1:
 * 4 * 10 + 3 = 43;
 * 43 * 10 + 2 = 432;
 * 432 * 10 + 1 = 4321;
 * 
 * 
 */
