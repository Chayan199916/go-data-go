class OddEvenChecker {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(checkEvenOdd(i));
        }
    }

    static boolean checkEvenOdd(int inputNum) {
        if ((inputNum & 1) == 0) {
            return true;
        }
        return false;
    }
}