package Characters;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import Items.*;

public class Player extends Character {
    private BufferedImage[][] image;    //array för animations-bilder
    private int animation = 3;  //nuvarande animation
    //bool för action
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    private boolean attack;
    //animation
    private int animationIndex;
    private int animationTick;
    //instanser av items
    private Weapon weapon;
    private MeleeWeapon meleeWeapon;
    private RangedWeapon rangedWeapon;
    private Equipment equipment;

    private int startMaxHp = maxHp;   //sätter grund maxHp

    //konstruktor för Player-klassen + equipments
    public Player(float posX, float posY, int width, int height, int maxHp) {
        super(posX, posY, width, height, maxHp);
        splitAnimations();
        hitbox(posX + 32, posY + 60, 76, 100);
        //skapar items + equip
        Equipment armor1 = new Equipment(1, "Armor", 1, 1);
        MeleeWeapon sword = new MeleeWeapon(1, "sword1");
        equipItems(armor1, sword);
        RangedWeapon bow = new RangedWeapon(1, "bow1");
        equipItems(armor1, bow);
        hp = maxHp;
    }

    //equipar items
    private void equipItems(Equipment equipment, Item item) {
        this.equipment = equipment;
        maxHp = startMaxHp + equipment.getHpBonus();
        //kollar typ av item och equipar
        if (item instanceof MeleeWeapon) {
            this.meleeWeapon = (MeleeWeapon) item;
            System.out.println("svärd");
            System.out.println(MeleeWeapon.getName());
        }
        if (item instanceof RangedWeapon) {
            this.rangedWeapon = (RangedWeapon) item;
            System.out.println("ranged");
            System.out.println(RangedWeapon.getName());
        }
    }

    //splittar animations-set i bilder
    private void splitAnimations() {
        try {
            BufferedImage imgIdle = ImageIO.read(new File("src/Sprites/Idle.png"));
            BufferedImage imgRun = ImageIO.read(new File("src/Sprites/Run.png"));
            BufferedImage imgAttack = ImageIO.read(new File("src/Sprites/Attack_1.png"));
            BufferedImage imgRunAttack = ImageIO.read(new File("src/Sprites/Run+Attack.png"));
            image = new BufferedImage[4][6];
            for (int i = 0; i < 4; i++) {
                image[0][i] = imgAttack.getSubimage((i * 96) + 10, 16, 86, 80);
                image[1][i] = imgRunAttack.getSubimage((i * 96) + 10, 16, 86, 80);
            }
            for (int i = 0; i < 6; i++) {
                image[2][i] = imgRun.getSubimage((i * 96) + 10, 16, 86, 80);
                image[3][i] = imgIdle.getSubimage((i * 96) + 10, 16, 86, 80);
            }
        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);
        }
    }

    //loop för cykla genom animationer
    public void animationLoop() {
        animationTick++;
        if (animationTick >= 20) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= animationFrames()) {
                animationIndex = 0;
            }
        }
    }

    //hämtar antalet frames för olika animationer
    private int animationFrames() {
        if (animation == 0 || animation == 1) {
            return 4;
        } else if (animation == 2 || animation == 3) {
            return 6;
        }
        return 4;
    }

    //spelkaraktärens rörelse
    public void move() {
        animation = 3;  //stillastående

        //kollar vad spelaren gör och kollision
        if (right == true && collision(posX + 32, posY + 60, 76, 100, 4) == false) {
            posX += 1;
            hitbox.x += 1;
            animation = 2;
        }
        if (left == true && collision(posX + 32, posY + 60, 76, 100, 3) == false) {
            posX -= 1;
            hitbox.x -= 1;
            animation = 2;
        }
        if (up == true && collision(posX + 32, posY + 60, 76, 100, 2) == true) {
            velocityY = -jumpForce;
        }
        if (attack == true && animation == 2) {
            animation = 1;
        } else if (attack == true) {
            animation = 0;
        }

        //räknar gravitation och flyttar spelaren i y-led
        velocityY += gravity;
        if (velocityY > 4) {
            velocityY = 4;
        }
        if (collision(posX + 32, posY + 60, 76, 100, 1) == true) {
            velocityY=0;
            posY += 1;
            hitbox.y += 1;
        }
        else if (velocityY < 0) {
            posY += velocityY;
            hitbox.y += velocityY;
        }
        else if (collision(posX + 32, posY + 60, 76, 100, 2) == false) {
            posY += velocityY;
            hitbox.y += velocityY;
        }
        else {
            velocityY=0;
        }
    }

    //ritar spelaren och hitbox
    public void render(Graphics g) {
        g.drawImage(image[animation][animationIndex], (int) posX, (int) posY, 160, 160, null);
        hitboxDraw(g);
    }

    //metoder för sätta rörelserikntingar och attack
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
