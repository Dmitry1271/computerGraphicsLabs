package by.dudko.lab6.quickhull.run;

import by.dudko.lab6.quickhull.algorithm.QuickHullAlgorithm;
import by.dudko.lab6.quickhull.graphicaction.ScreenQuickHull;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Polygon;

/**
 * Created by cplus on 18.05.2017.
 */
public class RunnerLab6 {
    public static void main(String[] args) {
        int numberOfPoints = 15;
        int perimeter = 2000;
        int speed = 3;
        MovingPoint[] points = new MovingPoint[numberOfPoints];
        for (int i = 0; i < points.length; ++i) {
            points[i] = new MovingPoint();
            points[i].setRandomCoordinates();
        }
        int index = 0;
        while (new Polygon(new QuickHullAlgorithm(points).quickHull()).perimeter() > perimeter) {
            points[index].setRandomCoordinates();
            index++;
            if (index == points.length) {
                index = 0;
            }
        }
        ScreenQuickHull draw = new ScreenQuickHull(points, speed, perimeter);
        draw.drawingPanel();
    }
}
