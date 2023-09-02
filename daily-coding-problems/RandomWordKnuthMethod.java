import java.util.Scanner;

public class RandomWordKnuthMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String champion = ""; // Initialize the champion word

        int i = 0; // Initialize the count of words read

        while (scanner.hasNext()) {
            String word = scanner.next();
            i++;

            // With probability 1/i, select the current word as the champion
            if (Math.random() < 1.0 / i) {
                champion = word;
            }
        }

        scanner.close();

        // Print the surviving champion word
        System.out.println("Surviving Champion: " + champion);
    }
}
