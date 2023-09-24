import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUsingBFSUnitWeight {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        int[] dis = new int[n];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < dis.length; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        dis[src] = 0;
        while (!queue.isEmpty()) {
            int lastVisited = queue.poll();
            for (Integer adjNode : adjList.get(lastVisited)) {
                if (dis[lastVisited] + 1 < dis[adjNode]) {
                    dis[adjNode] = dis[lastVisited] + 1;
                    queue.add(adjNode);
                }
            }
        }
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                dis[i] = -1;
            }
        }
        return dis;
    }
}
/*
 * Time Complexity: O(M) { for creating the adjacency list from given list
 * ‘edges’} + O(N + 2M) { for the BFS Algorithm} + O(N) { for adding the final
 * values of the shortest path in the resultant array} ~ O(N+2M).
 * 
 * Where N= number of vertices and M= number of edges.
 * 
 * Space Complexity: O( N) {for the stack storing the BFS} + O(N) {for the
 * resultant array} + O(N) {for the dist array storing updated shortest paths} +
 * O( N+2M) {for the adjacency list} ~ O(N+M) .
 * 
 * Where N= number of vertices and M= number of edges.
 */
