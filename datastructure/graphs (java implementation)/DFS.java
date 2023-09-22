import java.util.*;

class DFS {

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
            ArrayList<Integer> ls) {

        // marking current node as visited
        vis[node] = true;
        ls.add(node);

        // getting neighbour nodes
        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // boolean array to keep track of visited vertices
        boolean vis[] = new boolean[V + 1];
        vis[0] = true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }

    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS sl = new DFS();
        ArrayList<Integer> ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
/*
 * Time Complexity: For an undirected graph, O(N) + O(2E), For a directed graph,
 * O(N) + O(E), Because for every node we are calling the recursive function
 * once, the time taken is O(N) and 2E is for total degrees as we traverse for
 * all adjacent nodes.
 * 
 * Space Complexity: O(3N) ~ O(N), Space for dfs stack space, visited array and
 * an adjacency list.
 */