package by.dudko.lab6.quickhull.action;

import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Triangle;
import by.dudko.tools.entityaction.PointPosition;

import java.util.ArrayList;

/**
 * Created by cplus on 19.05.2017.
 */
public class AlgorithmAction {
    public static MovingPoint getLeftPoint(MovingPoint[] points) {
        MovingPoint leftPoint = points[0];
        for (MovingPoint point : points) {
            if (point.getX() < leftPoint.getX()) {
                leftPoint = point;
            }
        }
        return leftPoint;
    }

    public static MovingPoint getRightPoint(MovingPoint[] points) {
        MovingPoint rightPoint = points[0];
        for (MovingPoint point : points) {
            if (point.getX() > rightPoint.getX()) {
                rightPoint = point;
            }
        }
        return rightPoint;
    }

    public static MovingPoint[] getPointsLeftFromLine(MovingPoint[] points, Line line) {
        ArrayList<MovingPoint> list = new ArrayList<>();
        for (MovingPoint point : points) {
            if (!PointPosition.checkingLeft(line, point) && point != line.getP1() && point != line.getP2()) {
                list.add(point);
            }
        }
        MovingPoint[] result = new MovingPoint[list.size()];
        result = list.toArray(result);
        return result;
    }

    public static MovingPoint getFurthest(MovingPoint[] points, Line line) {
        MovingPoint result = points[0];
        for (MovingPoint point : points) {
            Triangle t1 = new Triangle(line.getP1(), line.getP2(), result);
            Triangle t2 = new Triangle(line.getP1(), line.getP2(), point);
            if (t1.area() < t2.area() || t1.area() == t2.area() && result.getX() > point.getX()) {
                result = point;
            }
        }
        return result;
    }
}
