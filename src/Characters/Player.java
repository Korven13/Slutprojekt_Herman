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

    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;

    public Player(float posX, float posY) {
        super(posX, posY);


        try {
            image = ImageIO.read(new File("src/img.png"));
            System.out.println("rätt");
        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);

        }


    }

    public void move() {
        if (right == true) {
            posX += 1;
        }
        if (left == true) {
            posX -= 1;
        }
        if (up == true) {
            posY += 1;
        }
        if (down == true) {
            posY -= 1;
        }
    }

    public void render(Graphics g) {

        g.drawImage(image, (int) posX, (int) posY, 400, 200, null);
    }

    public void moveRight(boolean movement) {
        this.right = movement;
    }
    public void moveLeft(boolean movement) {
        this.left = movement;
    }
    public void moveUp(boolean movement) {
        this.up = movement;
    }
    public void moveDown(boolean movement) {
        this.down = movement;
    }



}
