package model;

import java.awt.*;

public class ShapeFactory
{
    public static MyShape createShape(ShapseEnum shapeType, Point point1, Point point2, Color color)
    {
        MyShape shape = switch (shapeType)
        {
            case LINE -> new MyLine(color, 1);
            case CIRCLE -> new MyCircle(color, 1);
            case ELLIPSE -> new MyEllipse(color, 1);
            case TRIANGLE -> new MyTriangle(color, 1);
            case RECTANGLE -> new MyRectangle(color, 1);
        };

        shape.setPoint1(point1);
        shape.setPoint2(point2);

        return shape;
    }
}