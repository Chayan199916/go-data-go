public class FlippingImage {
    public static void main(String[] args) {
        int[][] flippedImage = flipAndInvertImage(
                new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 0 } });
        for (int[] row : flippedImage) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverse(image[i]);
            invert(image[i]);
        }
        return image;
    }

    private static void reverse(int[] row) {
        int left = 0;
        int right = row.length - 1;
        int temp;
        while (left < right) {
            temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    private static void invert(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i] == 1 ? 0 : 1;
        }
    }
}

/**
 * To flip an image horizontally means that each row of the image is reversed.
 * 
 * For example, flipping [1,1,0] horizontally results in [0,1,1]. To invert an
 * image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * 
 * For example, inverting [0,1,1] results in [1,0,0].
 */