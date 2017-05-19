package by.dudko.lab6.quickhull.graphicaction;

import by.dudko.lab6.quickhull.action.AlgorithmAction;
import by.dudko.lab6.quickhull.algorithm.QuickHullAlgorithm;
import by.dudko.lab6.quickhull.movement.Move;
import by.dudko.tools.constants.Constants;
import by.dudko.tools.entity.Line;
import by.dudko.tools.entity.MovingPoint;
import by.dudko.tools.entityaction.LineAction;
import by.dudko.tools.entityaction.PointAction;
import by.dudko.tools.entityaction.PolygonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cplus on 18.05.2017.
 */
public class ScreenQuickhull extends JPanel {
    private MovingPoint[] points;
    private MovingPoint[] coverPoints;
    private QuickHullAlgorithm quickHullAlgorithm;
    private Move move;

    public ScreenQuickhull(MovingPoint[] points, int speed, int perimeter) {
        this.points = points;
        move = new Move(this.points,speed,perimeter);
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
        try {
            quickHullAlgorithm = new QuickHullAlgorithm(this.points);
            coverPoints = quickHullAlgorithm.quickHull();
            super.paintComponent(graph);
            Thread.sleep(15);
            move.startMove(coverPoints);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PointAction.drowPoints(points, graph);
        PolygonAction.drowPolygon(coverPoints, graph);
    }

}
