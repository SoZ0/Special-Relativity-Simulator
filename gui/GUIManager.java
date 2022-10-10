package gui;

import gui.windows.ControlWindow;
import gui.windows.SimulatorWindow;

public enum GUIManager{
        
        Control(new ControlWindow()),
        Simulator(new SimulatorWindow());

        private Window window;
        private GUIManager(Window window){
            this.window = window;
            window.construct();
        }

        public void show(){
            window.showWindow();
        }

        public void hide(){
            window.hideWindow();
        }

        public <T extends Window> T get(){
            return (T)window;
        }
}

