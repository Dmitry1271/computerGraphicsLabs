package by.dudko.tools.entityaction;

import by.dudko.tools.entity.Vector;

/**
 * Created by cplus on 19.05.2017.
 */
public class VectorAction {
    public static Vector productByNumber(Vector vector, double number) {
        return new Vector(vector.getX() * number, vector.getY() * number);
    }
}
