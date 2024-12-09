package controller.command;

import model.Model;
import model.MyShape;

public class DrawCommand implements CommandInterface
{
    private final Model model;
    private final MyShape shape;

    public DrawCommand(Model model, MyShape shape)
    {
        this.model = model;
        this.shape = shape;
    }

    @Override
    public void execute()
    {
        model.addShape(shape);
    }

    @Override
    public void undo()
    {
        model.removeShape(shape);
    }

    @Override
    public void redo()
    {
        model.addShape(shape);
    }
}