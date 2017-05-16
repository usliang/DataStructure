import junit.framework.TestCase;

public class BitOperationTest extends TestCase {

    public void testUpdateBits() throws Exception {
        int n = 0b10000000000;
        int m = 0b10101;

        //int result = BitOperation.updateBits(n, m, 2, 6);
        //System.out.println(Integer.toString(result,2));

        n = 0b11111111111;
        m = 0b00101;

        int result = BitOperation.updateBits(n, m, 2, 6);
        System.out.println(Integer.toString(result,2));

    }
}