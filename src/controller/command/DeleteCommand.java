package controller.command;

import model.Model;
import model.MyShape;

public class DeleteCommand implements CommandInterface
{
    private final Model model;
    private final MyShape shape;

    public DeleteCommand(Model model, MyShape shape)
    {
        this.model = model;
        this.shape = shape;
    }

    @Override
    public void execute()
    {
        model.removeShape(shape);
    }

    @Override
    public void undo()
    {
        model.addShape(shape);
    }

    @Override
    public void redo()
    {
        model.removeShape(shape);
    }
}