class Main {
    public static void main(String[] args) {
        pattern1(0, 0);
        pattern2(0, 0);
    }

    /**
     * ****
     * ***
     * **
     * *
     */
    static void pattern1(int row, int col) {
        if (row == 4)
            return;
        if (col < 4 - row) {
            System.out.print("*");
            pattern1(row, col + 1);
        } else {
            System.out.println();
            pattern1(row + 1, 0);
        }
    }

    static void pattern2(int row, int col) {
        if (row == 4)
            return;
        if (col <= row) {
            System.out.print("*");
            pattern2(row, col + 1);
        } else {
            System.out.println();
            pattern2(row + 1, 0);
        }
    }
}
