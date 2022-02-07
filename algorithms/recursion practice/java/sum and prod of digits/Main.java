class Main {
    public static void main(String[] args) {
        System.out.println(sum(564738291l));
        System.out.println(prod(564738291l));
    }

    static long sum(long num) {
        if (num == 0)
            return 0;
        return (num % 10) + sum(num / 10);
    }

    static long prod(long num) {
        if (num % 10 == num)
            return num;
        return (num % 10) * prod(num / 10);
    }
}
