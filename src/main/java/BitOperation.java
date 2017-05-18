import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * Created by lliang on 5/13/2017.
 */
public class BitOperation {

    /**
     * insert m as bits into n between position i and j
     * @param n integer to be inserted
     * @param m integer to insert
     * @param i end position of m
     * @param j begin position of m
     * @return
     */
    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1’s */
        // 1’s through position j, then 0’s
        int left =  max << j+1;

        System.out.println(Integer.toBinaryString(left));

        // 1’s after position i
        int right = ((1 << i) - 1);

        System.out.println(Integer.toString(right,2));

        // 1’s, with 0s between i and j
        int mask = left | right;

        System.out.println(Integer.toBinaryString(mask));

        System.out.println(Integer.toBinaryString(n & mask));

        // Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }

    /**
     * convert a decimal into binary string
     * @param num 0<num<1
     * @return num in binary format
     */
    public static String convertDecimalPartToBinary(double num) {
        if (num >= 1 || num <= 0) {
            throw new InvalidParameterException("The parameter should be between 0 and 1.");
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
			/* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                throw new InvalidParameterException("The length of the digits are longer than 32.");
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static String convertNonDecimalToBinary(final BigInteger nonDecimalPart){
        StringBuilder binary = new StringBuilder();
        BigInteger quotient = nonDecimalPart;
        BigInteger remainder;
        final BigInteger BIG_TWO = new BigInteger("2");
        final BigInteger BIG_ONE = new BigInteger("1");

        while (quotient.compareTo(BIG_TWO) >= 0 ){
            remainder = quotient.remainder(BIG_TWO);
            quotient = quotient.divide(BIG_TWO);
            binary.append(remainder.toString());
        }
        binary.append(quotient.toString());

        return binary.reverse().toString();
    }

    public static String convertDecimalToBinary(String decimalStr){
        int  dotIndex = decimalStr.indexOf(".");
        String decimalPart = decimalStr.substring(dotIndex);
        String nonDecimalPart = decimalStr.substring(0, dotIndex);

        double afterDotVal = Double.valueOf(decimalPart);
        BigInteger nonDecimalVal = new BigInteger(nonDecimalPart);

        return convertNonDecimalToBinary(nonDecimalVal) +  convertDecimalPartToBinary(afterDotVal);
    }

    public static int countOneBits(final int num){

        int oneCount = 0;

        for (int bitCursor = num; bitCursor != 0; bitCursor = bitCursor >>> 1){
            oneCount += bitCursor & 1;
        }
        return oneCount;
    }

    /**
     * the method return the max integer using the same number of one bit in the parameter passed in
     * @param num a integer
     * @return max possible integer using the same one bit in num
     */
    public static int getMaxWithSameOneBit(final int num){
        final int INT_LEN = 32;
        int allOne = ~0;
        int oneCount = countOneBits(num);
        int ret = 0;

        if (0 != oneCount) {
            ret = allOne << (INT_LEN - oneCount);
        }
        return ret;
    }

    public static int getMinWithSameOneBit(final int num){
        final int INT_LEN = 32;
        int allOne = ~0;

        int ret = 0;
        int oneCount = countOneBits(num);
        if (0 != oneCount) {
            ret = allOne >>> (INT_LEN - oneCount);
        }
        return ret;
    }

    /**
     * get the different bit between a and b
     * @param a a integer
     * @param b another integer
     * @return count of different bit
     */
    public static int bitDiff(final int a, final int b){
        if (a == b){
            return 0;
        }
        final int INT_LEN = 32;
        int xorInt = a ^ b;

        if (~0 == xorInt){
            return INT_LEN;
        }

        int cursor = 1;
        int diffCount = 0;

        while (cursor <= xorInt && 0 != cursor){
            if ((xorInt & cursor) != 0){
                diffCount++;
            }
            cursor = cursor<<1;
        }
        return diffCount;
    }
    public static int swapOddEventBit(int num){
        int oddCursor = 1;
        int evenCursor = 2;
        int oddVal = 0;
        int evenVal = 0;

        int ret = num;
        for (int i=0; i<16; i++){
            oddVal = num & oddCursor;
            evenVal = num & evenCursor;

            int oddShift = oddVal<<1;
            if (oddShift != evenVal){
                if (0 != oddVal){
                    ret = ret & (~oddCursor); //change old from 1 to 0;
                    ret = ret | evenCursor; //change even from 0 to 1
                }else {
                    ret = ret | oddCursor; //change old from 0 to 1;
                    ret = ret & (~evenCursor); //change even from 1 to 0
                }
            }
            oddCursor = oddCursor<<2;
            evenCursor = evenCursor<<2;
        }
        return ret;
    }

    public static int swapOddEventBit2(final int num){

        return ( ((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1) );

    }
}
