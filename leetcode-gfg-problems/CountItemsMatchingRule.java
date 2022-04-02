import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CountItemsMatchingRule {
    public static void main(String[] args) {
        List<String> row1 = Arrays.asList("phone", "blue", "pixel");
        List<String> row2 = Arrays.asList("phone", "blue", "pixel");
        List<String> row3 = Arrays.asList("phone", "blue", "pixel");
        List<List<String>> items = new ArrayList<List<String>>();
        items.add(row1);
        items.add(row2);
        items.add(row3);
        countMatches(items, "type", "phone");
    }

    private static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (item.get(0).equals(ruleValue)) {
                    count++;
                }
            } else if (ruleKey.equals("color")) {
                if (item.get(1).equals(ruleValue)) {
                    count++;
                }
            } else if (ruleKey.equals("name")) {
                if (item.get(2).equals(ruleValue)) {
                    count++;
                }
            }
        }
        return count;
        /**
         * int index = -1, count =0; switch(ruleKey){ case "type" : index = 0; break;
         * case "color" : index = 1; break; case "name" : index = 2; break; } if(index
         * != -1) { for (List<String> item : items) { if
         * (item.get(index).equals(ruleValue)) count += 1; } } return count;
         */
    }
}
