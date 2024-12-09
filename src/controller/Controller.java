package controller;

import controller.action.ActionDelete;
import model.*;
import java.awt.*;
import view.Panel;
import view.Frame;
import javax.swing.*;
import java.awt.event.*;
import java.util.Collection;
import controller.action.ActionDraw;
import controller.action.ActionMove;
import controller.action.ActionInterface;

public class Controller
{
    private final Model model;
    private static Controller instance;
    private final State currentState;
    private ActionInterface currentAction;

    private Controller()
    {
        model = new Model();
        Panel panel = new Panel(this);
        CommandManager.getInstance().setPanel(panel);
        new Frame(panel, this);
        currentState = new State();
        currentAction = new ActionDraw(model);
        currentState.actionInterface = currentAction;
    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }

        return instance;
    }

    public void setupMouseListeners(JPanel panel)
    {
        panel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent event)
            {
                currentState.myShape = model.findShape(createPoint(event.getPoint()));
                currentAction.mousePressed(createPoint(event.getPoint()));
                panel.repaint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                currentAction.mouseDragged(createPoint(event.getPoint()));
                panel.repaint();
            }
        });
    }

    public void setFillBehavior(FillBehavior fillBehavior)
    {
        model.setFillBehavior(fillBehavior);
    }

    public void setCurrentColor(Color color)
    {
        model.setCurrentColor(color);
    }

    public void setStrokeWidth(int width)
    {
        model.setStrokeWidth(width);
    }

    public void setActionType(ActionType actionType)
    {
        switch (actionType)
        {
            case DRAW ->
            {
                currentAction = new ActionDraw(model);
                currentState.actionInterface = currentAction;
            }
            case MOVE ->
            {
                currentAction = new ActionMove(model);
                currentState.actionInterface = currentAction;
            }
            case DELETE ->
            {
                currentAction = new ActionDelete(model);
                currentState.actionInterface = currentAction;
            }
        }
    }

    public void setShapeType(ShapseEnum shapeType)
    {
        model.setCurrentShapeType(shapeType);
    }

    public model.Point createPoint(java.awt.geom.Point2D point2D)
    {
        return new model.Point(point2D.getX(), point2D.getY());
    }

    public Collection<MyShape> getShapes()
    {
        return model.getShapes();
    }
}