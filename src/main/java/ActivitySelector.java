import java.util.List;

/**
 * Created by lliang on 7/4/2017.
 * dynamic programming and greedy
 */
public class ActivitySelector {
    public static void recursiveProcess(final int[] startTime, final int[] finishTime,
                                        final int k, final int activityCount, final List<Integer> maxSet) {
        if (0 == k) {
            maxSet.add(k);
        }
        int m = k + 1;
        while (m < activityCount && startTime[m] < finishTime[k]) {
            m++;
        }
        if (m < activityCount) {
            maxSet.add(m);
            recursiveProcess(startTime, finishTime, m, activityCount, maxSet);
        }
    }

    public static void bottomUpProcess(final int[] startTime, final int[] finishTime,
                                       final int activityCount, final List<Integer> maxSet) {
        maxSet.add(0);
        int currentFinishTime = finishTime[0];
        for (int i = 1; i < activityCount; i++) {
            if ( currentFinishTime < startTime[i]) {
                maxSet.add(i);
                currentFinishTime = finishTime[i];
            }
        }
    }
}
