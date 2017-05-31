import java.awt.Point;
import java.util.*;

/**
 * Created by lliang on 5/25/2017.
 */
public class RobotMove {
    public static Collection<List<Point>> getPaths(final int boardWidth,
                                                   final int boardHeight) {
        final Collection<List<Point>> allPaths = new HashSet<>();
        getPaths(allPaths, new ArrayList<Point>(), boardWidth - 1, boardHeight - 1);

        for (final List<Point> path : allPaths) {
            Collections.reverse(path);
        }

        return allPaths;
    }

    private static void getPaths(final Collection<List<Point>> allPaths,
                                 final List<Point> currentPath,
                                 final int x,
                                 final int y) {
        if (x < 0 || y < 0) {
            return;
        }

        if (!isFree(x, y)) {
            return;
        }

        final Point p = new Point(x, y);
        currentPath.add(p);

        if (x == 0 && y == 0) { // Reached the top left corner - stop and save the path
            allPaths.add(currentPath);
            return;
        }

        // Try a path going left (we are traveling backwards)
        getPaths(allPaths, new ArrayList<>(currentPath), x - 1, y);
        // Try a path going up (we are traveling backwards)
        getPaths(allPaths, new ArrayList<>(currentPath), x, y - 1);
    }

    private static boolean isFree(final int x, final int y) {
        // Implement any blocked squares here, by returning false
        return true;
    }

}
