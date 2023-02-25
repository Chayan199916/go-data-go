// Java implementation of search and insert operations
// on Trie
public class Main {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 52;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = Character.isUpperCase(key.charAt(level)) ? key.charAt(level) - 'A' : key.charAt(level) - 'a' + 26;
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = Character.isUpperCase(key.charAt(level)) ? key.charAt(level) - 'A' : key.charAt(level) - 'a' + 26;

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }

    // Driver
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = { "Ahe", "ahe", "The", "Their", "these", "Thesis", "thesis" };

        String output[] = { "Not present in trie", "Present in trie" };

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("Ahe") == true)
            System.out.println("Ahe --- " + output[1]);
        else
            System.out.println("Ahe --- " + output[0]);

        if (search("ahe") == true)
            System.out.println("ahe --- " + output[1]);
        else
            System.out.println("ahe --- " + output[0]);
        if (search("The") == true)
            System.out.println("The --- " + output[1]);
        else
            System.out.println("The --- " + output[0]);

        if (search("Their") == true)
            System.out.println("Their --- " + output[1]);
        else
            System.out.println("Their --- " + output[0]);
        if (search("these") == true)
            System.out.println("these --- " + output[1]);
        else
            System.out.println("these --- " + output[0]);

        if (search("Thesis") == true)
            System.out.println("Thesis --- " + output[1]);
        else
            System.out.println("Thesis --- " + output[0]);
        if (search("Thesisi") == true)
            System.out.println("Thesisi --- " + output[1]);
        else
            System.out.println("Thesisi --- " + output[0]);
        if (search("banana") == true)
            System.out.println("banana --- " + output[1]);
        else
            System.out.println("banana --- " + output[0]);
        if (search("Thes") == true)
            System.out.println("Thes --- " + output[1]);
        else
            System.out.println("Thes --- " + output[0]);

    }
}