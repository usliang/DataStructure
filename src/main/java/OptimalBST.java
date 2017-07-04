/****
 * Created by liliang on 7/3/17.
 ****/
public class OptimalBST {
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

    public static void ConstructOptimalBST(int[][] root, int lowerKey,int higherKey,int numberOfKeys){
        int parent = root[lowerKey][higherKey];

        // Construct the root of optimal BST
        if(higherKey == numberOfKeys && lowerKey == 1){
            System.out.println("K"+parent+" is the root.");
        }
        // Construct left sub-tree
        if(lowerKey<=parent-1){
            System.out.println("K"+root[lowerKey][parent-1]+" is the left child of K"+parent );
            ConstructOptimalBST(root, lowerKey, parent-1, numberOfKeys);
        }else{
            System.out.println("D"+ (parent-1) +" is the left child of K"+parent );
        }
        // Construct right sub-tree
        if(higherKey >=parent+1){
            System.out.println("K"+root[parent+1][higherKey]+" is the right child of K"+parent );
            ConstructOptimalBST(root, parent+1, higherKey, numberOfKeys);
        }else{
            System.out.println("D"+ parent +" is the right child of K"+parent );
        }
    }
}
