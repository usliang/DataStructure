import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/****
 * Created by liliang on 6/13/17.
 ****/
public class MatrixChainOrderTest {
    @Test
    public void testFindOptimalSolution() throws Exception {
        int[] dim = {30, 35, 15, 5, 10, 20, 25};
        int[][] cost = new int[dim.length][dim.length];
        int[][] orders = new int[dim.length][dim
                .length];
        MatrixChainOrder.bottomUpFindOptimalSolution(dim,cost, orders);


        //print result
        System.out.println("Cost array: ");
        printArrays(cost);

        System.out.println("Orders array: ");
        //printArrays(orders);

        MatrixChainOrder.printSolution(orders,1,5);

        System.out.println("Top down result: ");
        int[][] cost2 = new int[dim.length][dim.length];
        int[][] orders2 = new int[dim.length][dim
                .length];

        MatrixChainOrder.topDownMemorized(dim, cost2, orders2);

        //print result
        System.out.println("Cost array: ");
        printArrays(cost);

        System.out.println("Orders array: ");
        //printArrays(orders);

        MatrixChainOrder.printSolution(orders,1,5);

        Assert.assertTrue(Arrays.deepEquals(cost,cost2));


    }

    public void printArrays(int[][] data){
        for(int i = 1; i < data.length; i++){
            for(int j = i; j < data[i].length; j++){
                String msg = String.format("[%d][%d] = %d", i, j, data[i][j]);
                System.out.println(msg);
            }
        }
    }

    @Test
    public void testMatrixMultiple(){
        MatrixChainOrder.Matrix a = new MatrixChainOrder.Matrix(1,2);
        MatrixChainOrder.Matrix b = new MatrixChainOrder.Matrix(2,1);

        a.data[0][0] = 2;
        a.data[0][1] = 3;

        b.data[0][0] = 4;
        b.data[1][0] = 5;

        MatrixChainOrder.Matrix c = MatrixChainOrder.matrixMultiply(a, b);

        Assert.assertTrue(1 == c.rows);
        Assert.assertTrue(1 == c.columns);

        Assert.assertTrue(23 == c.data[0][0]);
    }

}