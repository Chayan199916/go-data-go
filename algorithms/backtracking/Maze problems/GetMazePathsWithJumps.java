import java.util.ArrayList;
import java.util.Scanner;

class GetMazePathsWIthJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        ArrayList<String> mazePaths = getMazePathsWithJumps(1, 1, n, m);
        System.out.println(mazePaths);

    }

    static ArrayList<String> getMazePathsWithJumps(int srR, int srC, int desR, int desC) {
        if (srR == desR && srC == desC) {
            ArrayList<String> bPath = new ArrayList<>();
            bPath.add("");
            return bPath;
        }
        ArrayList<String> paths = new ArrayList<>();
        // vertical jumps
        for (int i = 1; i <= desR - srR; i++) {
            ArrayList<String> vPaths = getMazePathsWithJumps(srR + i, srC, desR, desC);
            for (String vPath : vPaths) {
                paths.add("v" + i + vPath);
            }
        }
        // horizontal jumps
        for (int i = 1; i <= desC - srC; i++) {
            ArrayList<String> hPaths = getMazePathsWithJumps(srR, srC + i, desR, desC);
            for (String hPath : hPaths) {
                paths.add("h" + i + hPath);
            }
        }
        // diagonal jumps
        for (int i = 1; (i <= desR - srR) && (i <= desC - srC); i++) {
            ArrayList<String> dPaths = getMazePathsWithJumps(srR + i, srC + i, desR, desC);
            for (String dPath : dPaths) {
                paths.add("d" + i + dPath);
            }
        }
        return paths;
    }
}