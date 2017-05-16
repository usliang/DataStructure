/**
 * Created by lliang on 5/13/2017.
 */
public class BitOperation {

    public static int updateBits(int n, int m, int i, int j) {
        int max = ~0; /* All 1’s */
        // 1’s through position j, then 0’s
        int left = max - ((1 << j+1) - 1);

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


}
