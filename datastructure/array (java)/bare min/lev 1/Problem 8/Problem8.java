import java.util.HashMap;

/**
 * Find the frequency of a number in an array Difficulty Level : Easy; Given an
 * array, a[], and an element x, find the number of occurrences of x in a[].
 * Examples:
 * 
 * 
 * Input : a[] = {0, 5, 5, 5, 4} x = 5 Output : 3
 * 
 * Input : a[] = {1, 2, 3} x = 4 Output : 0
 */

class Problem8 {
    public static void main(String[] args) {
        int arr[] = { 0, 5, 5, 4, 5, 5, 7, 9, 5, 5, 5, 0, 5 };
        int x = 1;
        System.out.println(findOccurences(arr, x));
    }

    static int findOccurences(int inputArr[], int num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inputArr.length; i++) {
            if (map.containsKey(inputArr[i])) {
                map.put(inputArr[i], map.get(inputArr[i]) + 1);
            } else {
                map.put(inputArr[i], 1);
            }
        }
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return -1;
    }
}
