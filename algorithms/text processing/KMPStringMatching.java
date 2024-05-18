import java.util.ArrayList;
import java.util.Arrays;

public class KMPStringMatching {
    public static void main(String[] args) {
        // System.out.println(search("aba", "abaabcabacabaacba"));
        String pat = "geek";
        String text = "geeksforgeeks";
        String total = pat + "$" + text;
        int[] lps = computeLPSArray(total);
        System.out.println(Arrays.toString(lps));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == pat.length()) {
                result.add(i - 2 * pat.length() + 1);
            }
        }
        System.out.println(result);
    }

    // static ArrayList<Integer> search(String pat, String txt) {
    // // your code here
    // ArrayList<Integer> result = new ArrayList<>();
    // int[] lps = computeLPSArray(pat);
    // int i = 0; // index for text
    // int j = 0; // index for pattern
    // int txtLen = txt.length();
    // int patLen = pat.length();

    // while (i < txtLen) {
    // if (pat.charAt(j) == txt.charAt(i)) {
    // i++;
    // j++;
    // } else {
    // if (j != 0) {
    // j = lps[j - 1];
    // } else {
    // i++;
    // }
    // }
    // if (j == patLen) {
    // result.add(i - j + 1);
    // j = lps[j - 1];
    // }
    // }
    // return result;
    // }

    static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;

        for (int i = 1; i < pattern.length();) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
/*
 * LPS : length of longest proper prefix which is also a proper suffix
 * ex : aabc
 * prefix :
 * a
 * aa
 * aab
 * aabc
 * suffix :
 * c
 * bc
 * abc
 * aabc
 * now except the entire string, all are proper prefix and suffix
 */