import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int isLands = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    isLands++;
                }
            }
        }
        return isLands;
    }

    public void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(i, j));
        int[] delRow = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] delCol = { 0, 1, 1, 1, 0, -1, -1, -1 };
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();
            for (int steps = 0; steps < delRow.length; steps++) {
                int newRow = row + delRow[steps];
                int newCol = col + delCol[steps];
                if (newRow >= 0 && newRow < grid.length &&
                        newCol >= 0 && newCol < grid[0].length &&
                        grid[newRow][newCol] == '1' &&
                        !visited[newRow][newCol]) {
                    queue.offer(new Node(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
    }
}

class Node {
    int first;
    int second;

    Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}