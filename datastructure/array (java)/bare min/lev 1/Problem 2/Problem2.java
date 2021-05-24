//Given an array, write functions to find the minimum and maximum elements in it. 

class Problem2 {
    private static String findMinMax(int inputArray[]) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }
        }
        return minimum + "," + maximum;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 2, 7, 6, 9, 8, 0 };
        String result = findMinMax(arr);
        String minMax[] = result.split(",");
        System.out.println(
                "minimum value : " + Integer.parseInt(minMax[0]) + " maximum value : " + Integer.parseInt(minMax[1]));
    }
}

// time complexity : O(n)