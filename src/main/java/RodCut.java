/****
 * Created by liliang on 6/1/17.
 * Dynamic Programming for rod-cut problem
 * The rod-cutting problem is the following. Given a rod of length n inches and a
 * table of prices pi for i = 1; 2; : : : ; n, determine the maximum revenue rn obtainable
 * by cutting up the rod and selling the pieces.
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

    public static int bottomUpCutRod(int[] prices, int length){
        int[] revenue = new int[length + 1];
        revenue[0] = 0;

        int currentMax;
        for (int j = 0; j <= length; j++){
            currentMax = 0;
            for (int i = 0; i < j; i++ ){
                currentMax = Math.max(currentMax, prices[i] + revenue[j - (i+1)]);
            }
            revenue[j] = currentMax;
            String msg = String.format("Max revenue for length %d is %d.", j, currentMax);
            System.out.println(msg);
        }
        return revenue[length];
    }

    public static int bottomUpCutRodWithHow(final int[] prices, final int length,
                                            final int[] revenue, final int[] firstPieces){
        revenue[0] = 0;
        firstPieces[0] = 0;
        int currentMax;
        for (int j = 0; j <= length; j++){
            currentMax = 0;
            for (int i = 0; i < j; i++ ){
                if (currentMax < (prices[i] + revenue[j - (i+1)])){
                    currentMax = prices[i] + revenue[j - (i+1)];
                    firstPieces[j] = i+1;
                }
            }
            revenue[j] = currentMax;
            String msg = String.format("Max revenue for length %d is %d.", j, currentMax);
            System.out.println(msg);
        }
        return revenue[length];
    }

    public static void printSolution(final int[] firstPierces, final int length){
        int current = length;

        System.out.println("solution for length = " + length);
        while(0 < current){
           System.out.print(firstPierces[current] + " ");
            current -= firstPierces[current];
        }
    }

    public static void main(String[] args) {
        final int prices[] = {1,5,8,9,10,17,17,20,24,30};
        final int LENGTH = 10;
        int maxRevenue = memoizeCut(prices, LENGTH);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
    }

}

