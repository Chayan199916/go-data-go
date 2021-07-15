class Main {
    public static void main(String[] args) {
        printNTo1(7);
    }

    static void printNTo1(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }
        System.out.print(n + " "); // Induction
        printNTo1(n - 1); // hypothesis
        /**
         * (7-1) = 7 (6-1)
         */
    }
}
