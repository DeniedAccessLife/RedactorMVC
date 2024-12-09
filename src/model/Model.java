package model;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.util.Collection;

public class Model
{
    private int strokeWidth = 3;
    private Color currentColor = Color.BLACK;
    private FillBehavior fillBehavior = FillBehavior.EMPTY;
    private ShapseEnum currentShapeType = ShapseEnum.RECTANGLE;

    private final List<MyShape> shapes = new ArrayList<>();

    public void removeShape(MyShape shape) {
        shapes.remove(shape);
    }

    public void addShape(MyShape shape)
    {
        shapes.add(shape);
    }

    public void updateShape(MyShape shape)
    {
        int index = shapes.indexOf(shape);

        if (index != -1)
        {
            shapes.set(index, shape);
        }
    }

    public Collection<MyShape> getShapes()
    {
        return shapes;
    }

    public MyShape findShape(Point point)
    {
        for (MyShape shape : shapes)
        {
            if (shape.getShape() instanceof Line2D line)
            {
                if (line.ptSegDist(point) <= 5.0)
                {
                    //System.out.println("Found line near point: " + point);
                    return shape;
                }
            }
            else if (shape.contains(point))
            {
                //System.out.println("Found shape at point: " + point);
                return shape;
            }
        }

        //System.out.println("No shape found at point: " + point);
        return null;
    }

    public Color getCurrentColor()
    {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor)
    {
        this.currentColor = currentColor;
    }

    public ShapseEnum getCurrentShapeType()
    {
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapseEnum currentShapeType)
    {
        this.currentShapeType = currentShapeType;
    }

    public FillBehavior getFillBehavior()
    {
        return fillBehavior;
    }

    public void setFillBehavior(FillBehavior fillBehavior)
    {
        this.fillBehavior = fillBehavior;
    }

    public int getStrokeWidth()
    {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth)
    {
        this.strokeWidth = strokeWidth;
    }
}