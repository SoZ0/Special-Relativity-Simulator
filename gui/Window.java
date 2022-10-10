package gui;

import javax.swing.*;
import java.awt.*;

public abstract class Window {
    
    private JFrame frame;
    private String windowName;
    private Dimension dimension;
    
    public Window(String windowName, Dimension dimension){
        this.windowName = windowName;
        this.dimension = dimension;
        frame = new JFrame(windowName);
        frame.setPreferredSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void construct() {
        build();
    }

    public Container getContentPane(){
        return frame.getContentPane();
    }

    public void setLocation(Component compt){
        frame.setLocationRelativeTo(compt);
    }

    public void build(){
        frame.pack();
    }

    public void showWindow(){
        frame.setVisible(true);
    }

    public void hideWindow(){
        frame.setVisible(false);
    }

}
