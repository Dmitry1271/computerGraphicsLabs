package tools.entity;

import java.util.Arrays;

/**
 * Created by cplus on 14.05.2017.
 */
public class Polygon {
    private Point points[];
    private double massX[];
    private double massY[];

    public Polygon() {
    }

    public Polygon(Point[] points) {
        this.points = points;
        giveMassXAndYMemory(this.points.length);
        setMassXAndY();
    }

    public Polygon(double[] massX, double[] massY) {
        this.massX = massX;
        this.massY = massY;
        givePointsMemory(this.massX.length);
        setPoints(this.massX, this.massY);
    }

    public Point[] getPoints() {
        return points;
    }

    private void setPoints(double massX[], double massY[]) {
        for (int i = 0; i < massX.length; ++i) {
            points[i] = new Point(massX[i], massY[i]);
        }
    }

    private void setMassXAndY() {
        for (int i = 0; i < points.length; ++i) {
            massX[i] = points[i].getX();
            massY[i] = points[i].getY();
        }
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double[] getMassX() {
        return massX;
    }

    public void setMassX(double[] massX) {
        this.massX = massX;
    }

    public double[] getMassY() {
        return massY;
    }

    public void setMassY(double[] massY) {
        this.massY = massY;
    }

    private void givePointsMemory(int size) {
        points = new Point[size];
    }

    private void giveMassXAndYMemory(int size) {
        massX = new double[size];
        massY = new double[size];
    }

    private Line getLine(int n) {
        if (n != points.length) return new Line(points[n - 1], points[n]);
        else return new Line(points[n - 1], points[0]);
    }

    public Line[] getLines() {
        Line lines[] = new Line[points.length];
        for (int i = 0; i < points.length; ++i) {
            lines[i] = getLine(i + 1);
        }
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polygon polygon = (Polygon) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(points, polygon.points)) return false;
        if (!Arrays.equals(massX, polygon.massX)) return false;
        return Arrays.equals(massY, polygon.massY);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(points);
        result = 31 * result + Arrays.hashCode(massX);
        result = 31 * result + Arrays.hashCode(massY);
        return result;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
