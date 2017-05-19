package by.dudko.tools.entityaction;

import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.Point;

/**
 * Created by cplus on 17.05.2017.
 */
public class PointPosition {
    private static double determinant(Line line, Point point){
        return (line.getP2().getX() - line.getP1().getX()) * (point.getY() - line.getP1().getY()) - (line.getP2().getY() - line.getP1().getY()) * (point.getX() - line.getP1().getX());
    }

    private static int findingPointPosition(Line line, Point point) {
        if (determinant(line, point) > 0) {
            return -1;
        }
        if (determinant(line, point) < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean checkingLeft(Line line, Point point) {
        return findingPointPosition(line, point) == -1;
    }

    public static boolean checkingIn(Line line, Point point) {
        return findingPointPosition(line, point) == 0;
    }
}
