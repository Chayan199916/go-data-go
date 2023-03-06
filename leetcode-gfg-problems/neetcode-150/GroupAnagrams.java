import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */
public class GroupAnagrams {
    public static void groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Map<String, Integer>> freqMapList = new ArrayList<Map<String, Integer>>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            createFreqencies(map, strs[i]);
            freqMapList.add(map);
        }
    }

    public static void createFreqencies(HashMap<String, Integer> frequencies, String src) {
        for (String ch : src.split("")) {
            if (frequencies.containsKey(ch)) {
                frequencies.put(ch, frequencies.get(ch) + 1);
            } else {
                frequencies.put(ch, 1);
            }
        }
    }

    // public List<List<String>> checkGroupAnagrams(List<Map<String, Integer>>
    // frequencies, String str) {
    // List<Map<String, Integer>> freqCp = frequencies;

    // return result;
    // }
    public static void main(String[] args) {
        groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
    }
}
