package by.dudko.lab6.quickhull.movement;

import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Polygon;
import by.dudko.tools.entityaction.VectorAction;
import by.dudko.tools.someaction.Belonging;

/**
 * Created by cplus on 19.05.2017.
 */
public class QuickHullMove {
    private MovingPoint[] points;
    private int speed;
    private int perimeter;

    public QuickHullMove(MovingPoint[] points, int speed, int perimeter) {
        this.points = points;
        this.speed = speed;
        this.perimeter = perimeter;
    }

    public void startMove(MovingPoint[] cover) {
        for (int i = 0; i < points.length; ++i) {
            if (new Polygon(cover).perimeter() > this.perimeter && Belonging.isThis(cover,points[i])) {
                points[i].setDirection(VectorAction.productByNumber(points[i].getDirection(), -1));
            }
            points[i].setX(points[i].getX() + speed * points[i].getDirection().getX());
            points[i].setY(points[i].getY() + speed * points[i].getDirection().getY());
        }
    }
}
