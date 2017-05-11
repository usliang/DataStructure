import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixGraphTest {

    @Test
    public void testFindShortestPath(){
        int graph[][] = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        MatrixGraph.ShortestPathResult result = MatrixGraph.findShortestPath(graph, 0, 4);
        Assert.assertTrue(result.getDistances()[0]==0);
        Assert.assertTrue(result.getDistances()[1]==Integer.MAX_VALUE);
        Assert.assertTrue(result.getDistances()[2]==Integer.MAX_VALUE);
        Assert.assertTrue(result.getDistances()[3]==Integer.MAX_VALUE);

        int graph2[][] = new int[][]{
                {0, 1, 2, 3},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        result = MatrixGraph.findShortestPath(graph2, 0, 4);
        Assert.assertTrue(result.getDistances()[0]==0);
        Assert.assertTrue(result.getDistances()[1] == 1);
        Assert.assertTrue(result.getDistances()[2] == 2);
        Assert.assertTrue(result.getDistances()[3] == 3);

        int graph3[][] = new int[][]{
                {0, 1, 2, 33},
                {0, 0, 4, 0},
                {0, 0, 0, 5},
                {0, 0, 0, 0}
        };

        result = MatrixGraph.findShortestPath(graph3, 0, 4);
        Assert.assertTrue(result.getDistances()[0]==0);
        Assert.assertTrue(result.getDistances()[1] == 1);
        Assert.assertTrue(result.getDistances()[2] == 2);
        Assert.assertTrue(result.getDistances()[3] == 7);
    }

}