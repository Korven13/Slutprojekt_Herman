package Characters;


import java.awt.*;
import java.awt.geom.Rectangle2D;

import Game.GameMap;

public class Character {
    //karaktären position och dimension
    protected float posX;
    protected float posY;
    protected int width;
    protected int height;

    protected Rectangle2D.Float hitbox;
    //gravitationskonstant, hoppstyrka, vertikal hastighet
    protected static final double gravity = 0.07;
    protected static final double jumpForce = 4.3;
    protected double velocityY;
    //karaktärs hp, maxhp, armor
    protected int hp;
    protected int maxHp;
    protected int armor;

    //konstruktor för Character-klassen
    public Character(float posX, float posY, int width, int height, int maxHp) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.maxHp = maxHp;
    }

    //skapar hitbox för karaktären
    protected void hitbox(float posX, float posY, int width, int height) {
        hitbox = new Rectangle2D.Float(posX, posY, width, height);
    }

    //ritar hitboxen
    protected void hitboxDraw(Graphics g) {
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    //kollar kollision med kartan
    protected boolean collision(float posX, float posY, int width, int height, int direction) {
        //räknar karaktärens position i tiles
        int xTileLeft = (int) posX / 32;
        int xTileRight = (int) (posX + width) / 32;
        int yTileTop = (int) posY / 32;
        int yTileBot = (int) (posY + height) / 32;
        int widthTiles = 1 + width / 32;
        int heightTiles = 1 + height / 32;

        //kollar kollision för olika riktningar
        if (direction == 1) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posY <= 0 || GameMap.getMapData(xTileLeft + i, yTileTop) != 3) {
                        return true;
                    }
                }
            }
        }
        if (direction == 2) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posY + height >= 704 || GameMap.getMapData(xTileLeft + i, yTileBot) != 3) {
                        return true;
                    }
                }
            }
        }
        if (direction == 3) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posX <= 0 || GameMap.getMapData(xTileLeft, yTileTop + j) != 3) {
                        return true;
                    }
                }
            }
        }

        if (direction == 4) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posX + width >= 1152 || GameMap.getMapData(xTileRight, yTileTop + j) != 3) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

}
