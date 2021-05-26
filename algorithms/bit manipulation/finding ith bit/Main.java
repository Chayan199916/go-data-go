
class Main {
    public static void main(String[] args) {
        int n = 256 + 32 + 16 + 4 + 1;
        System.out.println(findIthBit(n, 6));
    }

    static int findIthBit(int inputNum, int bitPos) {
        int mask = 1 << bitPos;
        return ((inputNum & mask) > 0) ? 1 : 0;
    }
}
