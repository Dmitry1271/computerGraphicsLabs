package by.dudko.lab5.jarvis.algorithm;


import by.dudko.lab5.jarvis.action.AlgorithmAction;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.transformation.TransformStackToArray;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cplus on 20.05.2017.
 */
public class JarvisAlgorithm {
    private MovingPoint[] points;
    private Deque<MovingPoint> coverPoints = new LinkedList<>();

    public JarvisAlgorithm(MovingPoint[] points) {
        this.points = points;
    }

    public MovingPoint[] getCoverPoints() {
        MovingPoint bottomRightPoint = AlgorithmAction.getBottomRightPoint(points);
        MovingPoint topRightPoint = AlgorithmAction.getTopRightPoint(points);
        coverPoints.add(bottomRightPoint);
        while (!coverPoints.peek().equals(topRightPoint)) {
            coverPoints.push(AlgorithmAction.getPointMinAngle(points, coverPoints.peek(), true));
        }
        while (!coverPoints.peek().equals(bottomRightPoint)) {
            coverPoints.push(AlgorithmAction.getPointMinAngle(points, coverPoints.peek(), false));

        }
        coverPoints.pop();
        return TransformStackToArray.getTransformed(coverPoints);
   }
}
