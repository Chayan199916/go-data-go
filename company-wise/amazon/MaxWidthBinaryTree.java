import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {
    static BinaryTree.Node root = null;

    static int calculateMaxWidth() {
        int maxWidth = 0;
        if (root == null)
            return maxWidth;
        Queue<BinaryTree.Node> queue = new LinkedList<BinaryTree.Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int widthOfLevel = queue.size();
            maxWidth = Math.max(widthOfLevel, maxWidth);
            while (widthOfLevel-- > 0) {
                BinaryTree.Node fetchedNode = queue.remove();
                if (fetchedNode.left != null) {
                    queue.add(fetchedNode.left);
                }
                if (fetchedNode.right != null) {
                    queue.add(fetchedNode.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) throws IOException {
        root = BinaryTree.createTree();
        System.out.println(calculateMaxWidth());
    }
}
