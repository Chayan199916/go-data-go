/**
 * Find the Missing Number Difficulty Level : Easy; You are given a list of n-1
 * integers and these integers are in the range of 1 to n. There are no
 * duplicates in the list. One of the integers is missing in the list. Write an
 * efficient code to find the missing integer. Example:
 * 
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8} Output: 5 Explanation: The missing
 * number from 1 to 8 is 5
 * 
 * Input: arr[] = {1, 2, 3, 5} Output: 4 Explanation: The missing number from 1
 * to 5 is 4
 */

class Problem2 {
    public static void main(String[] args) {
        System.out.println("The missing number : " + findMissingNumber(new int[] { 1, 2, 3, 5 }));
    }

    static int findMissingNumber(int inputArr[]) {
        int allElemXor = inputArr[0];
        int allNumbersXor = 1;
        int i;
        for (i = 1; i < inputArr.length; i++) {
            allElemXor ^= inputArr[i];
        }
        for (i = 2; i <= inputArr.length + 1; i++) {
            allNumbersXor ^= i;
        }
        return allNumbersXor ^ allElemXor;
    }
}

/**
 * Imp xor properties : 1. a ^ a = 0 2. a ^ 0 = a
 * 
 * here, 1 to 4 range, xor = 1 ^ 2 ^ 3 ^ 4; let's say missing elem in array = 3;
 * then xor of all elements of array = 1 ^ 2 ^ 4; so 1 ^ 1 ^ 2 ^ 2 ^ 3 ^ 4 ^ 4 =
 * 3;
 */