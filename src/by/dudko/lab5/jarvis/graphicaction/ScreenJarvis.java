package by.dudko.lab5.jarvis.graphicaction;

import by.dudko.lab5.jarvis.action.PolygonDiameter;
import by.dudko.lab5.jarvis.algorithm.JarvisAlgorithm;
import by.dudko.lab5.jarvis.movement.JarvisMove;
import by.dudko.tools.constants.Constants;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entityaction.LineAction;
import by.dudko.tools.entityaction.PointAction;
import by.dudko.tools.entityaction.PolygonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cplus on 17.05.2017.
 */
public class ScreenJarvis extends JPanel {
    private MovingPoint[] points;
    private MovingPoint[] coverPoints;
    private int speed;
    private double diameter;
    private JarvisAlgorithm jarvisAlgorithm;
    private JarvisMove move;

    public ScreenJarvis(MovingPoint[] points, int speed, double diameter) {
        this.points = points;
        this.speed = speed;
        this.diameter = diameter;
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
    protected void paintComponent(Graphics graph) {
        jarvisAlgorithm = new JarvisAlgorithm(points);
        coverPoints = jarvisAlgorithm.getCoverPoints();
        move = new JarvisMove(points,speed,diameter);
        super.paintComponent(graph);
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        move.startMove(coverPoints);
        repaint();
        PolygonAction.drowPolygon(coverPoints, graph);
        PointAction.drowPoints(points,graph);
        graph.setColor(Color.red);
        LineAction.drowLine(PolygonDiameter.findDiam(coverPoints),graph);

    }
}
