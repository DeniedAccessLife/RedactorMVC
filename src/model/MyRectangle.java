package model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends MyShape
{
    public MyRectangle(Color color, int strokeWidth)
    {
        super(color, new Rectangle2D.Double(), strokeWidth);
    }

    @Override
    public void setFrame(Point2D[] points)
    {
        if (points.length < 2)
        {
            throw new IllegalArgumentException("At least two points are required to define a rectangle.");
        }

        ((Rectangle2D) shape).setFrameFromDiagonal(points[0], points[1]);
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(strokeWidth));
        fillBehavior.draw(graphics2D, shape);
    }
}