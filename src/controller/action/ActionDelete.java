package controller.action;

import model.Model;
import model.Point;
import model.MyShape;
import controller.CommandManager;
import controller.command.DeleteCommand;

public class ActionDelete implements ActionInterface
{
    private Model model;

    public ActionDelete(Model model)
    {
        this.model = model;
    }

    @Override
    public void setModel(Model model)
    {
        this.model = model;
    }

    @Override
    public void mousePressed(Point point)
    {
        MyShape selected = model.findShape(point);

        if (selected != null)
        {
            CommandManager.getInstance().executeCommand(new DeleteCommand(model, selected));
        }
    }

    @Override
    public void mouseDragged(Point point)
    {
    }
}