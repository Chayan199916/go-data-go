class Main {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 0, 7));
    }

    static int search(int input[], int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (input[mid] == target)
            return mid;
        else if (input[mid] < target)
            return search(input, target, mid + 1, end);
        else
            return search(input, target, start, mid - 1);
    }
}
