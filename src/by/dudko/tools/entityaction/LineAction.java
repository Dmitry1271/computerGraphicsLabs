package by.dudko.tools.entityaction;

import by.dudko.tools.entity.Line;

import java.awt.*;

/**
 * Created by cplus on 17.05.2017.
 */
public class LineAction {
    public static void drowLine(Line line, Graphics graph){
        graph.drawLine((int)line.getP1().getX(),(int)line.getP1().getY(),(int)line.getP2().getX(),(int)line.getP2().getY());
    }

    public static void drowLines(Line lines[], Graphics graph){
        for(Line line:lines){
            graph.drawLine((int)line.getP1().getX(),(int)line.getP1().getY(),(int)line.getP2().getX(),(int)line.getP2().getY());
        }
    }
}
