import java.util.ArrayList;
import java.util.Arrays;

class SubsetSubseq {
    public static void main(String[] args) {
        // subseq("abc", "");
        // System.out.println(_subseqIterative(new int[] { 1, 2, 3 }));
        System.out.println(_subseqPreventDuplicatesIterative(new int[] { 2, 2, 2 }));
    }

    static void subseq(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        subseq(input.substring(1), output);
        subseq(input.substring(1), output + ch);
    }

    static ArrayList<String> _subseq(String input, String output) {
        if (input.isEmpty()) {
            ArrayList<String> result = new ArrayList<String>();
            result.add(output);
            return result;
        }
        char ch = input.charAt(0);
        ArrayList<String> left = _subseq(input.substring(1), output);
        ArrayList<String> right = _subseq(input.substring(1), output + ch);
        left.addAll(right);
        return left;
    }

    static ArrayList<String> _subseqIterative(String input) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        for (int i = 0; i < input.length(); i++) {
            ArrayList<String> temp = new ArrayList<String>();
            for (String element : result) {
                temp.add(element + input.charAt(i));
            }
            result.addAll(temp);
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> _subseqIterative(int numbers[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < numbers.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(numbers[i]);
                result.add(temp);
            }
        }
        return result;
    }

    static ArrayList<ArrayList<Integer>> _subseqPreventDuplicatesIterative(int numbers[]) {
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < numbers.length; i++) {
            start = 0;
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                start = end + 1;
            }
            end = result.size() - 1;
            for (int j = start; j <= end; j++) {
                ArrayList<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(numbers[i]);
                result.add(temp);
            }
        }
        return result;
    }
}