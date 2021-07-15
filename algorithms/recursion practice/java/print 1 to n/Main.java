class Main {
    public static void main(String[] args) {
        print1ToN(10);
    }

    static void print1ToN(int n) {
        /**
         * Base condition;
         */
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        } else {
            print1ToN(n - 1); // Hypothesis
            System.out.print(n + " "); // Induction ((1-7) = (1-6) 7)
        }
    }
}