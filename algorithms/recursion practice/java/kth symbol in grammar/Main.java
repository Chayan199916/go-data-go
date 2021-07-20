class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= (int) Math.pow(2, i - 1); j++) {
                System.out.print(kThSymbolInGrammar(i, j) + " ");
            }
            System.out.println();
        }
    }

    static int kThSymbolInGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }
        int mid = (int) (Math.pow(2, n - 1) / 2);
        if (k <= mid) {
            return kThSymbolInGrammar(n - 1, k);
        } else {
            return kThSymbolInGrammar(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}
