package simulator.engine;

import gui.windows.ControlWindow;
import gui.windows.SimulatorWindow;
import simulator.Ball;
import simulator.LightEmitter;
import simulator.Observer;
import simulator.SimObject;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class FlareEgine implements Runnable{
    
    private SimulatorWindow simulator;
    private static Graphics2D graphics;
    private static int TPS = 25; 
    private static int tps = 25; 
    private static int st = 1000/tps;
    private static int MAX_FS = 1;
    private static double interpolation;
    private static ArrayList<SimObject> objects = new ArrayList<>();

    public FlareEgine(SimulatorWindow simulator) {
        this.simulator = simulator;
        objects.add(new Ball(-355,simulator.height/2, 5));
        objects.add(new Observer(-200,simulator.height/2, 5));
        objects.add(new Observer(simulator.width/2+15,simulator.height/2 + 200, 0));
        objects.add(new LightEmitter(simulator.width/2 - 150,simulator.height/2-50, -200, 5));
        objects.add(new LightEmitter(simulator.width/2 + 150,simulator.height/2-50, -200, 5));
    }

    public void draw(){
        graphics = simulator.getGraphics().get();
        for (SimObject simObject : objects) {
            simObject.draw(graphics);
        }
        
    }

    public void update(double interpo){
        updateSimSpeed();
        for (SimObject simObject : objects) {
            simObject.calculate(interpo);
        }
        simulator.repaint();
    }

    public static void updateSimSpeed(){
        try {
            tps = (int) (TPS * ((double)ControlWindow.simulationSpeed.getAsLong()/100L));
            st = 1000/tps;
        }catch(ArithmeticException ex){
            tps = 1;
        }
        //System.out.println(ControlWindow.simulationSpeed.getAsLong());
    }
   
    @Override
    public void run(){
        double next_game_tick = System.currentTimeMillis();
        int loops;
        while (true) {
            while((!ControlWindow.paused && ControlWindow.simulationSpeed.getAsLong() > 0)){
                loops = 0;
                while (System.currentTimeMillis() > next_game_tick && loops < MAX_FS) {
                    if((!ControlWindow.paused && ControlWindow.simulationSpeed.getAsLong() > 0)) update(interpolation);
                    next_game_tick += st;
                    loops++;
                    
                }
                interpolation = (System.currentTimeMillis() + st - next_game_tick) / (double) st;
                draw();
            }
            updateSimSpeed();
            draw();
        }
       
    }
        

}
