/*
 * Given a non negative integer x; return the square root f x rounded down to the nearest integer. the returned integer should be non negative as well.
 */
class Sqrtx {
    public static void main(String[] args) {
        System.out.println(sqrtx(4));
        System.out.println(sqrtx(8));
        System.out.println(sqrtx(7));
        System.out.println(sqrtx(9));
        System.out.println(sqrtx(10));
    }

    static int sqrtx(int x) {
        int res = 0;
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid - 1;
            } else if (mid * mid < x) {
                start = mid + 1;
                res = mid;
            } else {
                return mid;
            }
        }
        return res;
    }
}
/*
 * time complexity : O(logx) where x is the input number as we are narrowing
 * down the search space using binary search.
 * linear way would have taken O(x^0.5)
 */