class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(0);
        int firstPoll = 1;
        int secondPoll = 2;
        int thirdPoll = 3;
        toh(4, firstPoll, thirdPoll, secondPoll, counter);
        System.out.println("Total no of movements: " + counter.getValue());
    }

    static void toh(int noOfDisks, int src, int dest, int aux, Counter counter) {
        counter.increment();
        if (noOfDisks == 1) {
            System.out.println("Move disk " + "from " + src + " to " + dest + " using auxilliary disk as " + aux);
            return;
        }
        toh(noOfDisks - 1, src, aux, dest, counter);
        System.out.println("Move disk " + "from " + src + " to " + dest + " using auxilliary disk as " + aux);
        toh(noOfDisks - 1, aux, dest, src, counter);
    }
}

class Counter {
    private int value;

    Counter(int value) {
        this.value = value;
    }

    public void increment() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}
