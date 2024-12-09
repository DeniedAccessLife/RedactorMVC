package view;

import java.awt.*;
import javax.swing.*;
import model.MyShape;
import java.util.Collection;
import controller.Controller;

public class Panel extends JPanel
{
    private final Controller controller;

    public Panel(Controller controller)
    {
        this.controller = controller;
        controller.setupMouseListeners(this);
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        Collection<MyShape> shapes = controller.getShapes();

        for (MyShape shape : shapes)
        {
            shape.draw(graphics2D);
        }
    }
}