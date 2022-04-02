import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateTargetArrayInGivenOrder {
    public static void main(String[] args) {
        int[] result = createTargetArray(new int[] { 4, 2, 4, 3, 2 }, new int[] { 0, 0, 1, 3, 1 });
        System.out.println(Arrays.toString(result));
    }

    private static int[] createTargetArray(int[] nums, int[] index) {
        // 1. Create an arraylist of type Integer
        List<Integer> list = new ArrayList<>();
        // 2. Using ArrayList.add() so that we don't have to manually reorder array
        // elements on each add operation.
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] array = new int[list.size()];
        // 3. Fill the array with the elements in our ArrayList
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
