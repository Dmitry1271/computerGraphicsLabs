package test.by.dudko.action.lab5.jarvis.action;

import by.dudko.lab5.jarvis.action.AlgorithmAction;
import by.dudko.tools.entity.MovingPoint;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 20.05.2017.
 */
public class AlgorithmActionTest {
    @Test
    public void getAngleBeforeTest() {
        double actual = AlgorithmAction.getAngleBefore(new MovingPoint(600, 600), new MovingPoint(600, 100));
        double expected = 90;
        Assert.assertEquals(expected, actual, 1);
    }

    @Test
    public void getAngleAfterTest() {
        double actual = AlgorithmAction.getAngleAfter(new MovingPoint(400, 400), new MovingPoint(100, 100));
        double expected = 315;
        Assert.assertEquals(expected, actual, 1);
    }

}
