package by.dudko.lab5.jarvis.movement;

import by.dudko.lab5.jarvis.action.PolygonDiameter;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Polygon;
import by.dudko.tools.entityaction.VectorAction;
import by.dudko.tools.someaction.Belonging;

/**
 * Created by cplus on 25.05.2017.
 */
public class JarvisMove {
    private MovingPoint[] points;
    private int speed;
    private double diameter;

    public JarvisMove(MovingPoint[] points, int speed, double diameter) {
        this.points = points;
        this.speed = speed;
        this.diameter = diameter;
    }

    public void startMove(MovingPoint[] cover){
        for(int i=0;i<points.length;++i) {
            if (PolygonDiameter.findDiam(cover).getLineLength() > this.diameter && Belonging.isThis(cover,points[i])) {
                points[i].setDirection(VectorAction.productByNumber(points[i].getDirection(), -1));
           }
            points[i].setX(points[i].getX() + speed * points[i].getDirection().getX());
            points[i].setY(points[i].getY() + speed * points[i].getDirection().getY());
        }
    }
}
