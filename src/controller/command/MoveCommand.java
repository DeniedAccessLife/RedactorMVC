package controller.command;

import model.MyShape;
import java.awt.geom.Point2D;

public class MoveCommand implements CommandInterface
{
    private final MyShape shape;
    private final double deltaX;
    private final double deltaY;
    private final Point2D original1;
    private final Point2D original2;

    public MoveCommand(MyShape shape, double deltaX, double deltaY)
    {
        this.shape = shape;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.original1 = (Point2D) shape.getPoint1().clone();
        this.original2 = (Point2D) shape.getPoint2().clone();
    }

    @Override
    public void execute()
    {
        shape.move(deltaX, deltaY);
    }

    @Override
    public void undo()
    {
        shape.getPoint1().setLocation(original1);
        shape.getPoint2().setLocation(original2);
        shape.setFrame(new Point2D[]{original1, original2});
    }

    @Override
    public void redo()
    {
        shape.move(deltaX, deltaY);
    }
}