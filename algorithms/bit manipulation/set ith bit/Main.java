
class Main {
    public static void main(String[] args) {
        int n = 256 + 32 + 16 + 4 + 1;
        System.out.println(n + " " + setIthBit(n, 6));
    }

    static int setIthBit(int inputNum, int bitPos) {
        int mask = 1 << bitPos;
        return (inputNum | mask);
    }
}
