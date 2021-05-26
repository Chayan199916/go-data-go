
class Main {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        System.out.println("Before swapping : " + a + " " + b);
        int result[] = swapTwoNumbers(a, b);
        System.out.println("After swapping : " + result[0] + " " + result[1]);
    }

    static int[] swapTwoNumbers(int first, int second) {
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;
        return new int[] { first, second };
    }
}
