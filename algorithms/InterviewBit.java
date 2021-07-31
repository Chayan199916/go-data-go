import java.util.ArrayList;
import java.util.Arrays;

public class InterviewBit {
    static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (A.size() <= 1 || B <= 0)
            return A;
        if (B >= A.size()) {
            B = B % A.size();
        }
        for (int i = 0; i < A.size() - B; i++) {
            ret.add(A.get(i + B));
        }
        for (int i = 0; i < B; i++) {
            ret.add(A.get(i));
        }
        return ret;
    }

    static void display(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = rotateArray(
                new ArrayList<Integer>(Arrays.asList(44, 41, 12, 42, 71, 45, 28, 65, 75, 93, 66, 66, 37, 6, 24, 59)),
                18);
        display(list);
    }
}