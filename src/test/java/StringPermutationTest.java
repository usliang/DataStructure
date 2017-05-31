import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringPermutationTest {

    @Test
    public void testPermute() throws Exception {
        List<String> input = new ArrayList<>(Arrays.asList("a"));
        List<String> output = StringPermutation.permute(input);
        Assert.assertTrue(1 == output.size());

        input = new ArrayList<>(Arrays.asList("a", "b"));
        output = StringPermutation.permute(input);
        Assert.assertTrue(2 == output.size());

        input = new ArrayList<>(Arrays.asList("a", "b", "c"));
        output = StringPermutation.permute(input);
        Assert.assertTrue(6 == output.size());

        input = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        output = StringPermutation.permute(input);
        Assert.assertTrue(24 == output.size());
    }
}