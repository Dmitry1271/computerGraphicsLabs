package by.dudko.tools.someaction;

import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entity.Point;

import java.util.LinkedList;

/**
 * Created by cplus on 18.05.2017.
 */
public class AddToListAfterObject {
    public static void addAfter(LinkedList<Point> list, Point point, Point afterThat) {
        list.add(list.indexOf(afterThat) + 1, point);
    }

    public static void addAfter(LinkedList<MovingPoint> list, MovingPoint point, MovingPoint afterThat) {
        list.add(list.indexOf(afterThat) + 1, point);
    }
}
