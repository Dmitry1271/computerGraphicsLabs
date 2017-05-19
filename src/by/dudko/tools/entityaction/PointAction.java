package by.dudko.tools.entityaction;



import by.dudko.tools.entity.Point;

import java.awt.*;

import static by.dudko.tools.constants.Constants.POINT_HEIGHT;
import static by.dudko.tools.constants.Constants.POINT_WIDTH;

/**
 * Created by cplus on 17.05.2017.
 */
public class PointAction {
    public static void drowPoint(Point point, Graphics graaph) {
        graaph.fillOval((int) (point.getX() - POINT_WIDTH / 2), (int) (point.getY() - POINT_HEIGHT / 2), POINT_WIDTH, POINT_HEIGHT);
    }

    public static void drowPoints(Point[] points, Graphics graph) {
        for (Point point : points) {
            graph.fillOval((int) (point.getX() - POINT_WIDTH / 2), (int) (point.getY() - POINT_HEIGHT / 2), POINT_WIDTH, POINT_HEIGHT);
        }
    }
}
