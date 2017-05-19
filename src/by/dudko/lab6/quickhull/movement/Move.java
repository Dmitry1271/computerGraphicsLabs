package by.dudko.lab6.quickhull.movement;

import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Polygon;
import by.dudko.tools.entityaction.VectorAction;

/**
 * Created by cplus on 19.05.2017.
 */
public class Move {
    private MovingPoint[] points;
    private int speed;
    private int perimeter;

    public Move(MovingPoint[] points, int speed, int perimeter) {
        this.points = points;
        this.speed = speed;
        this.perimeter = perimeter;
    }

    public void startMove(MovingPoint[] cover) {
        for (int i = 0; i < points.length; ++i) {
            if (new Polygon(cover).perimeter() > this.perimeter && isThis(cover,points[i])) {
                points[i].setDirection(VectorAction.productByNumber(points[i].getDirection(), -1));
            }
            points[i].setX(points[i].getX() + speed * points[i].getDirection().getX());
            points[i].setY(points[i].getY() + speed * points[i].getDirection().getY());
        }
    }

    private boolean isThis(MovingPoint[] points, MovingPoint point) {
        for (MovingPoint p : points) {
            if (point == p) {
                return true;
            }
        }
        return false;
    }
}
