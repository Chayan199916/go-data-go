import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // System.out.println(countPaths(3, 3));
        // showPaths(5, 5, "");
        // System.out.println(showPathsRet(3, 3, ""));
        showPathsExtended(3, 3, "");
    }

    /**
     * Only down and right movements are allowed
     * 
     * @param row
     * @param col
     * @return
     */
    static int countPaths(int row, int col) {
        if (row == 1 || col == 1)
            return 1;
        int count = 0;
        count += countPaths(row - 1, col);
        count += countPaths(row, col - 1);
        return count;
    }

    static void showPaths(int row, int col, String output) {
        if (row == 1) {
            for (int i = 0; i < col - 1; i++) {
                output += "R";
            }
            System.out.println(output);
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row - 1; i++) {
                output += "D";
            }
            System.out.println(output);
            return;
        }
        showPaths(row - 1, col, output + "D");
        showPaths(row, col - 1, output + "R");
    }

    static ArrayList<String> showPathsRet(int row, int col, String output) {
        if (row == 1) {
            ArrayList<String> indiv = new ArrayList<String>();
            for (int i = 0; i < col - 1; i++) {
                output += "R";
            }
            indiv.add(output);
            return indiv;
        }
        if (col == 1) {
            ArrayList<String> indiv = new ArrayList<String>();
            for (int i = 0; i < row - 1; i++) {
                output += "D";
            }
            indiv.add(output);
            return indiv;
        }
        ArrayList<String> result = new ArrayList<String>();
        result.addAll(showPathsRet(row - 1, col, output + "D"));
        result.addAll(showPathsRet(row, col - 1, output + "R"));
        return result;
    }

    /**
     * Down, Right and Diagonal movements are allowed.
     */
    static void showPathsExtended(int row, int col, String output) {
        if (row == 1) {
            for (int i = 0; i < col - 1; i++) {
                output += "R";
            }
            System.out.println(output);
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row - 1; i++) {
                output += "D";
            }
            System.out.println(output);
            return;
        }
        showPathsExtended(row, col - 1, output + "R");
        showPathsExtended(row - 1, col - 1, output + "A");
        showPathsExtended(row - 1, col, output + "D");
    }
}