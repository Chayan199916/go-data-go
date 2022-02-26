import java.util.Arrays;

class SumTriangle {
    public static void main(String[] args) {
        calculateSum(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    }

    static void calculateSum(int[] numbers) {
        if (numbers.length == 1)
            return;
        int[] temp = new int[numbers.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = numbers[i] + numbers[i + 1];
        }
        System.out.println(Arrays.toString(temp));
        calculateSum(temp);
    }
}
