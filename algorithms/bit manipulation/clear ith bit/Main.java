
class Main {
    public static void main(String[] args) {
        int n = 256 + 64 + 32 + 16 + 4 + 1;
        System.out.println(n + " " + clearIthBit(n, 6));
    }

    static int clearIthBit(int inputNum, int bitPos) {
        int mask = ~(1 << bitPos);
        return inputNum & mask;
    }
}
