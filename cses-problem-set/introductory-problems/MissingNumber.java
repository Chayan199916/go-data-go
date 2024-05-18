import java.util.HashSet;
import java.util.Scanner;

public class MissingNumber {
    public static long getMissingNumber(HashSet<Long> inputNumbers) {
        long totalCount = inputNumbers.size() + 1;
        long missingNum = 0;
        for (long i = 1; i <= totalCount; i++) {
            missingNum ^= i;
        }
        for (long num : inputNumbers) {
            missingNum ^= num;
        }
        return missingNum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextLong();
            HashSet<Long> inputNumbers = new HashSet<>();
            for (long i = 0; i < n - 1; i++) {
                inputNumbers.add(scanner.nextLong());
            }
            System.out.println(getMissingNumber(inputNumbers));
        }
    }
}
