import java.util.Arrays;

class MazeProblemAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[][] {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        int[][] path = new int[maze.length][maze[0].length];
        showPaths(0, 0, "", maze, path, 1);
    }

    static void showPaths(int row, int col, String output, boolean[][] maze, int[][] path, int steps) {
        /** This is to prevent the visited cell from getting revisited */
        if (!maze[row][col])
            return;
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(output);
            path[row][col] = steps;
            for (int[] p : path)
                System.out.println(Arrays.toString(p));
            return;
        }
        /** This is the path I'm going to follow until i reach the destination */
        /**
         * So I should make cells marked so that i don't come across a path i have
         * already visited
         */
        maze[row][col] = false;
        path[row][col] = steps;
        /** This is for right movement */
        if (col < maze[0].length - 1) {
            showPaths(row, col + 1, output + "R", maze, path, steps + 1);
        }
        /** This is for down movement */
        if (row < maze.length - 1) {
            showPaths(row + 1, col, output + "D", maze, path, steps + 1);
        }
        /** This is for up movement */
        if (row > 0) {
            showPaths(row - 1, col, output + "U", maze, path, steps + 1);
        }
        /** This is for left movement */
        if (col > 0) {
            showPaths(row, col - 1, output + "L", maze, path, steps + 1);
        }
        /**
         * This is the place where the path is over. So now it's time to return back.
         */
        /**
         * So it's my responsibility to make those cells unmarked which I previously
         * made marked
         */
        /**
         * This is the example of backtracking which is nothing but making changes to
         * the already made changes.
         */
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
