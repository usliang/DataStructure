import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.*;

import static org.junit.Assert.*;

public class RobotMoveTest {

    @Test
    public void testGetPaths() throws Exception {
        Collection<java.util.List<Point>> paths = RobotMove.getPaths(2, 2);
        Assert.assertTrue(2 == paths.size());

        paths = RobotMove.getPaths(3, 3);
        Assert.assertTrue(6 == paths.size());
    }
}