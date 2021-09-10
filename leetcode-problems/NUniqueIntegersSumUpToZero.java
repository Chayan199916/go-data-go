import java.util.Arrays;

public class NUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(12)));
    }

    private static int[] sumZero(int n) {
        int[] result = new int[n];
        int a = 0;
        int d = 1;
        int counter = 0;
        int coeff = n % 2 == 0 ? n - 1 : n - 2;
        while (coeff > 0) {
            result[counter] = a - coeff * d;
            coeff -= 2;
            counter++;
        }
        if (n % 2 != 0) {
            result[counter] = 0;
            counter++;
        }
        coeff = n % 2 == 0 ? counter - 1 : counter - 2;
        while (coeff >= 0) {
            result[counter] = -result[coeff];
            coeff--;
            counter++;
        }
        return result;
    }
}
