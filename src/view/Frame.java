package view;

import java.awt.*;
import view.menu.*;
import javax.swing.*;
import model.ActionType;
import model.ShapseEnum;
import model.FillBehavior;
import controller.Controller;

public class Frame extends JFrame
{
    private final Controller controller;

    public Frame(Panel panel, Controller controller)
    {
        this.controller = controller;

        setTitle("Redactor");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        add(panel);
        setVisible(true);
    }

    // MENU V1
    /*
    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Инструменты");

        // Меню для выбора формы
        mainMenu.add(new SwitchShapeAction("Линия", ShapseEnum.LINE, controller));
        mainMenu.add(new SwitchShapeAction("Круг", ShapseEnum.CIRCLE, controller));
        mainMenu.add(new SwitchShapeAction("Овал", ShapseEnum.ELLIPSE, controller));
        mainMenu.add(new SwitchShapeAction("Треугольник", ShapseEnum.TRIANGLE, controller));
        mainMenu.add(new SwitchShapeAction("Прямоугольник", ShapseEnum.RECTANGLE, controller));
        mainMenu.addSeparator();

        // Меню для выбора заливки
        mainMenu.add(new SwitchFillAction("Залить", FillBehavior.FILL, controller));
        mainMenu.add(new SwitchFillAction("Без заливки", FillBehavior.EMPTY, controller));
        mainMenu.addSeparator();

        // Меню для выбора действия (Рисовать / Двигать)
        mainMenu.add(new SwitchAction("Рисовать", ActionType.DRAW, controller));
        mainMenu.add(new SwitchAction("Двигать", ActionType.MOVE, controller));
        mainMenu.addSeparator();

        // Меню для выбора цвета
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem chooseColorItem = new JMenuItem("Выбрать цвет");
        chooseColorItem.addActionListener(e ->
        {
            Color selectedColor = JColorChooser.showDialog(this, "Выберите цвет", Color.RED);

            if (selectedColor != null)
            {
                controller.setCurrentColor(selectedColor);
            }
        });
        colorMenu.add(chooseColorItem);
        mainMenu.add(colorMenu);

        mainMenu.addSeparator();

        // Меню для изменения толщины линии
        JMenu strokeWidthMenu = new JMenu("Толщина линии");
        JSlider strokeWidthSlider = new JSlider(1, 10, 1);
        strokeWidthSlider.setMajorTickSpacing(1);
        strokeWidthSlider.setPaintTicks(true);
        strokeWidthSlider.setPaintLabels(true);

        strokeWidthSlider.addChangeListener(e -> controller.setStrokeWidth(strokeWidthSlider.getValue()));

        JMenuItem strokeWidthItem = new JMenuItem("Изменить толщину");
        strokeWidthItem.addActionListener(event -> JOptionPane.showMessageDialog(this, strokeWidthSlider, "Выберите толщину линии", JOptionPane.PLAIN_MESSAGE));
        strokeWidthMenu.add(strokeWidthItem);
        mainMenu.add(strokeWidthMenu);

        menuBar.add(mainMenu);

        return menuBar;
    }
    */

    // MENU V2
    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        // Меню для выбора формы
        JMenu shapeMenu = new JMenu("Фигура");
        shapeMenu.add(new SwitchShapeAction("Линия", ShapseEnum.LINE, controller));
        shapeMenu.add(new SwitchShapeAction("Круг", ShapseEnum.CIRCLE, controller));
        shapeMenu.add(new SwitchShapeAction("Овал", ShapseEnum.ELLIPSE, controller));
        shapeMenu.add(new SwitchShapeAction("Треугольник", ShapseEnum.TRIANGLE, controller));
        shapeMenu.add(new SwitchShapeAction("Прямоугольник", ShapseEnum.RECTANGLE, controller));
        menuBar.add(shapeMenu);

        // Меню для выбора заливки
        JMenu fillMenu = new JMenu("Заливка");
        fillMenu.add(new SwitchFillAction("Закрасить", FillBehavior.FILL, controller));
        fillMenu.add(new SwitchFillAction("Без закраски", FillBehavior.EMPTY, controller));
        menuBar.add(fillMenu);

        // Меню для выбора действия (Рисовать / Двигать)
        JMenu actionMenu = new JMenu("Действие");
        actionMenu.add(new SwitchAction("Двигать", ActionType.MOVE, controller));
        actionMenu.add(new SwitchAction("Рисовать", ActionType.DRAW, controller));
        menuBar.add(actionMenu);

        // Меню для выбора цвета
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem chooseColorItem = new JMenuItem("Изменить цвет");
        chooseColorItem.addActionListener(event ->
        {
            Color selectedColor = JColorChooser.showDialog(this, "Выберите цвет", Color.RED);

            if (selectedColor != null)
            {
                controller.setCurrentColor(selectedColor);
            }
        });
        colorMenu.add(chooseColorItem);
        menuBar.add(colorMenu);

        // Меню для изменения толщины линии
        JMenu strokeWidthMenu = new JMenu("Толщина");
        JSlider strokeWidthSlider = new JSlider(1, 10, 1);
        strokeWidthSlider.setMajorTickSpacing(1);
        strokeWidthSlider.setPaintTicks(true);
        strokeWidthSlider.setPaintLabels(true);

        strokeWidthSlider.addChangeListener(event -> controller.setStrokeWidth(strokeWidthSlider.getValue()));

        JMenuItem strokeWidthItem = new JMenuItem("Изменить толщину");
        strokeWidthItem.addActionListener(event -> JOptionPane.showMessageDialog(this, strokeWidthSlider, "Выберите толщину", JOptionPane.PLAIN_MESSAGE));
        strokeWidthMenu.add(strokeWidthItem);
        menuBar.add(strokeWidthMenu);

        return menuBar;
    }
}