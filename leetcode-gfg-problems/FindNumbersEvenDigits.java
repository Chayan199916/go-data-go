
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

class FinddNumbersEvenDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[] { 555, 901, 482, 1771 }));
    }

    private static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenDigits(num)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasEvenDigits(int num) {
        // int count = 0;
        // while (num > 0) {
        // count++;
        // num /= 10;
        // }
        // if (count % 2 == 0) {
        // return true;
        // }
        // return false;
        int countDigits = countDigits(num);
        return countDigits % 2 == 0;
    }

    private static int countDigits(int num) {
        if (num == 0) {
            return 1;
        }
        if (num < 0) {
            num *= -1;
        }
        return (int) Math.log10(num) + 1;
    }
}