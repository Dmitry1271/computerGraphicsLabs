package by.dudko.lab5.jarvis.action;

import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Triangle;

/**
 * Created by cplus on 25.05.2017.
 */
public class PolygonDiameter {
    public static Line findDiam(MovingPoint[] cover) {
        int n = cover.length;
        int i = 2;
        int end;
        int start;
        int temp;
        double diameterLength = 0;
        Line result = new Line();
        while (new Triangle(cover[n - 1], cover[0], cover[i]).area() >
                new Triangle(cover[n - 1], cover[0], cover[i - 1]).area()) {
            i++;
        }
        start = i - 1;
        int j = 1;
        while (start != n - 1) {
            temp = start + 1;
            while (new Triangle(cover[j - 1], cover[j], cover[temp]).area() >
                    new Triangle(cover[j - 1], cover[j], cover[temp - 1]).area()) {
                temp++;
                if (temp == n) {
                    break;
                }
            }
            end = temp - 1;
            for (int k = start; k <= end; k++) {
                Line diameterTemp = new Line(cover[k], cover[j - 1]);
                double diameterLengthTemp = diameterTemp.getLineLength();
                if (diameterLengthTemp > diameterLength) {
                    result = diameterTemp;
                    diameterLength = diameterLengthTemp;
                }
            }
            start = end;
            j++;
        }
        return result;
    }
}
