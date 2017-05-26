package by.dudko.lab5.jarvis.run;

import by.dudko.lab5.jarvis.graphicaction.ScreenJarvis;
import by.dudko.tools.entity.MovingPoint;

/**
 * Created by cplus on 17.05.2017.
 */
public class RunnerLab5 {
    public static void main(String[] args) {
        int numberOfPoints = 10;
        int speed = 3;
        double diameter = 700;
        MovingPoint[] points = new MovingPoint[numberOfPoints];
        for (int i = 0; i < points.length; ++i) {
            points[i] = new MovingPoint();
            points[i].setRandomCoordinates();
        }

        ScreenJarvis drow = new ScreenJarvis(points, speed, diameter);
        drow.drawingPanel();
    }
}


