import java.util.Scanner;

/**
 * Given an array (or string), the task is to reverse the array/string. Examples
 * : Input : arr[] = {1, 2, 3} Output : arr[] = {3, 2, 1} Input : arr[] = {4, 5,
 * 1, 2} Output : arr[] = {2, 1, 5, 4}
 */

class Problem3 {
    private static int[] reverse(int inputArray[]) {
        int start = 0;
        int cpArray[] = inputArray;
        int end = cpArray.length - 1;
        int temp;
        while (start < end) {
            temp = cpArray[start];
            cpArray[start] = cpArray[end];
            cpArray[end] = temp;
            start++;
            end--;
        }
        return cpArray;
    }

    private static String reverse(String inputArray[]) {
        int start = 0;
        String cpArray[] = inputArray;
        int end = cpArray.length - 1;
        String temp;
        while (start < end) {
            temp = cpArray[start];
            cpArray[start] = cpArray[end];
            cpArray[end] = temp;
            start++;
            end--;
        }
        return String.join("", cpArray);
    }

    private static void displayIntArray(int inputArray[]) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
    }

    private static String reverse(String inputString) {
        String inputArray[] = inputString.split("");
        String reversedString = reverse(inputArray);
        return reversedString;
    }

    // private static boolean isNumber(String inputString) {
    // for (int i = 0; i < inputString.length(); i++)
    // if (Character.isDigit(inputString.charAt(i)) == false)
    // return false;

    // return true;
    // }

    public static void main(String[] args) {
        String inputString = "";
        System.out.println("Enter the input: (if array, then give the numbers with space inbetween)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            inputString = scanner.nextLine();
            String[] inputNumbers = inputString.split(" ");
            int[] numbers = new int[inputNumbers.length];
            for (int i = 0; i < inputNumbers.length; i++) {
                numbers[i] = Integer.parseInt(inputNumbers[i]);
            }
            numbers = reverse(numbers);
            displayIntArray(numbers);
        } else {
            inputString = scanner.nextLine();
            System.out.println(reverse(inputString));
        }
        scanner.close();
    }
}
