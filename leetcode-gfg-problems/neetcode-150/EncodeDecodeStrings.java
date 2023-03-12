import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    public static String encode(String[] inputs) {
        String encodedString = "";
        for (String input : inputs) {
            encodedString += input.length() + "#" + input;
        }
        return encodedString;
    }

    public static List<String> decode(String encodedString) {
        List<String> decodedList = new ArrayList<String>();
        int i = 0;
        while (i < encodedString.length()) {
            int j = i;
            int lengthOfWord = 0;
            while (encodedString.charAt(j) != '#') {
                j++;
            }
            lengthOfWord = Integer.parseInt(encodedString.substring(i, j));
            String word = encodedString.substring(j + 1, j + 1 + lengthOfWord);
            decodedList.add(word);
            i = j + 1 + lengthOfWord;
        }
        return decodedList;
    }

    public static void main(String[] args) {
        String encoded = encode(new String[] { "He#llo#", "W#orl#d#", "####", "#By#e#", "#W#o#r#l#d#" });
        System.out.println(encoded);
        List<String> decodedList = decode(encoded);
        for (String decoded : decodedList) {
            System.out.println(decoded);
        }
    }
}
