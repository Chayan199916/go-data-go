/**
 * Given an array arr of integer elements, the task is to find the range and
 * coefficient of range of the given array where: Range: Difference between the
 * maximum value and the minimum value in the distribution. Coefficient of
 * Range: (Max – Min) / (Max + Min). Examples:
 * 
 * 
 * Input: arr[] = {15, 16, 10, 9, 6, 7, 17} Output: Range : 11 Coefficient of
 * Range : 0.478261 Max = 17, Min = 6 Range = Max – Min = 17 – 6 = 11
 * Coefficient of Range = (Max – Min) / (Max + Min) = 11 / 23 = 0.478261 Input:
 * arr[] = {5, 10, 15} Output: Range : 10 Coefficient of Range : 0.5
 */

class Problem10 {
    public static void main(String[] args) {
        int result[] = calcRangeOfArray(new int[] { 5, 10, 15 });
        System.out.println("Range : " + result[0]);
        System.out.println("Coefficient of range : " + calcCoefficientOfRange(result[1], result[2]));
    }

    static int[] calcRangeOfArray(int inputArr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] > max) {
                max = inputArr[i];
            }
            if (inputArr[i] < min) {
                min = inputArr[i];
            }
        }
        return new int[] { max - min, max, min };
    }

    static float calcCoefficientOfRange(int max, int min) {
        return (float) (max - min) / (float) (max + min);
    }
}
