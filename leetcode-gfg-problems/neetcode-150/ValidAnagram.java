import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */
public class ValidAnagram {
    public static boolean isAnagram(String src, String dest) {
        HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
        if (src.length() != dest.length()) {
            return false;
        }
        for (String ch : src.split("")) {
            if (frequencies.containsKey(ch)) {
                frequencies.put(ch, frequencies.get(ch) + 1);
            } else {
                frequencies.put(ch, 1);
            }
        }
        for (String ch : dest.split("")) {
            if (!frequencies.containsKey(ch)) {
                return false;
            }
            frequencies.put(ch, frequencies.get(ch) - 1);
        }
        for (String key : frequencies.keySet()) {
            if (frequencies.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
