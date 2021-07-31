import java.util.ArrayList;

public class PrettyPattern {
    static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int end = a + (a - 1);
        int left = 0;
        int right = end - 1;
        int count = 0;
        int aCp;
        for (int i = 0; i <= (end - 1) / 2; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            aCp = a;
            for (int j = 0; j < left; j++) {
                row.add(aCp--);
            }
            for (int j = left; j <= right; j++) {
                row.add(a - count);
            }
            aCp = a - count;
            for (int j = right + 1; j < end; j++) {
                row.add(++aCp);
            }
            count++;
            left++;
            right--;
            list.add(row);
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            ArrayList<Integer> row = list.get(i);
            list.add(row);
        }
        return list;
    }

    static void display(ArrayList<ArrayList<Integer>> list) {
        for (ArrayList<Integer> row : list) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = prettyPrint(4);
        display(list);
    }
}
