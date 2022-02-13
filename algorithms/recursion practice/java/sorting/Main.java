import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int numbers[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        bubbleSort(numbers, 0, 0);
        System.out.println(Arrays.toString(numbers));
    }

    static void bubbleSort(int numbers[], int row, int col) {
        if (row == numbers.length - 1)
            return;
        if (col < numbers.length - 1 - row) {
            if (numbers[col] > numbers[col + 1]) {
                int temp = numbers[col];
                numbers[col] = numbers[col + 1];
                numbers[col + 1] = temp;
            }
            bubbleSort(numbers, row, col + 1);
        } else {
            bubbleSort(numbers, row + 1, 0);
        }
    }

    static void selectionSort(int numbers[], int row, int col, int max) {
        if (row == numbers.length - 1)
            return;
        if (col <= numbers.length - 1 - row) {
            if (numbers[col] > numbers[max])
                max = col;
            selectionSort(numbers, row, col + 1, max);
        } else {
            int temp = numbers[max];
            numbers[max] = numbers[numbers.length - 1 - row];
            numbers[numbers.length - 1 - row] = temp;
            selectionSort(numbers, row + 1, 0, 0);
        }
    }
}
