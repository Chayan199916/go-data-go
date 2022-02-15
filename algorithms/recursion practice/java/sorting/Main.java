import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int numbers[] = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int result[] = mergesort(numbers);
        // System.out.println(Arrays.toString(result));
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    static void bubbleSort(int numbers[], int row, int col, boolean flag) {
        if (row == numbers.length - 1)
            return;
        if (flag)
            return;
        if (col < numbers.length - 1 - row) {
            flag = true;
            if (numbers[col] > numbers[col + 1]) {
                int temp = numbers[col];
                numbers[col] = numbers[col + 1];
                numbers[col + 1] = temp;
                flag = false;
            }
            bubbleSort(numbers, row, col + 1, flag);
        } else {
            bubbleSort(numbers, row + 1, 0, flag);
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

    static void mergesortInplace(int numbers[], int start, int end) {
        if (start == end)
            return;
        int mid = start + (end - start) / 2;
        mergesortInplace(numbers, start, mid);
        mergesortInplace(numbers, mid + 1, end);
        mergeInPlace(numbers, start, mid, end);
    }

    static void mergeInPlace(int[] numbers, int start, int mid, int end) {
        int i = 0;
        int j = 0;
        int k = 0;
        int merged[] = new int[end - start + 1];
        for (i = start, j = mid + 1; i <= mid && j <= end;) {
            if (numbers[i] < numbers[j])
                merged[k++] = numbers[i++];
            else if (numbers[i] > numbers[j])
                merged[k++] = numbers[j++];
            else {
                merged[k++] = numbers[j++];
                i++;
            }
        }
        while (i <= mid)
            merged[k++] = numbers[i++];
        while (j <= end)
            merged[k++] = numbers[j++];
        for (k = 0; k < merged.length; k++) {
            numbers[start + k] = merged[k];
        }
    }

    static int[] mergesort(int numbers[]) {
        if (numbers.length == 1)
            return numbers;
        int mid = numbers.length / 2;
        int left[] = mergesort(Arrays.copyOfRange(numbers, 0, mid));
        int right[] = mergesort(Arrays.copyOfRange(numbers, mid, numbers.length));
        return merge(left, right);
    }

    static int[] merge(int left[], int right[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        int merged[] = new int[left.length + right.length];
        for (i = 0, j = 0; i < left.length && j < right.length;) {
            if (left[i] < right[j])
                merged[k++] = left[i++];
            else if (left[i] > right[j])
                merged[k++] = right[j++];
            else {
                merged[k++] = left[j++];
                i++;
            }
        }
        while (i < left.length)
            merged[k++] = left[i++];
        while (j < right.length)
            merged[k++] = right[j++];
        return merged;
    }

    static void quickSort(int nums[], int start, int end) {
        if (start >= end)
            return;
        int s = start;
        int e = end;
        int p = s + (e - s) / 2;
        int pivot = nums[p];
        while (s <= e) {
            while (nums[s] < pivot)
                s++;
            while (nums[e] > pivot)
                e--;
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(nums, start, e);
        quickSort(nums, s, end);
    }
}
