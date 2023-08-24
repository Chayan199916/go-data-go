import java.util.*;
import java.io.*;

public class Day_2_CodingNinja {
    public static int findRowK(int[][] mat) {
        // Write your code here.
        // Write your code here.
        int n = mat.length;

        // Step 1: Check for rows with all 0s
        int rowWithAllZeros = -1;
        for (int i = 0; i < n; i++) {
            boolean allZeros = true;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0 && j != i) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) {
                rowWithAllZeros = i;
                break;
            }
        }

        if (rowWithAllZeros == -1) {
            return rowWithAllZeros; // No such k exists
        }

        // Step 2: Check for columns with all 1s
        int columnWithAllOnes = -1;
        for (int j = 0; j < n; j++) {
            boolean allOnes = true;
            for (int i = 0; i < n; i++) {
                if (mat[i][j] != 1 && i != j) {
                    allOnes = false;
                    break;
                }
            }
            if (allOnes) {
                columnWithAllOnes = j;
                break;
            }
        }

        if (columnWithAllOnes == -1) {
            return columnWithAllOnes; // No such k exists
        }

        // Step 3: Find intersection of rows with all 0s and columns with all 1s
        if (rowWithAllZeros == columnWithAllOnes) {
            return rowWithAllZeros;
        } else {
            return -1; // Invalid input condition, as it contradicts the problem
        }
    }

    public static void main(String[] args) {
        System.out.println(findRowK(new int[][] { { 0, 1, 1 }, { 0, 1, 0 }, { 1, 1, 0 } }));
    }
}