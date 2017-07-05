import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ActivitySelectorTest {

    @Test
    public void testRecursiveProcess() throws Exception {
        int[] startTime = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] finishTime = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        List<Integer> maxSet = new ArrayList<>();
        ActivitySelector.recursiveProcess(startTime, finishTime, 0, 11, maxSet);
        System.out.println(Arrays.toString(maxSet.toArray()));
    }
}