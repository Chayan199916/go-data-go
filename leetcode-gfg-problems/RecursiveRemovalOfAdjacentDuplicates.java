class RecursiveRemovalOfAdjacentDuplicates {
    public static void main(String[] args) {
        // System.out.println(remove("azxxzy", 0, "", false));
        // System.out.println(remove("geeksforgeeg", 0, "", false));
        // System.out.println(remove("caaabbbaacdddd", 0, "", false));
        // System.out.println(remove("acaaabbbacdddd", 0, "", false));
        // System.out.println(remove("aaaadddd", 0, "", false));
        // System.out.println(remove("caaabbbc", 0, "", false));
        // System.out.println(remove("ddd", 0, "", false));
        // System.out.println(remove("dd", 0, "", false));
        // System.out.println(remove("da", 0, "", false));
        System.out.println("eeavkpppkkfwwxzzzfnnnuiahxdrzlppppgxswlltttohdelcqqqdyymmtssclddaaabqeknggaxig");
        System.out.println(
                remove("eeavkpppkkfwwxzzzfnnnuiahxdrzlppppgxswlltttohdelcqqqdyymmtssclddaaabqeknggaxig", 0, "", false));
    }

    static String remove(String input, int index, String output, boolean isRemoved) {
        char lastRemoved = '\u0000';
        if (input.length() == 0)
            return output;
        else if (input.length() == 1)
            return input.charAt(0) + "";
        while (index + 1 < input.length()) {
            if (input.charAt(index) != input.charAt(index + 1)) {
                lastRemoved = '\u0000';
                output += input.charAt(index);
                index++;
            } else {
                lastRemoved = input.charAt(index);
                while (index + 1 < input.length() && input.charAt(index) == input.charAt(index + 1)) {
                    index++;
                }
                index++;
                isRemoved = true;
            }
        }
        if (input.charAt(input.length() - 1) != lastRemoved)
            output += input.charAt(input.length() - 1);
        if (isRemoved) {
            System.out.println(output);
            return remove(output, 0, "", false);
        } else {
            return output;
        }
    }
}