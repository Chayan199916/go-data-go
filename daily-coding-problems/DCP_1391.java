/**
 * This problem was asked by Square.
 * 
 * Assume you have access to a function toss_biased() which returns 0 or 1 with
 * a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know
 * the bias of the coin.
 * 
 * Write a function to simulate an unbiased coin toss.
 * 
 * 
 */
public class DCP_1391 {

    // biased coin toss function
    public static int toss_biased() {
        // implement your biased coin toss function here
        // return either 0 or 1 with a probability that's not 50-50
        double bias = 0.6;
        if (Math.random() < bias)
            return 1;
        else
            return 0;
    }

    // unbiased coin toss function
    public static int toss_unbiased() {
        int r1, r2;
        do {
            r1 = toss_biased();
            r2 = toss_biased();
        } while (r1 == r2);
        return r1;
    }

    // example usage
    public static void main(String[] args) {
        int result = toss_unbiased();
        System.out.println("Unbiased coin toss result: " + result);
    }
}
