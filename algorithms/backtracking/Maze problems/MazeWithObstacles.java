class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                { true, true, true },
                { true, false, true },
                { true, true, true }
        };
        showPaths(0, 0, "", maze);
    }

    static void showPaths(int row, int col, String output, boolean[][] maze) {
        if (!maze[row][col])
            return;
        if (row == maze.length - 1) {
            for (int i = 0; i < maze[0].length - 1 - col; i++) {
                output += "R";
            }
            System.out.println(output);
            return;
        }
        if (col == maze[0].length - 1) {
            for (int i = 0; i < maze.length - 1 - row; i++) {
                output += "D";
            }
            System.out.println(output);
            return;
        }
        showPaths(row, col + 1, output + "R", maze);
        showPaths(row + 1, col + 1, output + "A", maze);
        showPaths(row + 1, col, output + "D", maze);
    }
}
