import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class VerticalSumBinaryTree {

    public static HashMap<Integer, Integer> calculateVerticalSum(BinaryTree.Node root) {
        HashMap<BinaryTree.Node, Integer> distanceMap = new HashMap<BinaryTree.Node, Integer>();
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        Queue<BinaryTree.Node> queue = new LinkedList<BinaryTree.Node>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        distanceMap.put(root, 0);
        while (!queue.isEmpty()) {
            BinaryTree.Node fetchedNode = queue.remove();
            if (fetchedNode.left != null) {
                queue.add(fetchedNode.left);
                distanceMap.put(fetchedNode.left, distanceMap.get(fetchedNode) - 1);
            }
            if (fetchedNode.right != null) {
                queue.add(fetchedNode.right);
                distanceMap.put(fetchedNode.right, distanceMap.get(fetchedNode) + 1);
            }
        }
        queue.clear();
        queue.add(root);
        sumMap.put(distanceMap.get(root), root.data);
        while (!queue.isEmpty()) {
            BinaryTree.Node fetchedNode = queue.remove();
            if (fetchedNode.left != null) {
                queue.add(fetchedNode.left);
                if (sumMap.containsKey(distanceMap.get(fetchedNode.left))) {
                    sumMap.put(distanceMap.get(fetchedNode.left),
                            sumMap.get(distanceMap.get(fetchedNode.left)) + fetchedNode.left.data);
                } else {
                    sumMap.put(distanceMap.get(fetchedNode.left), fetchedNode.left.data);
                }
            }
            if (fetchedNode.right != null) {
                queue.add(fetchedNode.right);
                if (sumMap.containsKey(distanceMap.get(fetchedNode.right))) {
                    sumMap.put(distanceMap.get(fetchedNode.right),
                            sumMap.get(distanceMap.get(fetchedNode.right)) + fetchedNode.right.data);
                } else {
                    sumMap.put(distanceMap.get(fetchedNode.right), fetchedNode.right.data);
                }
            }
        }
        return sumMap;
    }

    public static void main(String[] args) throws IOException {
        BinaryTree.Node root = BinaryTree.createTree();
        HashMap<Integer, Integer> sumMap = calculateVerticalSum(root);
        System.out.println(sumMap);
    }
}
