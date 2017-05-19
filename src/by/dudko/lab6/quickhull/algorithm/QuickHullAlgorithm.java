package by.dudko.lab6.quickhull.algorithm;

import by.dudko.lab6.quickhull.action.AlgorithmAction;
import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Triangle;
import by.dudko.tools.entityaction.PointPosition;
import by.dudko.tools.someaction.AddToListAfterObject;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by cplus on 18.05.2017.
 */
public class QuickHullAlgorithm {
    private MovingPoint[] points;
    private LinkedList<MovingPoint> convexHull = new LinkedList<>();

    public QuickHullAlgorithm(MovingPoint[] points) {
        this.points = points;
    }


    private void findHull(MovingPoint[] points, MovingPoint left, MovingPoint right) {
        if (points.length != 0) {
            MovingPoint furthest = AlgorithmAction.getFurthest(points, new Line(left, right));
            AddToListAfterObject.addAfter(convexHull, furthest, left);
            MovingPoint[] points1 = AlgorithmAction.getPointsLeftFromLine(points, new Line(left, furthest));
            MovingPoint[] points2 = AlgorithmAction.getPointsLeftFromLine(points, new Line(furthest, right));
            findHull(points1, left, furthest);
            findHull(points2, furthest, right);
        }
    }

    public MovingPoint[] quickHull() {
        MovingPoint leftPoint = AlgorithmAction.getLeftPoint(points);
        MovingPoint rightPoint = AlgorithmAction.getRightPoint(points);
        convexHull.add(leftPoint);
        convexHull.add(rightPoint);
        MovingPoint[] points1 = AlgorithmAction.getPointsLeftFromLine(points, new Line(leftPoint, rightPoint));
        MovingPoint[] points2 = AlgorithmAction.getPointsLeftFromLine(points, new Line(rightPoint, leftPoint));
        findHull(points1, leftPoint, rightPoint);
        findHull(points2, rightPoint, leftPoint);
        MovingPoint[] result = new MovingPoint[convexHull.size()];
        result = convexHull.toArray(result);
        return result;
    }
}

