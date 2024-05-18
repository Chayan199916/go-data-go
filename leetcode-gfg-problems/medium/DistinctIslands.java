import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        HashSet<ArrayList<Node>> islandShapes = new HashSet<>();
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<Node> islandShape = new ArrayList<>();
                    dfs(grid, vis, i, j, i, j, islandShape);
                    islandShapes.add(islandShape);
                }
            }
        }
        return islandShapes.size();
    }

    void dfs(int[][] grid, boolean[][] vis, int startRow,
            int startCol, int baseRow, int baseCol,
            ArrayList<Node> islandShape) {
        vis[startRow][startCol] = true;
        Node node = new Node(startRow - baseRow, startCol - baseCol);
        islandShape.add(node);
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        for (int i = 0; i < delRow.length; i++) {
            int nRow = startRow + delRow[i];
            int nCol = startCol + delCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(grid, vis, nRow, nCol, baseRow, baseCol, islandShape);
            }
        }
    }
}

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return row == other.row && col == other.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
