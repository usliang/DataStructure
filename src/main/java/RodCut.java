/****
 * Created by liliang on 6/1/17.
 ****/

public class RodCut {

    public static int memoizeCut(final int[] prices, final int length) {
        int[] revenue = new int[length + 1];
        for (int i = 0; i <= length; i++){
            revenue[i] = -1;
        }
        return memoizeCutAux(prices, length, revenue);
    }

    public static int memoizeCutAux(final int[] prices, final int length, final int[] revenue){
        if (0 <= revenue[length]){
            return revenue[length];
        }

        int ret = 0;
        if (0 < length){
            ret = -1;

            for (int i = 0; i < length; i++){
                ret = Math.max(ret, prices[i] + memoizeCutAux(prices, length - (i + 1), revenue));
            }
        }

        revenue[length] = ret;

        String msg = String.format("Max revenue for length %d is %d.", length, ret);
        System.out.println(msg);

        return ret;
    }


    public static void main(String[] args) {
        final int prices[] = {1,5,8,9,10,17,17,20,24,30};
        final int LENGTH = 10;
        int maxRevenue = memoizeCut(prices, LENGTH);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
    }

}

