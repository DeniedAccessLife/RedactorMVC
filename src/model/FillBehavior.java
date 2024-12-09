package model;

import java.awt.*;

public enum FillBehavior
{
    FILL
    {
        @Override
        public void draw(Graphics2D graphics2D, Shape shape)
        {
            graphics2D.fill(shape);
        }
    },
    EMPTY
    {
        @Override
        public void draw(Graphics2D graphics2D, Shape shape)
        {
            graphics2D.draw(shape);
        }
    };

    public abstract void draw(Graphics2D graphics2D, Shape shape);
}
