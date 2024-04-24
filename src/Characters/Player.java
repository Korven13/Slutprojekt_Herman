package Characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;

public class Player extends Character {
    static public BufferedImage image;

    public Player(float posX, float posY) {
        super(posX, posY);


        try {
            image = ImageIO.read(new File("C:\\Prog2\\Slutprojekt Herman\\src\\img.png"));
            System.out.println("rätt");
        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);

        }


    }

    public void render(Graphics g) {

        g.drawImage(image, (int) posX, (int) posY, 400, 200, null);
    }


}
