import org.junit.Assert;
import org.junit.Test;

public class RodCutTest {
    static final int PRICES[] = {1,5,8,9,10,17,17,20,24,30};
    static final int LENGTH = 9;
    @Test
    public void testBottomUpCutRod() throws Exception {
        int maxRevenue = RodCut.bottomUpCutRod(PRICES, LENGTH);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
        Assert.assertTrue(30 == maxRevenue);
    }

    @Test
    public void testMemoizeCut(){
        int maxRevenue = RodCut.memoizeCut(PRICES, LENGTH);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
        Assert.assertTrue(30 == maxRevenue);
    }

    @Test
    public void testBottomUpCutRodWithHow() throws Exception {
        int[] revenues = new int[LENGTH + 1];
        int[] firstPieces = new int[LENGTH + 1];
        int maxRevenue = RodCut.bottomUpCutRodWithHow(PRICES, LENGTH, revenues, firstPieces);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
        Assert.assertTrue(30 == maxRevenue);

        RodCut.printSolution(firstPieces, LENGTH);
    }

    public void printRevenues(int[] revenues){
        for(int i = 0; i < revenues.length; i++) {
            String msg = String.format("Max revenue for length %d is %d.", i, revenues[i]);
            System.out.println(msg);
        }
    }

    public void printFirstPierces(int[] firstPierces){
        for(int i = 0; i < firstPierces.length; i++) {
            String msg = String.format("The first pieces leading to the max revenue for length: %d is %d.", i, firstPierces[i]);
            System.out.println(msg);
        }
    }

    @Test
    public void testMemoizeCutWithHow() throws Exception {
        int[] revenues = new int[LENGTH + 1];
        int[] firstPieces = new int[LENGTH + 1];
        int maxRevenue = RodCut.memoizeCutWithHow(PRICES, LENGTH, firstPieces);
        String msg = String.format("Max revenue for length %d is %d.", LENGTH, maxRevenue);
        System.out.println(msg);
        //Assert.assertTrue(30 == maxRevenue);

        RodCut.printSolution(firstPieces, LENGTH);
    }
}