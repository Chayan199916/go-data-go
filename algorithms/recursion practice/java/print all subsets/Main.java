class Main {
    public static void main(String[] args) {
        printSubsets("", "abcd");
    }

    static void printSubsets(String op, String ip) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        printSubsets(op, ip.substring(1));
        printSubsets(op + ip.charAt(0), ip.substring(1));
    }
}
/**
 * Here we'll follow i/p - o/p method to get the power set. so the approach goes
 * like this : We start with op = "" and ip = "ab" (given string) now from this
 * we have two choices 1. to include a 2. to discard a. based on that we'll get
 * two branches one for taking the choice and other one for not taking the
 * choice and accordingly both ip and op changes. at the leaf nodes, we get ip
 * as empty string and all leaf nodes givee all subsets of the given string.
 */
