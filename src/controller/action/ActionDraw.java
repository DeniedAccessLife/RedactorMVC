package controller.action;

import model.Model;
import model.MyShape;
import model.ShapeFactory;
import controller.CommandManager;
import controller.command.DrawCommand;

public class ActionDraw implements ActionInterface
{
    private Model model;
    private MyShape shape;

    public ActionDraw(Model model)
    {
        this.model = model;
    }

    @Override
    public void setModel(Model model)
    {
        this.model = model;
    }

    @Override
    public void mousePressed(model.Point point)
    {
        shape = ShapeFactory.createShape(model.getCurrentShapeType(), point, point, model.getCurrentColor());
        shape.setFillBehavior(model.getFillBehavior());
        shape.setStrokeWidth(model.getStrokeWidth());
        CommandManager.getInstance().executeCommand(new DrawCommand(model, shape));
    }

    @Override
    public void mouseDragged(model.Point point)
    {
        shape.setPoint2(point);
        model.updateShape(shape);
    }
}