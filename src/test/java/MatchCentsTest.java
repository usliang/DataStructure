import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MatchCentsTest {

    @Test
    public void testMatch() throws Exception {

        Set<MatchCents.Combination> combinations = MatchCents.match(2);

        Assert.assertTrue(1 == combinations.size());

        combinations = MatchCents.match(4);
        Assert.assertTrue(1 == combinations.size());

        combinations = MatchCents.match(5);
        Assert.assertTrue(2 == combinations.size());

        combinations = MatchCents.match(6);
        Assert.assertTrue(2 == combinations.size());

        combinations = MatchCents.match(10);
        Assert.assertTrue(4 == combinations.size());

        combinations = MatchCents.match(11);
        Assert.assertTrue(4 == combinations.size());

        combinations = MatchCents.match(15);
        Assert.assertTrue(6 == combinations.size());

        combinations = MatchCents.match(16);
        Assert.assertTrue(6 == combinations.size());

        combinations = MatchCents.match(20);
        Assert.assertTrue(9 == combinations.size());

        combinations = MatchCents.match(21);
        Assert.assertTrue(9 == combinations.size());

        combinations = MatchCents.match(25);
        Assert.assertTrue(13 == combinations.size());

        combinations = MatchCents.match(30);
        Assert.assertTrue(MatchCents.makeChange(30, 25) == combinations.size());
    }

    @Test
    public void testMakeChange(){
        System.out.println(MatchCents.makeChange(5, 25));
    }
}