import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // System.out.println(checkSorted(new int[] { 4, 5 }, 0));
        // System.out.println(linearSearch2(new int[] { 2, 5, 4, 9, 8, 6, 9, 1 }, 9,
        // 0));
        sumTriangle2(new int[] { 1, 2, 3, 4, 5 }, 5);
    }

    static boolean checkSorted(int input[], int index) {
        if (index == input.length - 1)
            return true;
        if (input[index] > input[index + 1])
            return false;
        return checkSorted(input, index + 1);
    }

    static int linearSearch(int input[], int target, int index) {
        if (index == input.length)
            return -1;
        if (input[index] == target)
            return index;
        return linearSearch(input, target, index + 1);
    }

    static ArrayList<Integer> linearSearch(int input[], int target, int index, ArrayList<Integer> list) {
        if (index == input.length)
            return list;
        if (input[index] == target)
            list.add(index);
        return linearSearch(input, target, index + 1, list);
    }

    static ArrayList<Integer> linearSearch2(int input[], int target, int index) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (index == input.length)
            return list;
        if (input[index] == target)
            list.add(index);
        ArrayList<Integer> ansFromBottomCalls = linearSearch2(input, target, index + 1);
        list.addAll(ansFromBottomCalls);
        return list;
    }

    /**
     * sum triangle from array
     * [1,2,3,4,5]
     */
    static int sumTriangle(int[] input, int length) {
        if (length == 1)
            return input[0];
        for (int i = 0; i < length - 1; i++) {
            input[i] += input[i + 1];
        }
        return sumTriangle(input, length - 1);
    }

    static void sumTriangle2(int[] input, int length) {
        if (length == 1)
            return;
        int[] temp = new int[length - 1];
        for (int i = 0; i < length - 1; i++) {
            temp[i] = input[i] + input[i + 1];
        }
        sumTriangle2(temp, length - 1);

        System.out.println(Arrays.toString(temp));

    }
}
