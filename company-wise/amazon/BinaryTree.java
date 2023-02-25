import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private static Node root = null;

    static class Node {
        int data;
        Node left;
        Node right;
    }

    static Node createNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;
        return node;
    }

    public static Node createTree() throws IOException {
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
            return root;
        } catch (NumberFormatException | IOException e) {
            bufferedReader.close();
            e.printStackTrace();
        } catch (Exception e) {
            bufferedReader.close();
            e.printStackTrace();
        }
        return null;
    }

    static void getInOrder() {
        getInOrder(root);
    }

    static void getInOrder(Node node) {
        if (node != null) {
            getInOrder(node.left);
            System.out.print(node.data + " ");
            getInOrder(node.right);
        }
    }
}
