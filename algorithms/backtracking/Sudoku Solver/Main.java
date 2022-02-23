import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // int nums[][] = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
        // { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
        // { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
        // { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
        // { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        // };
        char nums[][] = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        if (solve(nums))
            display(nums);
        else
            System.out.println("Sudoku can't be solved");
    }

    static boolean solve(char[][] nums) {
        int n = nums.length;
        int row = -1;
        int col = -1;
        boolean isLeft = true;
        /** looking for an empty cell */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /** found an empty cell */
                if (nums[i][j] == '.') {
                    row = i;
                    col = j;
                    isLeft = false;
                    break;
                }
            }
            /** already found so no need to proceed, needs to be filled up */
            if (!isLeft)
                break;
        }
        /** no empty cell, sudoku has been solved */
        if (isLeft)
            return true;

        /** this is the main part where correct value has to be kept */
        for (int number = 1; number <= 9; number++) {
            if (isSafe(nums, row, col, (char) (number + '0'))) {
                nums[row][col] = (char) (number + '0');
                if (solve(nums)) {
                    return true;
                } else
                    nums[row][col] = '.';
            }
        }
        return false; /** sudoku can't be solved */
    }

    static void display(char[][] nums) {
        String output = "[";
        for (char[] row : nums) {
            output += Arrays.toString(row) + ",";
        }
        output = output.substring(0, output.length() - 1) + "]";
        System.out.println(output);
    }

    static boolean isSafe(char[][] nums, int row, int col, char num) {
        /** horizontal checking */
        for (int i = 0; i < nums.length; i++) {
            /** check if the number is in the row */
            if (nums[row][i] == num)
                return false;
        }
        /** vertical checking */
        for (int i = 0; i < nums.length; i++) {
            /** check if the number is in the column */
            if (nums[i][col] == num)
                return false;
        }
        /** if number is in the 3 x 3 grid */
        int sqrt = (int) Math.sqrt(nums.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (nums[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    // static boolean solve(int[][] nums) {
    // int n = nums.length;
    // int row = -1;
    // int col = -1;
    // boolean isLeft = true;
    // /** looking for an empty cell */
    // for (int i = 0; i < n; i++) {
    // for (int j = 0; j < n; j++) {
    // /** found an empty cell */
    // if (nums[i][j] == 0) {
    // row = i;
    // col = j;
    // isLeft = false;
    // break;
    // }
    // }
    // /** already found so no need to proceed, needs to be filled up */
    // if (!isLeft)
    // break;
    // }
    // /** no empty cell, sudoku has been solved */
    // if (isLeft)
    // return true;

    // /** this is the main part where correct value has to be kept */
    // for (int number = 1; number <= 9; number++) {
    // if (isSafe(nums, row, col, number)) {
    // nums[row][col] = number;
    // if (solve(nums)) {
    // return true;
    // } else
    // nums[row][col] = 0;
    // }
    // }
    // return false; /** sudoku can't be solved */
    // }

    // static void display(int[][] nums) {
    // String output = "[";
    // for (int[] row : nums) {
    // output += Arrays.toString(row) + ",";
    // }
    // output = output.substring(0, output.length() - 1) + "]";
    // System.out.println(output);
    // }

    // static boolean isSafe(int[][] nums, int row, int col, int num) {
    // /** horizontal checking */
    // for (int i = 0; i < nums.length; i++) {
    // /** check if the number is in the row */
    // if (nums[row][i] == num)
    // return false;
    // }
    // /** vertical checking */
    // for (int i = 0; i < nums.length; i++) {
    // /** check if the number is in the column */
    // if (nums[i][col] == num)
    // return false;
    // }
    // /** if number is in the 3 x 3 grid */
    // int sqrt = (int) Math.sqrt(nums.length);
    // int rowStart = row - row % sqrt;
    // int colStart = col - col % sqrt;
    // for (int i = rowStart; i < rowStart + sqrt; i++) {
    // for (int j = colStart; j < colStart + sqrt; j++) {
    // if (nums[i][j] == num)
    // return false;
    // }
    // }
    // return true;
    // }
}