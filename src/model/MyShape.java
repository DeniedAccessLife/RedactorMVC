package model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform;

public abstract class MyShape
{
    protected Shape shape;
    public Point point1;
    public Point point2;

    protected Color color;
    protected int strokeWidth;
    protected FillBehavior fillBehavior;

    public MyShape(Color color, Shape shape, int strokeWidth)
    {
        this.color = color;
        this.shape = shape;
        this.strokeWidth = strokeWidth;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setPoint1(Point point1)
    {
        this.point1 = point1;
    }

    public void setPoint2(Point point2)
    {
        this.point2 = point2;
        setFrame(new Point2D[]{point1, point2});
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setStrokeWidth(int strokeWidth)
    {
        this.strokeWidth = strokeWidth;
    }

    public void setFillBehavior(FillBehavior fillBehavior)
    {
        this.fillBehavior = fillBehavior;
    }

    public boolean contains(Point point)
    {
        return shape.contains(point.getX(), point.getY());
    }

    public void move(double deltaX, double deltaY)
    {
        //System.out.println("Moving shape by deltaX: " + deltaX + ", deltaY: " + deltaY);

        if (shape instanceof Line2D line)
        {
            //System.out.println("Shape is a Line2D. Updating start and end points.");
            line.setLine(line.getX1() + deltaX, line.getY1() + deltaY, line.getX2() + deltaX, line.getY2() + deltaY);
        }
        else
        {
            //System.out.println("Shape is not a Line2D. Applying AffineTransform.");
            AffineTransform transform = new AffineTransform();
            transform.translate(deltaX, deltaY);
            shape = transform.createTransformedShape(shape);
        }

        if (point1 != null && point2 != null)
        {
            //System.out.println("Updating point1 and point2.");
            point1.setLocation(point1.getX() + deltaX, point1.getY() + deltaY);
            point2.setLocation(point2.getX() + deltaX, point2.getY() + deltaY);
        }
    }

    public abstract void draw(Graphics2D graphics2D);
    public abstract void setFrame(Point2D[] points);
}