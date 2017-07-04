import org.junit.Test;

public class OptimalBSTTest {

    @Test
    public void testBottomUpOptimize() throws Exception {

        int[] p = new int[]{-1,15,10,5,10,20};
        // The probabilities associated with unsuccessful search.
        int[] q = new int[]{5,10,5,5,5,10};

        int numberOfKeys = 5;

        // Test optimized OptimalBST function by comparison.
        int[][] cost = new int[numberOfKeys+1+1][numberOfKeys+1];
        int[][] root = new int[numberOfKeys+1][numberOfKeys+1];
        OptimalBST.bottomUpOptimize(p, q, numberOfKeys, cost, root);

        System.out.println("A search cost of this optimal BST is " + (double)cost[1][numberOfKeys]/100 + "\n");

        OptimalBST.ConstructOptimalBST(root, 1, numberOfKeys, numberOfKeys);
        System.out.println();


    }


}