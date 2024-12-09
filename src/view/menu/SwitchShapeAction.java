package view.menu;

import javax.swing.*;
import model.ShapseEnum;
import controller.Controller;
import java.awt.event.ActionEvent;

public class SwitchShapeAction extends AbstractAction
{
    private final ShapseEnum shapeType;
    private final Controller controller;

    public SwitchShapeAction(String name, ShapseEnum shapeType, Controller controller)
    {
        super(name);
        this.controller = controller;
        this.shapeType = shapeType;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setShapeType(shapeType);
    }
}