/**
 * Union and Intersection of two sorted arrays Difficulty Level : Easy; Given
 * two sorted arrays, find their union and intersection. Example:
 * 
 * Input : arr1[] = {1, 3, 4, 5, 7} arr2[] = {2, 3, 5, 6} Output : Union : {1,
 * 2, 3, 4, 5, 6, 7} Intersection : {3, 5}
 * 
 * Input : arr1[] = {2, 5, 6} arr2[] = {4, 6, 8, 10} Output : Union : {2, 4, 5,
 * 6, 8, 10} Intersection : {6}
 */

class Problem12 {
    public static void main(String[] args) {
        findUnionIntersection(new int[] { 2, 5, 6 }, new int[] { 4, 6, 8, 10 });
    }

    static void findUnionIntersection(int inputArr1[], int inputArr2[]) {
        int unionResult[] = new int[inputArr1.length + inputArr2.length];
        int intersectionResult[] = new int[Math.max(inputArr1.length, inputArr2.length)];
        int unionIndex = 0;
        int intersectionIndex = 0;
        int i, j;
        for (i = 0, j = 0; i < inputArr1.length && j < inputArr2.length;) {
            if (inputArr1[i] < inputArr2[j]) {
                unionResult[unionIndex++] = inputArr1[i++];
            } else if (inputArr1[i] > inputArr2[j]) {
                unionResult[unionIndex++] = inputArr2[j++];
            } else {
                unionResult[unionIndex++] = inputArr1[i];
                intersectionResult[intersectionIndex++] = inputArr1[i];
                i++;
                j++;
            }
        }
        while (i < inputArr1.length) {
            unionResult[unionIndex++] = inputArr1[i++];
        }
        while (j < inputArr2.length) {
            unionResult[unionIndex++] = inputArr2[j++];
        }
        System.out.println("Result after union : ");
        for (i = 0; i < unionIndex; i++) {
            System.out.print(unionResult[i] + " ");
        }
        System.out.println();
        System.out.println("Result after intersection : ");
        for (i = 0; i < intersectionIndex; i++) {
            System.out.print(intersectionResult[i] + " ");
        }
        System.out.println();
    }
}
