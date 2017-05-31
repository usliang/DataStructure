import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AllSubsetTest {

    @Test
    public void testGetSubsets() throws Exception {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> all = AllSubset.getSubsets(integers, 0);
        Assert.assertTrue(8 == all.size());

        all = AllSubset.getSubsets2(integers);
        Assert.assertTrue(8 == all.size());
    }
}