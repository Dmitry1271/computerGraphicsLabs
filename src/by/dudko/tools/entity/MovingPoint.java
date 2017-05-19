package by.dudko.tools.entity;

import java.util.Random;

/**
 * Created by cplus on 18.05.2017.
 */
public class MovingPoint extends Point {
    private Vector direction;

    public MovingPoint() {
        direction = new Vector(Math.cos(Math.toRadians(generateAngle())),Math.sin(Math.toRadians(generateAngle())));
    }

    public MovingPoint(double x, double y) {
        super(x, y);
        direction = new Vector(Math.cos(Math.toRadians(generateAngle())),Math.sin(Math.toRadians(generateAngle())));
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    private int generateAngle() {
        Random random = new Random();
        return random.nextInt(360);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MovingPoint point = (MovingPoint) o;

        return direction != null ? direction.equals(point.direction) : point.direction == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
