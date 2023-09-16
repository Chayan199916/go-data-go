import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {
    public static void main(String[] args) {
        System.out.println(getJobSequence(new int[] { 1, 2, 3, 4, 5 }, new int[] { 20, 15, 10, 5, 1 },
                new int[] { 2, 2, 1, 3, 3 }, new int[] { 1, 2, 1, 3, 2 }));
        System.out.println(getJobSequence(new int[] { 1, 2, 3, 4 }, new int[] { 50, 15, 10, 25 },
                new int[] { 2, 1, 2, 1 }, new int[] { 1, 1, 1, 1 }));
        System.out.println(getJobSequence(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 35, 30, 25, 20, 15, 12, 5 },
                new int[] { 3, 4, 4, 2, 3, 1, 2 }, new int[] { 1, 1, 1, 1, 1, 1, 1 }));
    }

    public static int getJobSequence(int[] jobIds, int[] profits, int[] deadlines, int[] timeRequired) {
        List<List<Integer>> jobIdVsProfitVsDeadlineVsTimeList = new ArrayList<List<Integer>>();
        for (int i = 0; i < jobIds.length; i++) {
            List<Integer> jobIdVsProfitVsDeadlineVsTime = new ArrayList<Integer>();
            jobIdVsProfitVsDeadlineVsTime.add(jobIds[i]);
            jobIdVsProfitVsDeadlineVsTime.add(profits[i]);
            jobIdVsProfitVsDeadlineVsTime.add(deadlines[i]);
            jobIdVsProfitVsDeadlineVsTime.add(timeRequired[i]);
            jobIdVsProfitVsDeadlineVsTimeList.add(jobIdVsProfitVsDeadlineVsTime);
        }
        Collections.sort(jobIdVsProfitVsDeadlineVsTimeList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                Integer element1 = list1.get(1);
                Integer element2 = list2.get(1);
                return element2.compareTo(element1);
            }
        });
        // Find the maximum deadline
        int maxDeadline = 0;
        for (List<Integer> jobIdVsProfitVsDeadlineVsTime : jobIdVsProfitVsDeadlineVsTimeList) {
            maxDeadline = Math.max(maxDeadline, jobIdVsProfitVsDeadlineVsTime.get(2));
        }

        // Initialize the schedule as an array of size maxDeadline
        int[] schedule = new int[maxDeadline];
        int maxProfit = 0;
        Arrays.fill(schedule, -1);
        for (List<Integer> jobIdVsProfitVsDeadlineVsTime : jobIdVsProfitVsDeadlineVsTimeList) {
            for (int i = jobIdVsProfitVsDeadlineVsTime.get(2) - 1; i >= 0; i--) {
                if (schedule[i] == -1
                        && i + jobIdVsProfitVsDeadlineVsTime.get(3) <= jobIdVsProfitVsDeadlineVsTime.get(2)) {
                    schedule[i] = jobIdVsProfitVsDeadlineVsTime.get(0);
                    maxProfit += jobIdVsProfitVsDeadlineVsTime.get(1);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(schedule));
        return maxProfit;
    }
}
