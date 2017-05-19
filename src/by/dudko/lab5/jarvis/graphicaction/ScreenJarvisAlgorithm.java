package by.dudko.lab5.jarvis.graphicaction;

import by.dudko.tools.constants.Constants;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entityaction.PointAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cplus on 17.05.2017.
 */
public class ScreenJarvisAlgorithm extends JPanel{
    private MovingPoint[] points;
    private int speed;

    public ScreenJarvisAlgorithm(MovingPoint[] points, int speed){
        this.points = points;
        this.speed = speed;
    }

    public void drawingPanel() {
        JFrame frame = new JFrame("The point position");
        frame.setLocation(150, 0);
        frame.setMinimumSize(new Dimension(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graph){
        PointAction.drowPoints(points,graph);
    }
}
