package by.dudko.tools.entity;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by cplus on 14.05.2017.
 */
public class Line {
    private Point p1;
    private Point p2;
    private double lineLength;

    public Line() {
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        setLineLength();
    }

    public Line(Point p1, Point p2, double lineLength) {
        this.p1 = p1;
        this.p2 = p2;
        this.lineLength = lineLength;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    private void setLineLength() {
        lineLength = sqrt(pow(p1.getX() - p2.getX(), 2) + pow(p1.getY() - p2.getY(), 2));
    }

    public double getLineLength() {
        return lineLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (p1 != null ? !p1.equals(line.p1) : line.p1 != null) return false;
        return p2 != null ? p2.equals(line.p2) : line.p2 == null;
    }

    @Override
    public int hashCode() {
        int result = p1 != null ? p1.hashCode() : 0;
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
