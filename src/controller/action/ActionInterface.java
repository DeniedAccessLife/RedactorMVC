package controller.action;

import model.Model;

public interface ActionInterface
{
    void setModel(Model model);
    void mousePressed(model.Point point);
    void mouseDragged(model.Point point);
}