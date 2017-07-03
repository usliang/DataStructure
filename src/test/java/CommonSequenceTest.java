import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CommonSequenceTest {

    @Test
    public void testFindLongest() throws Exception {
        char[] charsA = {'a', 'b'};
        char[] charsB = {'a', 'b'};
        List<List<List<CommonSequence.MatchInfo>>> lists = CommonSequence.findLongest(charsA, charsB);
        List<List<CommonSequence.MatchInfo>> longestList = lists.get(lists.size()-1);
        Assert.assertTrue(1 == longestList.size());
        List<CommonSequence.MatchInfo> longestSequence = longestList.get(longestList.size() - 1);
        Assert.assertTrue( 2 == longestSequence.size());

        //three same elements
        char[] charsA2 = {'a', 'b', 'c'};
        char[] charsB2 = {'a', 'b', 'c'};
        lists = CommonSequence.findLongest(charsA2, charsB2);
        longestList = lists.get(lists.size()-1);
        Assert.assertTrue(1 == longestList.size());
        longestSequence = longestList.get(longestList.size() - 1);
        Assert.assertTrue( 3 == longestSequence.size());

        //four same elements
        char[] charsA3 = {'a', 'b', 'c', 'd'};
        char[] charsB3 = {'a', 'b', 'c', 'd'};
        lists = CommonSequence.findLongest(charsA3, charsB3);
        longestList = lists.get(lists.size()-1);
        Assert.assertTrue(1 == longestList.size());
        longestSequence = longestList.get(longestList.size() - 1);
        Assert.assertTrue( 4 == longestSequence.size());

        //three different elements
        char[] charsA4 = {'a', 'b', 'c'};
        char[] charsB4 = {'e', 'f', 'g'};
        lists = CommonSequence.findLongest(charsA4, charsB4);
        Assert.assertTrue(0 == lists.size());

        //data from book
        char[] charsA5 = {'a', 'b', 'c', 'b', 'd', 'a', 'b'};
        char[] charsB5 = {'b', 'd', 'c', 'a', 'b', 'a'};
        lists = CommonSequence.findLongest(charsA5, charsB5);
        longestList = lists.get(lists.size()-1);
        Assert.assertTrue(3 == longestList.size());
        longestSequence = longestList.get(longestList.size() - 1);
        Assert.assertTrue( 4 == longestSequence.size());
    }
}