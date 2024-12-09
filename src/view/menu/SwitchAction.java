package view.menu;

import javax.swing.*;
import model.ActionType;
import controller.Controller;
import java.awt.event.ActionEvent;

public class SwitchAction extends AbstractAction
{
    private final ActionType actionType;
    private final Controller controller;

    public SwitchAction(String name, ActionType actionType, Controller controller)
    {
        super(name);
        this.actionType = actionType;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setActionType(actionType);
    }
}