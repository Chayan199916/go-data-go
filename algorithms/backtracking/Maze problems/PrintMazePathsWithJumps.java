import java.util.Scanner;

class PrintMazePathsWithJumps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.close();
        printMazePaths(1, 1, rows, cols, "");
    }

    static void printMazePaths(int currR, int currC, int desR, int desC, String path) {
        if ((currR == desR) && (currC == desC)) {
            System.out.println(path);
            return;
        }

        for (int i = 1; i <= desR - currR; i++) {
            printMazePaths(currR + i, currC, desR, desC, path + "v" + i);
        }
        for (int i = 1; i <= desC - currC; i++) {
            printMazePaths(currR, currC + i, desR, desC, path + "h" + i);
        }
        for (int i = 1; (i <= desR - currR) && (i <= desC - currC); i++) {
            printMazePaths(currR + i, currC + i, desR, desC, path + "d" + i);
        }
    }
}