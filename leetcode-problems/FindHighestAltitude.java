public class FindHighestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
    }

    private static int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int altitude = 0;
        for (int g : gain) {
            altitude += g;
            if (altitude > highestAltitude) {
                highestAltitude = altitude;
            }
        }
        return highestAltitude;
    }
}
