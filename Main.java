import java.lang.reflect.InvocationTargetException;

import gui.GUIManager;
import simulator.engine.FlareEgine;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        GUIManager.Simulator.show();
        GUIManager.Control.show();
        new Main().run();
    }

    public void run()throws InvocationTargetException, InterruptedException{
        new FlareEgine(GUIManager.Simulator.get()).run();
    }
}