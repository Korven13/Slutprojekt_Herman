package Characters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Player extends Character {
    private BufferedImage[][] image;
    private int animation = 3;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    private boolean attack;
    private int animationIndex;
    private int animationTick;


    public Player(float posX, float posY, int width, int height) {
        super(posX, posY, width, height);
        splitAnimations();
        hitbox(posX, posY, 70, 70);


        /*
        try {
            image = ImageIO.read(new File("src/img.png"));
            System.out.println("rätt");
        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);
        }
         */
    }


    private void splitAnimations() {
        try {
            BufferedImage imgIdle = ImageIO.read(new File("src/Sprites/Idle.png"));
            BufferedImage imgRun = ImageIO.read(new File("src/Sprites/Run.png"));
            BufferedImage imgAttack = ImageIO.read(new File("src/Sprites/Attack_1.png"));
            BufferedImage imgRunAttack = ImageIO.read(new File("src/Sprites/Run+Attack.png"));
            image = new BufferedImage[4][6];
            for (int i = 0; i < 4; i++) {
                image[0][i] = imgAttack.getSubimage((i*96)+10, 16, 86, 80);
                image[1][i] = imgRunAttack.getSubimage((i*96)+10, 16, 86, 80);
            }
            for (int i = 0; i < 6; i++) {
                image[2][i] = imgRun.getSubimage((i*96)+10, 16, 86, 80);
                image[3][i] = imgIdle.getSubimage((i*96)+10, 16, 86, 80);
            }
        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);
        }

    }

    public void animationLoop() {
        animationTick++;
        if (animationTick >= 20) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= animationFrames() ) {
                animationIndex = 0;
            }
        }

    }

    private int animationFrames() {
        if (animation == 0 || animation == 1) {
            return 4;
        }
        else if (animation == 2 || animation == 3) {
            return 6;
        }
        return 4;
    }

    public void move() {
        animation = 3;
        if (right == true) {
            posX += 1;
            hitbox.x +=1;
            animation = 2;
        }
        if (left == true) {
            posX -= 1;
            hitbox.x -=1;
            animation = 2;
        }
        if (up == true) {
            posY -= 1;
            hitbox.y -=1;
            animation = 2;
        }
        if (down == true) {
            posY += 1;
            hitbox.y +=1;
            animation = 2;
        }
        if (attack == true && animation == 2) {
            animation = 1;
        }
        else if (attack == true) {
            animation = 0;
        }
        if (collision(posX, posY, 70, 70) == true) {
            System.out.println("collision");
        }
        else if (collision(posX, posY, 70, 100) == false) {
            System.out.println("collision-false");
        }
    }

    public void render(Graphics g) {

        g.drawImage(image[animation][animationIndex], (int) posX, (int) posY, 160, 160, null);
        hitboxDraw(g);
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
    public void attack(boolean attack) {
        this.attack = attack;
    }



}
