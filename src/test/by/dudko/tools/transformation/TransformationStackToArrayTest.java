package test.by.dudko.tools.transformation;

import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.transformation.TransformStackToArray;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by cplus on 20.05.2017.
 */
public class TransformationStackToArrayTest {
    MovingPoint[] points;
    Deque<MovingPoint> stack;

    @Before
    public void init() {
        int n = 5;
        points = new MovingPoint[n];
        points[0] = new MovingPoint(100,100);
        points[1] = new MovingPoint(200,400);
        points[2] = new MovingPoint(400,100);
        points[3] = new MovingPoint(450,180);
        points[4] = new MovingPoint(700,10);
        stack = new LinkedList<>();
        stack.push(points[2]);
        stack.push(points[4]);
        stack.push(points[3]);
        stack.push(points[0]);
        stack.push(points[1]);
    }
    @After
    public void clear(){
        points = null;
    }
    @Test
    public void getTransformedTest(){
        MovingPoint[] expected = new MovingPoint[stack.size()];
        expected[0] = points[2];
        expected[1] = points[4];
        expected[2] = points[3];
        expected[3] = points[0];
        expected[4] = points[1];
        MovingPoint[] actual = TransformStackToArray.getTransformed(stack);
        Assert.assertArrayEquals(expected,actual);
    }
}
