package view.menu;

import javax.swing.*;
import controller.Controller;
import java.awt.event.ActionEvent;

public class SwitchStrokeWidthAction extends AbstractAction
{
    private final int strokeWidth;
    private final Controller controller;

    public SwitchStrokeWidthAction(String name, int strokeWidth, Controller controller)
    {
        super(name);
        this.controller = controller;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setStrokeWidth(strokeWidth);
    }
}
