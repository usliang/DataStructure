import junit.framework.TestCase;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BitOperationTest extends TestCase {

    public void testUpdateBits() throws Exception {

        int n = 0b10000000000;
        int m = 0b10101;

        int result = BitOperation.updateBits(n, m, 2, 6);
        System.out.println(Integer.toString(result,2));

        Assert.assertTrue(result == 0b10001010100);

        n = 0b11111111111;
        m = 0b00101;

        result = BitOperation.updateBits(n, m, 2, 6);
        System.out.println(Integer.toString(result,2));

        Assert.assertTrue(result == 0b11110010111);
    }

    public void testConvertNonDecimalToBinary(){
        String bigStr = "1";
        BigInteger num = new BigInteger(bigStr);
        String numStr = BitOperation.convertNonDecimalToBinary(num);
        Assert.assertTrue(numStr.equals(bigStr));

        bigStr = "2";
        num = new BigInteger(bigStr);
        numStr = BitOperation.convertNonDecimalToBinary(num);
        Assert.assertTrue(numStr.equals(Integer.toBinaryString(Integer.valueOf(bigStr))));

        bigStr = "20";
        num = new BigInteger(bigStr);
        numStr = BitOperation.convertNonDecimalToBinary(num);
        Assert.assertTrue(numStr.equals(Integer.toBinaryString(Integer.valueOf(bigStr))));

        bigStr = "2009";
        num = new BigInteger(bigStr);
        numStr = BitOperation.convertNonDecimalToBinary(num);
        Assert.assertTrue(numStr.equals(Integer.toBinaryString(Integer.valueOf(bigStr))));

    }
}