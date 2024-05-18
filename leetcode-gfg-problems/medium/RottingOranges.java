import java.util.ArrayDeque;

class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;
        int countFreshTotal = 0;
        int timeMax = 0;
        int freshMango = 1;
        int rottenMango = 2;
        int[] deltaRow = new int[] { -1, 0, 1, 0 };
        int[] deltaCol = new int[] { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = rottenMango;
                } else if (grid[i][j] == freshMango) {
                    countFreshTotal++;
                }
            }
        }
        int countRottenTotal = 0;
        while (queue.size() > 0) {
            Pair pair = queue.removeFirst();
            int row = pair.row;
            int col = pair.col;
            int time = pair.time;
            timeMax = Math.max(time, timeMax);
            for (int i = 0; i < deltaRow.length; i++) {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        visited[newRow][newCol] != rottenMango &&
                        grid[newRow][newCol] == freshMango) {
                    visited[newRow][newCol] = rottenMango;
                    countRottenTotal++;
                    queue.add(new Pair(newRow, newCol, time + 1));
                }
            }
        }
        if (countRottenTotal == countFreshTotal)
            return timeMax;
        return -1;
    }
}

class Pair {
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}