import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];
        Deque<Node> dequeue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dequeue.offer(new Node(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }
        while (!dequeue.isEmpty()) {
            int row = dequeue.peek().first;
            int col = dequeue.peek().second;
            int steps = dequeue.peek().steps;
            dequeue.poll();

            distance[row][col] = steps;

            int[] delRow = { -1, 0, 1, 0 };
            int[] delCol = { 0, 1, 0, -1 };
            for (int i = 0; i < delRow.length; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0) {
                    dequeue.offer(new Node(nRow, nCol, steps + 1));
                    visited[nRow][nCol] = 1;
                }
            }
        }
        return distance;
    }
}

class Node {
    int first;
    int second;
    int steps;

    Node(int first, int second, int steps) {
        this.first = first;
        this.second = second;
        this.steps = steps;
    }
}