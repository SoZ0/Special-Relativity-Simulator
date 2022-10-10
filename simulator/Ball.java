package simulator;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.windows.ControlWindow;

public class Ball implements SimObject {

    private int x, y, arcX, move, offset = -10;
    private boolean dir = false;

    public Ball(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }

    @Override
    public void calculate(double interpolation) {
        if(x > 1200){
            x = -350;
        }else{
            x = (int) (x + (move*interpolation));
        }
      
        if(y < 500 && dir){
            y += (12*interpolation);
        }else if (y > 350 && !dir){
            y -= (12*interpolation);
        }

        if (y <= 350) dir = true;
        else if (y >= 500) dir = false;
        
     }

     int arcWidth = 65;
    @Override
    public void draw(Graphics2D graphics) {
        

        
        graphics.setColor(Color.white);
        graphics.fillOval(x, y, 10, 10);
        graphics.setColor(Color.green);
        
        if(!ControlWindow.train) graphics.drawLine(x+5, 500, x+5, 350);
        else{
            for (int i = 0; i < 10; i++) {
                arcX = arcWidth*i*2 + offset;
                graphics.drawLine(arcX+arcWidth, 350,arcX, 500);
                graphics.drawLine(arcX+arcWidth, 350,arcX+(arcWidth*2), 500);
            }
        }

        
        
        
        

        
    }
    
}
