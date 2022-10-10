package simulator;

import java.awt.Graphics2D;

public interface SimObject {
    
    public void calculate(double interpolation);
    public void draw(Graphics2D graphics);
    
}
