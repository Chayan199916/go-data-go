/**
 * Wap to sort a given array. Sorting algo used : Insertion sort.
 */

class Problem4 {
    public static void main(String[] args) {
        int arr[] = { 5, 7, 3, 9, 1, 0, 4, 6 };
        insertionSort(arr);
    }

    static void insertionSort(int inputArray[]) {
        int temp, j;
        for (int i = 1; i < inputArray.length; i++) {
            temp = inputArray[i];
            for (j = i - 1; j >= 0 && temp < inputArray[j]; j--) {
                inputArray[j + 1] = inputArray[j];
            }
            inputArray[++j] = temp;
        }
        displayIntArray(inputArray);
    }

    static void displayIntArray(int inputArray[]) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
    }
}
