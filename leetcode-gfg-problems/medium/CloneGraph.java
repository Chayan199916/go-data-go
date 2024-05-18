
// Definition for a Node.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbor : currentNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node temp = new Node(neighbor.val);
                    map.put(neighbor, temp);
                    queue.offer(neighbor);

                    // Connect the cloned neighbor to the cloned current node
                    map.get(currentNode).neighbors.add(temp);
                } else {
                    // Connect the cloned neighbor to the cloned current node
                    map.get(currentNode).neighbors.add(map.get(neighbor));
                }
            }
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}