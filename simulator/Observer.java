package simulator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Observer implements SimObject{
    private Image image;
    private int posX, posY, moveX;
    public Observer(int posX, int posY, int moveX) {
        this.posX = posX - 25;
        this.posY = posY;
        this.moveX = moveX;
        try {
            image = ImageIO.read(new File("resources/images/Observer.png")).getScaledInstance(50, 150, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void calculate(double interpolation) {
        posX = posX > 1200 ? -350 : (int) (posX + (moveX * interpolation));
    }

    public void seenLight(){
        
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.white);
        if (Math.abs(moveX) > 0) graphics.drawRect(posX-125, posY, 300, 150);

        graphics.drawImage(image, posX, posY, null);
    }

}
