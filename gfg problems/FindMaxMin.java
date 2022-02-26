import java.util.Arrays;

class FindMaxMin {
    public static void main(String[] args) {
        int[] numbers = new int[] { 1, 4, 45, 6, 10, -8 };
        System.out.println(Arrays.toString(findMaxMin(numbers, 1, numbers[0], numbers[0])));
    }

    static int[] findMaxMin(int[] numbers, int index, int max, int min) {
        if (index == numbers.length) {
            return new int[] { max, min };
        }
        if (numbers[index] > max) {
            max = numbers[index];
        }
        if (numbers[index] < min) {
            min = numbers[index];
        }
        return findMaxMin(numbers, index + 1, max, min);
    }
}
