package by.dudko.tools.transformation;

import by.dudko.tools.entity.MovingPoint;

import java.util.Deque;

/**
 * Created by cplus on 20.05.2017.
 */
public class TransformStackToArray {
    public static MovingPoint[] getTransformed(Deque<MovingPoint> stack) {
        MovingPoint[] result = new MovingPoint[stack.size()];
        for (int i = result.length - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }

        for (MovingPoint point : result) {
            stack.push(point);
        }
        return result;
    }
}
