import java.util.Arrays;

class ReverseString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new char[] { 'h', 'e', 'l', 'l', 'o' }, 0, 4)));
        System.out.println(Arrays.toString(reverse(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' }, 0, 5)));
        System.out.println(Arrays.toString(reverse(new char[] { 'H' }, 0, 0)));
    }

    static char[] reverse(char[] input, int start, int end) {
        if (start >= end)
            return input;
        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;
        return reverse(input, start + 1, end - 1);
    }
}
