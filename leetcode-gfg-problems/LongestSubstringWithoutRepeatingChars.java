public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(calcLength("abcabcbb"));
        System.out.println(calcLength("pwwkew"));
        System.out.println(calcLength("bbbbb"));
        System.out.println(calcLength(""));
        System.out.println(calcLength("pwwkewllmn"));
    }

    static int calcLength(String input) {
        if (input.length() <= 1)
            return input.length();
        int left = 0;
        int right = 1;
        int maxLength = 1;
        while (right < input.length()) {
            String currentSlice = input.substring(left, right);
            String charToBeSearched = input.charAt(right) + "";
            int indexOfRepeatedChar = currentSlice.indexOf(charToBeSearched);
            // System.out.println(
            // left + " " + right + " " + currentSlice + " " + charToBeSearched + " " +
            // indexOfRepeatedChar);
            if (indexOfRepeatedChar == -1) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left += indexOfRepeatedChar + 1;
            }
            right += 1;
        }
        return maxLength;
    }
}
