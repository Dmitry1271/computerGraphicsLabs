package by.dudko.lab5.jarvis.run;

import by.dudko.lab5.jarvis.graphicaction.ScreenJarvisAlgorithm;
import by.dudko.tools.entity.MovingPoint;

/**
 * Created by cplus on 17.05.2017.
 */
public class RunnerLab5 {
    public static void main(String[] args) {
        int numberOfPoints = 5;
        int speed = 3;
        MovingPoint[] points = new MovingPoint[numberOfPoints];
        for (int i = 0; i < points.length; ++i) {
            points[i] = new MovingPoint();
            points[i].setRandomCoordinates();
        }

        ScreenJarvisAlgorithm drow = new ScreenJarvisAlgorithm(points, speed);
        drow.drawingPanel();
    }
}


