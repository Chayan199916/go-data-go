import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    private static Node root = null;

    static class Node {
        int data;
        Node left;
        Node right;
    }

    private static Node createNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    private static void createTree() throws IOException {
        Queue<Node> queue = new LinkedList<Node>();
        int data;
        System.out.println("Enter the node values : (-1 for null)");
        System.out.println("Enter the root node value");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            data = Integer.parseInt(bufferedReader.readLine());
            if (data != -1) {
                root = createNode(data);
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                Node fetchedNode = queue.remove();
                System.out.println("Enter the left node of " + fetchedNode.data);
                data = Integer.parseInt(bufferedReader.readLine());
                if (data != -1) {
                    fetchedNode.left = createNode(data);
                    queue.add(fetchedNode.left);
                }
                System.out.println("Enter the right node of " + fetchedNode.data);
                data = Integer.parseInt(bufferedReader.readLine());
                if (data != -1) {
                    fetchedNode.right = createNode(data);
                    queue.add(fetchedNode.right);
                }
            }
        } catch (NumberFormatException | IOException e) {
            bufferedReader.close();
            e.printStackTrace();
        } catch (Exception e) {
            bufferedReader.close();
            e.printStackTrace();
        }
    }

    private static void createMirrorTree(Node sourceTreeRoot) {
        if (sourceTreeRoot == null) {
            return;
        }
        Queue<Node> sourceTreeQueue = new LinkedList<Node>();
        Queue<Node> targetTreeQueue = new LinkedList<Node>();
        Node targetTreeRoot = createNode(sourceTreeRoot.data);
        sourceTreeQueue.add(sourceTreeRoot);
        targetTreeQueue.add(targetTreeRoot);
        while (!sourceTreeQueue.isEmpty()) {
            Node sourceTreeParser = sourceTreeQueue.remove();
            Node targetTreeParser = targetTreeQueue.remove();
            if (sourceTreeParser.left != null) {
                targetTreeParser.right = createNode(sourceTreeParser.left.data);
                sourceTreeQueue.add(sourceTreeParser.left);
                targetTreeQueue.add(targetTreeParser.right);
            }
            if (sourceTreeParser.right != null) {
                targetTreeParser.left = createNode(sourceTreeParser.right.data);
                sourceTreeQueue.add(sourceTreeParser.right);
                targetTreeQueue.add(targetTreeParser.left);
            }
        }
        getInOrder(targetTreeRoot);
    }

    static void getInOrder() {
        getInOrder(root);
    }

    private static void getInOrder(Node node) {
        if (node != null) {
            getInOrder(node.left);
            System.out.print(node.data + " ");
            getInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        try {
            createTree();
            getInOrder();
            System.out.println();
            createMirrorTree(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}