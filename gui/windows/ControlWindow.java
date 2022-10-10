package gui.windows;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.util.Hashtable;
import java.util.function.LongSupplier;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;

import gui.Window;

public class ControlWindow extends Window {

    public static LongSupplier simulationSpeed;
    public static boolean paused = false;
    public static boolean train = false;

    public ControlWindow() {
        super("Controls", new Dimension(275,125));
        
    }

    @Override
    public void construct() {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(buildSilder());
        getContentPane().add(buildPausePlay());
        getContentPane().add(buildTrainRef());
        build();
    }

    private static JSlider buildSilder(){
        JSlider comp = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
        comp.setPreferredSize(new Dimension(250, 50));
        comp.setMajorTickSpacing(50);
        comp.setMinorTickSpacing(5);
        comp.setPaintTicks(true);
        comp.setSnapToTicks(true);
        Hashtable<Integer, JComponent> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("0x"));
        labelTable.put(25, new JLabel("0.25x"));
        labelTable.put(50, new JLabel("0.5x"));
        labelTable.put(100, new JLabel("1x"));
        labelTable.put(150, new JLabel("1.5x"));
        labelTable.put(200, new JLabel("2x"));
        comp.setLabelTable(labelTable);
        comp.setPaintLabels(true);
        simulationSpeed = () -> comp.getValue();
        return comp;
    }

    private static JButton buildPausePlay(){
        JButton comp = new JButton("Pause/Play");
        comp.addActionListener(e -> paused = !paused);
        return comp;
    }

    private static JCheckBox buildTrainRef(){
        JCheckBox comp = new JCheckBox("Stationary Frame of Reference: Train");
        comp.addActionListener(e -> train = comp.isSelected());
        return comp;
    }

    
}
