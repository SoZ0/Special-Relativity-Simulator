package gui.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.function.Supplier;

import javax.swing.JPanel;

import gui.Window;

public class SimulatorWindow extends Window{

    private Panel panel = new Panel();
    private Supplier<Graphics2D> graphics;
    public int width = 900, height = 700;

    public SimulatorWindow() {
        super("Simulator", new Dimension(900, 700));
    }
    
    @Override
    public void construct() {
        getContentPane().add(panel);
        build();
    }

    public void paint(Graphics2D g2){
       panel.paint(g2);
    }

    public void repaint(){
        panel.repaint();
     }

    public Supplier<Graphics2D> getGraphics(){
        return graphics;
    }
    
    private class Panel extends JPanel {


        public Panel() {
            super();
            setBackground(Color.black);
            graphics = () -> (Graphics2D)getGraphics().create();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            
        }

    }
}
