package model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class MyCircle extends MyShape
{
    public MyCircle(Color color, int strokeWidth)
    {
        super(color, new Ellipse2D.Double(), strokeWidth);
    }

    @Override
    public void setFrame(Point2D[] points)
    {
        if (points.length < 2)
        {
            throw new IllegalArgumentException("At least two points are required to define a circle.");
        }

        double x1 = points[0].getX();
        double y1 = points[0].getY();
        double x2 = points[1].getX();
        double y2 = points[1].getY();

        double radius = Point2D.distance(x1, y1, x2, y2);

        ((Ellipse2D) shape).setFrame(x1 - radius, y1 - radius, 2 * radius, 2 * radius);
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(strokeWidth));
        fillBehavior.draw(graphics2D, shape);
    }
}