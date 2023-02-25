import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class MakeMirrorTree {

    static BinaryTree.Node root = null;

    private static void createMirrorTree(BinaryTree.Node sourceTreeRoot) {
        if (sourceTreeRoot == null) {
            return;
        }
        Queue<BinaryTree.Node> sourceTreeQueue = new LinkedList<BinaryTree.Node>();
        Queue<BinaryTree.Node> targetTreeQueue = new LinkedList<BinaryTree.Node>();
        BinaryTree.Node targetTreeRoot = BinaryTree.createNode(sourceTreeRoot.data);
        sourceTreeQueue.add(sourceTreeRoot);
        targetTreeQueue.add(targetTreeRoot);
        while (!sourceTreeQueue.isEmpty()) {
            BinaryTree.Node sourceTreeParser = sourceTreeQueue.remove();
            BinaryTree.Node targetTreeParser = targetTreeQueue.remove();
            if (sourceTreeParser.left != null) {
                targetTreeParser.right = BinaryTree.createNode(sourceTreeParser.left.data);
                sourceTreeQueue.add(sourceTreeParser.left);
                targetTreeQueue.add(targetTreeParser.right);
            }
            if (sourceTreeParser.right != null) {
                targetTreeParser.left = BinaryTree.createNode(sourceTreeParser.right.data);
                sourceTreeQueue.add(sourceTreeParser.right);
                targetTreeQueue.add(targetTreeParser.left);
            }
        }
        BinaryTree.getInOrder(targetTreeRoot);
    }

    public static void main(String[] args) {
        try {
            root = BinaryTree.createTree();
            if (root == null) {
                throw new Exception("Root not created");
            }
            BinaryTree.getInOrder(root);
            System.out.println();
            createMirrorTree(root);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}