package Evadarea.Window;

import javax.swing.*;
import java.awt.*;

public class Window
{
    private JFrame windowFrame;
    private String windowTitle;
    private int windowLength;
    private int windowHeight;

    private Canvas canvas;

    // fereastra principala in care este incadrat jocul
    public Window(String windowTitle, int windowLength, int windowHeight)
    {
        this.windowTitle = windowTitle;
        this.windowLength = windowLength;
        this.windowHeight = windowHeight;
        windowFrame = null;
    }

    public void CreateWindow()
    {
        if(windowFrame != null)
        {
            return;
        }

        windowFrame = new JFrame(windowTitle);

        windowFrame.setSize(windowLength, windowHeight);

        windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        windowFrame.setResizable(false);

        windowFrame.setLocationRelativeTo(null);

        windowFrame.setVisible(true);


        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(windowLength, windowHeight));

        canvas.setMaximumSize(new Dimension(windowLength,windowHeight));

        canvas.setMinimumSize(new Dimension(windowLength,windowHeight));


        windowFrame.add(canvas);

        windowFrame.pack();

    }

    public int GetWindowLength()
    {
        return windowLength;
    }

    public int GetWindowHeight()
    {
        return windowHeight;
    }

    public Canvas GetCanvas()
    {
        return canvas;
    }

    public JFrame GetFrame()
    {
        return windowFrame;
    }



}
