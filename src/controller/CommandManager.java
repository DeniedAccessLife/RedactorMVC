package controller;

import view.Panel;
import java.util.Stack;
import controller.command.CommandInterface;

public class CommandManager
{
    private Panel panel;
    private static CommandManager instance;
    private final Stack<CommandInterface> undoStack = new Stack<>();
    private final Stack<CommandInterface> redoStack = new Stack<>();

    private CommandManager() {}

    public static CommandManager getInstance()
    {
        if (instance == null)
        {
            instance = new CommandManager();
        }

        return instance;
    }

    public void setPanel(Panel panel)
    {
        this.panel = panel;
    }

    public void executeCommand(CommandInterface command)
    {
        command.execute();

        undoStack.push(command);
        redoStack.clear();

        if (panel != null)
        {
            panel.repaint();
        }
    }

    public void undo()
    {
        if (undoStack.isEmpty())
        {
            // System.out.println("Nothing to undo.");
            return;
        }

        CommandInterface command = undoStack.pop();
        command.undo();
        redoStack.push(command);

        if (panel != null)
        {
            panel.repaint();
        }
    }

    public void redo()
    {
        if (redoStack.isEmpty())
        {
            // System.out.println("Nothing to redo.");
            return;
        }

        CommandInterface command = redoStack.pop();
        command.redo();
        undoStack.push(command);

        if (panel != null)
        {
            panel.repaint();
        }
    }
}