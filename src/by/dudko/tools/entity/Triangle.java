package by.dudko.tools.entity;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by cplus on 18.05.2017.
 */
public class Triangle {
    private Point A;
    private Point B;
    private Point C;
    private double lengthAB;
    private double lengthBC;
    private double lengthAC;

    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
        setLengthAB();
        setLengthBC();
        setLengthAC();
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    private void setLengthAB() {
        lengthAB = sqrt(pow(A.getX() - B.getX(), 2) + pow(A.getY() - B.getY(), 2));
    }

    private void setLengthBC() {
        lengthBC = sqrt(pow(B.getX() - C.getX(), 2) + pow(B.getY() - C.getY(), 2));
    }

    private void setLengthAC() {
        lengthAC = sqrt(pow(A.getX() - C.getX(), 2) + pow(A.getY() - C.getY(), 2));
    }

    public double getLengthAB() {
        return lengthAB;
    }

    public double getLengthBC() {
        return lengthBC;
    }

    public double getLengthAC() {
        return lengthAC;
    }

    public double perimeter() {
        return lengthAB + lengthBC + lengthAC;
    }

    public double area() {
        double p = perimeter() / 2;
        return sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.lengthAB, lengthAB) != 0) return false;
        if (Double.compare(triangle.lengthBC, lengthBC) != 0) return false;
        if (Double.compare(triangle.lengthAC, lengthAC) != 0) return false;
        if (A != null ? !A.equals(triangle.A) : triangle.A != null) return false;
        if (B != null ? !B.equals(triangle.B) : triangle.B != null) return false;
        return C != null ? C.equals(triangle.C) : triangle.C == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = A != null ? A.hashCode() : 0;
        result = 31 * result + (B != null ? B.hashCode() : 0);
        result = 31 * result + (C != null ? C.hashCode() : 0);
        temp = Double.doubleToLongBits(lengthAB);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lengthBC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lengthAC);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "A=" + A +
                ", B=" + B +
                ", C=" + C +
                '}';
    }
}
