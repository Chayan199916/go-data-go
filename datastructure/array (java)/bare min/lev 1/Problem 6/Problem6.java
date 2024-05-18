import java.util.Random;

class Problem6 {
    public static void main(String[] args) {
        int arr[] = { 335, 501, 170, 725, 479, 359, 963, 465, 706, 146, 282, 828, 962, 492, 996, 943, 828, 437, 392,
                605, 903, 154, 293, 383, 422, 717, 719, 896, 448, 727, 772, 539, 870, 913, 668, 300, 36, 895, 704, 812,
                323, 334 };
        int k = 11; // Change this to the desired 'k' value for testing
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
        // k = 10; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        // k = 15; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        // k = 20; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        k = 16; // Change this to the desired 'k' value for testing
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
        k = 7; // Change this to the desired 'k' value for testing
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
        k = 1; // Change this to the desired 'k' value for testing
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
        // k = 17; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        // k = 27; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        // k = 35; // Change this to the desired 'k' value for testing
        // System.out.println(findKLargestSmallestElements(arr, 0, arr.length - 1, k));
        k = 41; // Change this to the desired 'k' value for testing
        findKLargestSmallestElements(arr, 0, arr.length - 1, k);
    }

    static void findKLargestSmallestElements(int inputArr[], int start, int end, int k) {
        Random rand = new Random(0);
        int n = inputArr.length;

        while (start <= end) {
            int choosenPivotIndex = rand.nextInt(end - start + 1) + start;

            int finalIndexOfChoosenPivot = partition(inputArr, start, end, choosenPivotIndex);

            // What does the 'finalIndexOfChoosenPivot' tell us?
            if (finalIndexOfChoosenPivot == n - k) {
                /*
                 * Found. The pivot is index on index n - k. This is literally its final
                 * position if the array we were given had been sorted. See how we saved work?
                 * We don't need to sort the whole array
                 */
                // return inputArr[finalIndexOfChoosenPivot];
                System.out.println();
                System.out.println("Smallest k elements : ");
                for (int i = 0; i < finalIndexOfChoosenPivot; i++) {
                    System.out.print(inputArr[i] + " ");
                }
                System.out.println();
                System.out.println("Largest k elements : ");
                for (int i = n - k; i < n; i++) {
                    System.out.print(inputArr[i] + " ");
                }
                return;
            } else if (finalIndexOfChoosenPivot > n - k) {
                /*
                 * k'th largest must be in the left partition. We "overshot" and need to go left
                 * (and we do this by narrowing the right bound)
                 */
                end = finalIndexOfChoosenPivot - 1;
            } else {
                /*
                 * finalIndexOfChoosenPivot < n - k
                 * 
                 * k'th largest must be in the right partition. We "undershot" and need to go
                 * right (and we do this by narrowing the left bound)
                 */
                start = finalIndexOfChoosenPivot + 1;
            }
        }
    }

    static int partition(int inputArr[], int start, int end, int pivotIndex) {
        int pivotValue = inputArr[pivotIndex];
        int lesserItemsTailIndex = start;

        /*
         * Move the item at the 'pivotIndex' OUT OF THE WAY. We are about to bulldoze
         * through the partitioning space and we don't want it in the way
         */
        swapTwoNumbers(inputArr, pivotIndex, end);

        for (int i = start; i < end; i++) {
            if (inputArr[i] < pivotValue) {
                swapTwoNumbers(inputArr, i, lesserItemsTailIndex);
                lesserItemsTailIndex++;
            }
        }

        /*
         * Ok...partitioning is done. swap the pivot item BACK into the space we just
         * partitioned at the 'lesserItemsTailIndex'...that's where the pivot item
         * belongs
         * 
         * In the middle of the "sandwich".
         */
        swapTwoNumbers(inputArr, end, lesserItemsTailIndex);

        return lesserItemsTailIndex;
    }

    static void swapTwoNumbers(int inputArr[], int first, int second) {
        int temp = inputArr[first];
        inputArr[first] = inputArr[second];
        inputArr[second] = temp;
    }
}
