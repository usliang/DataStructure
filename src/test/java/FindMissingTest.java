import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/****
 * Created by liliang on 5/18/17.
 ****/
public class FindMissingTest {
    @Test
    public void testFindMissing() throws Exception {

        final int LEN = 30;
        ArrayList<BitInteger> a = new ArrayList<BitInteger>(LEN);

        for(int i = 0; i < LEN; i++) {
            if (14 != i) {
                a.add(new BitInteger(i));
            }
        }

        int missing  = FindMissing.findMissing(a);
        System.out.println("Missing integer: " + missing);

        Assert.assertTrue(14 == missing);
    }

}