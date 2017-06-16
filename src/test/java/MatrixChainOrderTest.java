import org.junit.Test;

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

        MatrixChainOrder.printSolution(orders,3,5);
    }

    public void printArrays(int[][] data){
        for(int i = 1; i < data.length; i++){
            for(int j = i; j < data[i].length; j++){
                String msg = String.format("[%d][%d] = %d", i, j, data[i][j]);
                System.out.println(msg);
            }
        }
    }

}