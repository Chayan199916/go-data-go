class DiceThrow {
    public static void main(String[] args) {
        // getResult("", 4);
        int numberOfDices = 2;
        int faces = 6;
        int target = 7;
        System.out.println(getResultGen("", numberOfDices, faces, target));
    }

    static void getResult(String output, int target) {
        if (target == 0) {
            System.out.println(output);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            getResult(output + i, target - i);
        }
    }

    /**
     * 
     * @param output
     * @param numberOfDices
     * @param faces
     * @param target
     * @return
     */
    /**
     * This is a dynamic programming problem. will return time limit exceeded for
     * larger values.
     */
    static int getResultGen(String output, int numberOfDices, int faces, int target) {
        if (target == 0 && output.length() == numberOfDices) {
            return 1;
        }
        int count = 0;
        int M = 1000000007;
        for (int i = 1; i <= faces && i <= target; i++) {
            count = count + getResultGen(output + i, numberOfDices, faces, target - i);
        }
        return count % M;
    }
}
