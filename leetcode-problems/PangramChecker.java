import java.util.Hashtable;

public class PangramChecker {
    public static void main(String[] args) {
        System.out.println(checkIfPangram(""));
    }

    private static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;
        Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
        for (int i = 0; i < sentence.length(); i++) {
            if (map.containsKey(sentence.charAt(i))) {
                map.put(sentence.charAt(i), map.get(sentence.charAt(i)) + 1);
            } else {
                map.put(sentence.charAt(i), 1);
            }
        }
        return map.size() >= 26;
    }

}
