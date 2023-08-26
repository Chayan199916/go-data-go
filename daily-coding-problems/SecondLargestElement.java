public class SecondLargestElement {
    /**
     * 
     * think of it like a stream of numbers coming in.once a new number comes,
     * compare it with the largest number till now.
     * now there are 3 scenarios :
     * 1. new number > largest number till now -> update new number as the largest
     * and largest number till now as the second largest number
     * 2. new number = largest number -> we can ignore as nothing will change;
     * second largest number till now will remain the same.
     * 3. new number < largest number -> there are 3 scenarios
     * 3.1 no second largest number till now -> new number becomes the second
     * largest number
     * 3.2 new number < or = second largest number till now -> we can ignore as
     * nothing will change; second largest number till now will remain the same.
     * 3.3 new number > second largest number till now -> second largest number till
     * now will get updated.
     */
    public static int getSecondLargest(int[] numbers) {
        int secondLargest = -1;
        int largest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                secondLargest = largest;
                largest = numbers[i];
            } else if (numbers[i] < largest) {
                if (secondLargest == -1 || numbers[i] > secondLargest) {
                    secondLargest = numbers[i];
                }
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        System.out.println(getSecondLargest(new int[] { 10, 9, 10, 8, 6, 3, 7, 1 }));
        System.out.println(getSecondLargest(new int[] { 10, 10, 10 }));
        ;
        System.out.println(getSecondLargest(new int[] { 5, 20, 12, 20, 8 }));
        ;
    }
}
