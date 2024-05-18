import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> find_permutation(String S) {
        Set<String> permutations = findPermutationRecursive(S, 0);
        List<String> res = new ArrayList<>(permutations);
        Collections.sort(res);
        return res;
    }

    private Set<String> findPermutationRecursive(String S, int currIndex) {
        if (currIndex == S.length()) {
            Set<String> bRes = new HashSet<>();
            bRes.add("");
            return bRes;
        }

        Set<String> res = new HashSet<>();
        char ch = S.charAt(currIndex);
        String remainingString = S.substring(0, currIndex) + S.substring(currIndex + 1);

        Set<String> temp = findPermutationRecursive(remainingString, 0); // Start from index 0 for each recursive call

        for (String perm : temp) {
            for (int i = 0; i <= perm.length(); i++) {
                res.add(perm.substring(0, i) + ch + perm.substring(i));
            }
        }

        return res;
    }
}