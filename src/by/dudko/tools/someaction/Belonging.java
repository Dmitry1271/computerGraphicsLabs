package by.dudko.tools.someaction;

import by.dudko.tools.entity.MovingPoint;

/**
 * Created by cplus on 25.05.2017.
 */
public class Belonging {
    public static boolean isThis(MovingPoint[] points, MovingPoint point) {
        for (MovingPoint p : points) {
            if (point == p) {
                return true;
            }
        }
        return false;
    }
}
