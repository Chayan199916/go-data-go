import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {

    static class HuffmanNode {
        char data;
        int frequency;
        HuffmanNode left, right;

        public HuffmanNode(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        String inputString = "ABRACADABRA";

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // PriorityQueue<HuffmanNode> priorityQueue = new
        // PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(
                (node1, node2) -> node1.frequency - node2.frequency);

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            priorityQueue.offer(newNode);
        }

        HuffmanNode root = priorityQueue.peek();
        printHuffmanCodes(root, "");
    }

    public static void printHuffmanCodes(HuffmanNode root, String code) {
        if (root == null) {
            return;
        }

        if (root.data != '\0') {
            System.out.println(root.data + ": " + code);
        }

        printHuffmanCodes(root.left, code + "0");
        printHuffmanCodes(root.right, code + "1");
    }
}
