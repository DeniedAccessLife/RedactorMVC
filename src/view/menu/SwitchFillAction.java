package view.menu;

import javax.swing.*;
import model.FillBehavior;
import controller.Controller;
import java.awt.event.ActionEvent;

public class SwitchFillAction extends AbstractAction
{
    private final Controller controller;
    private final FillBehavior fillBehavior;

    public SwitchFillAction(String name, FillBehavior fillBehavior, Controller controller)
    {
        super(name);
        this.controller = controller;
        this.fillBehavior = fillBehavior;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setFillBehavior(fillBehavior);
    }
}
