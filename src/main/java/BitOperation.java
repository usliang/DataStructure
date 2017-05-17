import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidParameterException;

/**
 * Created by lliang on 5/13/2017.
 */
public class BitOperation {

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
        String nonDecimalPart = decimalPart.substring(0, dotIndex);

        BigDecimal afterDotVal = new BigDecimal(decimalPart);
        BigDecimal nonDecimalVal = new BigDecimal(nonDecimalPart);

        return "";
    }
}
