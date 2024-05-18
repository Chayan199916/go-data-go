/**
 * A Maze is given as n*n matrix of blocks where source block is the upper left
 * most block i.e., matrix[0][0] and destination block is lower rightmost block
 * i.e., matrix[n-1][n-1]. A rat starts from source and has to reach the
 * destination. The rat can move in only two directions: first forward if
 * possible or down. If multiple solutions exist, the shortest earliest hop will
 * be accepted. For the same hop distance at any point, forward will be
 * preferred over downward. In the maze matrix, 0 means the block is the dead
 * end and non-zero number means the block can be used in the path from source
 * to destination. The non-zero value of mat[i][j] indicates number of maximum
 * jumps rat can make from cell mat[i][j]. In this variation, Rat is allowed to
 * jump multiple steps at a time instead of 1. Find a matrix which describes the
 * position the rat to reach at the destination.
 */
public class RatMazeWithMultipleJumps {
    public static int[][] ShortestDistance(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        if (!ratMaze(matrix, ans, 0, 0)) {
            return new int[][] { { -1 } };
        }
        return ans;
    }

    public static boolean ratMaze(int[][] matrix, int[][] ans, int currR, int currC) {
        if (currR == matrix.length - 1 && currC == matrix[0].length - 1) {
            ans[currR][currC] = 1;
            return true;
        }
        if (validPosition(currR, currC, matrix)) {
            ans[currR][currC] = 1;
            for (int i = 1; i <= matrix[currR][currC]; i++) {
                if (ratMaze(matrix, ans, currR, currC + i))
                    return true;
                if (ratMaze(matrix, ans, currR + i, currC))
                    return true;
            }
            ans[currR][currC] = 0;
        }
        return false;
    }

    public static boolean validPosition(int currR, int currC, int[][] matrix) {
        return currR < matrix.length && currC < matrix[0].length && matrix[currR][currC] != 0;
    }
}
