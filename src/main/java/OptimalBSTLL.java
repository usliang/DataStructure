/****
 * Created by liliang on 7/3/17.
 ****/
public class OptimalBSTLL {
    public static void bottomUpOptimize(int[] keyProbabilities, int[] noFoundProbabilities, int keyCount,
                                        int[][] cost, int[][] root ){
        int[][] w = new int[keyCount + 2][keyCount + 1];
        for (int i = 1; i <= keyCount+1; i++){
            cost[i][i-1] = noFoundProbabilities[i-1];
            w[i][i-1] = noFoundProbabilities[i-1];
        }
        for (int l = 1; l <= keyCount; l++){
            for (int i = 1; i <= keyCount-l+1; i++){
                int j = i+l-1;
                cost[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j-1] + keyProbabilities[j] + noFoundProbabilities[j];
                for (int r = i; r <= j; r++){
                    int tmpCost = cost[i][r-1] + cost[r+1][j] + w[i][j];
                    if (tmpCost < cost[i][j]){
                        cost[i][j] = tmpCost;
                        root[i][j] = r;
                    }
                }
            }
        }
    }
}
