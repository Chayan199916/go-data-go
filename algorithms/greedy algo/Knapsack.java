import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        System.out
                .println(getMaxProfit(new float[] { 10, 5, 15, 7, 6, 18, 3 }, new float[] { 2, 3, 5, 7, 1, 4, 1 }, 15));
    }

    public static float getMaxProfit(float[] profits, float[] weights, float maxWeight) {
        float maxProfit = 0.0f;
        List<List<Float>> profitWeightVsWeightVsProfitList = new ArrayList<>();

        for (int i = 0; i < profits.length; i++) {
            List<Float> profitWeight = new ArrayList<>();
            profitWeight.add(profits[i] / weights[i]);
            profitWeight.add(weights[i]);
            profitWeight.add(profits[i]);
            profitWeightVsWeightVsProfitList.add(profitWeight);
        }

        // Sort the list based on the first element of each inner list
        Collections.sort(profitWeightVsWeightVsProfitList, new Comparator<List<Float>>() {
            @Override
            public int compare(List<Float> list1, List<Float> list2) {
                Float element1 = list1.get(0);
                Float element2 = list2.get(0);
                return element2.compareTo(element1);
            }
        });
        for (List<Float> profitWeightVsWeightVsProfit : profitWeightVsWeightVsProfitList) {
            float currentWeight = profitWeightVsWeightVsProfit.get(1);
            if (currentWeight <= maxWeight) {
                maxWeight -= currentWeight;
                maxProfit += profitWeightVsWeightVsProfit.get(2);
            } else {
                maxProfit += profitWeightVsWeightVsProfit.get(2) * (maxWeight / currentWeight);
                break;
            }
        }
        return maxProfit;
    }
}
