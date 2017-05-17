import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BitOperationTest extends TestCase {

    @Test
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

    @Test
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

        bigStr = "99999999";
        num = new BigInteger(bigStr);
        numStr = BitOperation.convertNonDecimalToBinary(num);
        Assert.assertTrue(numStr.equals(Integer.toBinaryString(Integer.valueOf(bigStr))));

    }

    @Test
    public void testConvertDecimalPartToBinary(){
        double num = 0.5;
        String numStr = BitOperation.convertDecimalPartToBinary(num);
        Assert.assertTrue(".1".equals(numStr));

        num = 0.75;
        numStr = BitOperation.convertDecimalPartToBinary(num);
        Assert.assertTrue(".11".equals(numStr));

        num = 0.875;
        numStr = BitOperation.convertDecimalPartToBinary(num);
        Assert.assertTrue(".111".equals(numStr));
    }

    @Test
    public void testConvertDecimalToBinary(){

        String binStr = BitOperation.convertDecimalToBinary("2.5");
        Assert.assertTrue("10.1".equals(binStr));

    }

    @Test
    public void testGetMaxWithSameOneBit(){
        int num = 0;
        int max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue(0==max);

        num = ~0;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue(num==max);

        num = 1;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1<<31) == max);

        num = 2;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1<<31) == max);

        num = 4;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1<<31) == max);

        num = 8;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1<<31) == max);

        num = 3;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3<<30) == max);

        num = 5;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3<<30) == max);

        num = 9;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3<<30) == max);
    }

    @Test
    public void testGetMinWithSameOneBit(){
        int num = 0;
        int max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue(0==max);

        num = ~0;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue(num==max);

        num = 1;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1) == max);

        num = 2;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1) == max);

        num = 4;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1) == max);

        num = 8;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((1) == max);

        num = 3;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3) == max);

        num = 5;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3) == max);

        num = 9;
        max = BitOperation.getMinWithSameOneBit(num);
        Assert.assertTrue((3) == max);
    }
}