package controller.action;

import model.Model;
import model.Point;
import model.MyShape;
import controller.CommandManager;
import controller.command.MoveCommand;

public class ActionMove implements ActionInterface
{
    private Model model;
    private Point start;
    private MyShape selected;

    public ActionMove(Model model)
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
        selected = model.findShape(point);
        start = point;
    }

    @Override
    public void mouseDragged(Point point)
    {
        if (selected != null)
        {
            double deltaX = point.getX() - start.getX();
            double deltaY = point.getY() - start.getY();
            CommandManager.getInstance().executeCommand(new MoveCommand(selected, deltaX, deltaY));
            start = point;
        }
    }
}