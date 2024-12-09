package controller.command;

public interface CommandInterface
{
    void execute();
    void undo();
    void redo();
}