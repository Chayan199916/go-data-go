import java.util.ArrayList;

public class GetSubsequence {
    public static void main(String[] args) {
        getsubseq("abc", "");
    }

    public static ArrayList<String> getsubseq(String ip) {
        if (ip.isEmpty()) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char ch = ip.charAt(0);
        ArrayList<String> ros = getsubseq(ip.substring(1));
        ArrayList<String> res = new ArrayList<>();
        for (String seq : ros) {
            res.add("" + seq);
        }
        for (String seq : ros) {
            res.add(ch + seq);
        }
        return res;
    }

    public static void getsubseq(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }
        char ch = ip.charAt(0);
        String remainingString = ip.substring(1);
        getsubseq(remainingString, op);
        getsubseq(remainingString, op + ch);
    }
}
