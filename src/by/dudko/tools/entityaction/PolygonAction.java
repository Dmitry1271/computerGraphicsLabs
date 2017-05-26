package by.dudko.tools.entityaction;

import by.dudko.tools.transformation.TransformDoubleToInt;
import by.dudko.tools.entity.Polygon;
import by.dudko.tools.entity.Point;

import java.awt.*;

/**
 * Created by cplus on 17.05.2017.
 */
public class PolygonAction {

    public static void drowPolygon(Polygon polygon, Graphics graph){
        graph.drawPolygon(TransformDoubleToInt.getTransformed(polygon.getMassX()),TransformDoubleToInt.getTransformed(polygon.getMassY()),polygon.getSize());
    }

    public static void drowPolygon(Point[] points,Graphics graph){
        Polygon polygon = new Polygon(points);
        graph.drawPolygon(TransformDoubleToInt.getTransformed(polygon.getMassX()),TransformDoubleToInt.getTransformed(polygon.getMassY()),polygon.getSize());
    }
}
