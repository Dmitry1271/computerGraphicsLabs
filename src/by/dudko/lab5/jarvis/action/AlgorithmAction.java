package by.dudko.lab5.jarvis.action;

import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.MovingPoint;

/**
 * Created by cplus on 20.05.2017.
 */
public class AlgorithmAction {
    public static MovingPoint getBottomRightPoint(MovingPoint[] points) {
        MovingPoint result = points[0];
        for (int i = 1; i < points.length; ++i) {
            if (points[i].getY() > result.getY() || points[i].getY() == result.getY() && points[i].getX() > result.getX()) {
                result = points[i];
            }
        }
        return result;
    }

    public static MovingPoint getTopRightPoint(MovingPoint[] points) {
        MovingPoint result = points[0];
        for (int i = 1; i < points.length; ++i) {
            if (points[i].getY() < result.getY() || points[i].getY() == result.getY() && points[i].getX() > result.getX()) {
                result = points[i];
            }
        }
        return result;
    }

    public static double getAngleBefore(MovingPoint p1, MovingPoint p2) {
        double angle;
        if (p1.getX() <= p2.getX()) {
            angle = Math.toDegrees(Math.atan((p1.getY() - p2.getY()) / (p2.getX() - p1.getX())));
        } else {
            angle = 180 + Math.toDegrees(Math.atan((p1.getY() - p2.getY()) / (p2.getX() - p1.getX())));
        }

        if (angle < 0) {
            angle += 360;
        }
        return angle;
    }

    public static double getAngleAfter(MovingPoint p1, MovingPoint p2) {
        double angle;
        if (p1.getX() >= p2.getX()) {
            angle = Math.toDegrees(Math.atan((p2.getY() - p1.getY()) / (p1.getX() - p2.getX())));
        } else {
            angle = 180 + Math.toDegrees(Math.atan((p2.getY() - p1.getY()) / (p1.getX() - p2.getX())));
        }

        if (angle <= 0) {
            angle += 360;
        }

        if (angle == 360) {
            angle -= 360;
        }
        return angle;
    }

    public static MovingPoint getPointMinAngle(MovingPoint[] points, MovingPoint point, boolean isBeforeTop) {
        int k = 0;
        MovingPoint result;
        do {
            result = points[k];
            k++;
        } while (result.equals(point));
        if (isBeforeTop) {
            for (int i = 0; i < points.length; ++i) {
                if (!points[i].equals(point) && !result.equals(point) &&
                        (getAngleBefore(point, points[i]) < getAngleBefore(point, result))) {
                    result = points[i];
                }
            }
        } else {
            for (int i = 0; i < points.length; ++i) {
                if (!point.equals(points[i]) && !point.equals(result) &&
                        getAngleAfter(point, points[i]) < getAngleAfter(point, result) || (getAngleAfter(point, points[i]) == getAngleAfter(point, result)) && points[i].getX() > result.getX()) {
                    result = points[i];
                }
            }
        }
        return result;
    }


}
