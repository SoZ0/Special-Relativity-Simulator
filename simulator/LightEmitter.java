package simulator;

import java.awt.Color;
import java.awt.Graphics2D;

public class LightEmitter implements SimObject{

    private int startX, startY, x, y, centerX, centerY;
    private int rad = 1000;
    private int RATE = 25;
    private int maxRad = 1350;
    private int obX, obRate;
    private boolean triggered = false;

    public LightEmitter(int x, int y, int obX, int obRate) {
        this.startX = x;
        this.startY = y;
        this.obX = obX;
        this.obRate = obRate;
    }

    @Override
    public void calculate(double interpolation) {
        if(obX > 1500){
            obX = -200;
            triggered = false;
        }else{
            obX = (int) (obX + (obRate * interpolation));
        } 
        x = startX - (int)rad/2;
        y = startY - (int)rad/2;
        centerX = x + rad/2;
        centerY = y + rad/2;
        if(obX-100 >= 350 && !triggered){
            if(rad < maxRad){
                rad =(int)(rad + (RATE*interpolation));
            }else{
                rad = 5;
                triggered = true;
            }
            
        }else{
            rad = 5;
        }
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.drawOval(x, y, rad, rad);

        graphics.fillOval(centerX, centerY, 5, 5);
    }
    
}
