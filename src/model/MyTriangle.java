package model;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class MyTriangle extends MyShape
{
    public MyTriangle(Color color, int strokeWidth)
    {
        super(color, new Path2D.Double(), strokeWidth);
    }

    @Override
    public void setFrame(Point2D[] points)
    {
        if (points.length < 2)
        {
            throw new IllegalArgumentException("At least two points are required to define a triangle.");
        }

        double x1 = points[0].getX();
        double y1 = points[0].getY();
        double x2 = points[1].getX();
        double y2 = points[1].getY();

        double x3 = (x1 + x2) / 2;
        double y3 = y1 - Math.abs(y2 - y1);

        Path2D triangle = new Path2D.Double();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();

        this.shape = triangle;
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(strokeWidth));
        fillBehavior.draw(graphics2D, shape);
    }
}