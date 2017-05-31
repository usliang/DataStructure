import java.util.ArrayList;
import java.util.List;

/**
 * Created by lliang on 5/27/2017.
 */
public class AllSubset {

    public static List<List<Integer>> getSubsets(final List<Integer> set,
                                                 final int index) {
        final List<List<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allSubsets = getSubsets(set, index + 1);
            final int item = set.get(index);
            final List<List<Integer>> moreSubsets = new ArrayList<>();
            for (final List<Integer> subset : allSubsets) {
                final List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }

    public static List<List<Integer>> getSubsets2(final List<Integer> set) {
        final List<List<Integer>> allSubsets = new ArrayList<>();
        final int max = 1 << set.size();
        for (int i = 0; i < max; i++) {
            final List<Integer> subset = new ArrayList<Integer>();
            int k = i;
            int index = 0;
            while (k > 0) {
                if ((k & 1) > 0) {
                    subset.add(set.get(index));
                }
                k >>= 1;
                index++;
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }


}
