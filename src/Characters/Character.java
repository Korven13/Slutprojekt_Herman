package Characters;


import java.awt.*;
import java.awt.geom.Rectangle2D;

import Game.GameMap;

public class Character {
    protected float posX;
    protected float posY;
    protected int width;
    protected int height;
    protected Rectangle2D.Float hitbox;
    protected static final double gravity = 0.07;
    protected static final double jumpForce = 4.3;
    protected double velocityY;

    public Character(float posX, float posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    protected void hitbox(float posX, float posY, int width, int height) {
        hitbox = new Rectangle2D.Float(posX, posY, width, height);
    }

    protected void hitboxDraw(Graphics g) {
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    protected boolean collision(float posX, float posY, int width, int height, int direction) {
        int xTileLeft = (int) posX / 32;
        int xTileRight = (int) (posX + width) / 32;
        int yTileTop = (int) posY / 32;
        int yTileBot = (int) (posY + height) / 32;
        int widthTiles = 1 + width / 32;
        int heightTiles = 1 + height / 32;

        System.out.println("xTile: " + xTileLeft);
        System.out.println("yTile: " + yTileTop);
        System.out.println("widthTiles: " + widthTiles);
        System.out.println("heightTiles: " + heightTiles);

        /*
        for (int i = 0; i < widthTiles; i++) {
            if (GameMap.getMapData(xTileLeft + i, yTileTop) != 3 || GameMap.getMapData(xTileLeft + i, yTileBot) != 3) {
                return true;
            }

        }
        for (int i = 0; i < heightTiles; i++) {
            if (GameMap.getMapData(xTileLeft, yTileTop + i) != 3 || GameMap.getMapData(xTileRight, yTileTop + i) != 3) {
                return true;
            }
        }
         */


        if (direction == 1) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posY <= 0 || GameMap.getMapData(xTileLeft + i, yTileTop) != 3) {
                        System.out.println("3");
                        return true;
                    }
                }
            }
        }
        if (direction == 2) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posY + height >= 704 || GameMap.getMapData(xTileLeft + i, yTileBot) != 3) {
                        System.out.println("4");
                        return true;
                    }
                }
            }
        }
        if (direction == 3) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posX <= 0 || GameMap.getMapData(xTileLeft, yTileTop + j) != 3) {
                        System.out.println("1");
                        return true;
                    }
                }
            }
        }

        if (direction == 4) {
            for (int i = 0; i < widthTiles; i++) {
                for (int j = 0; j < heightTiles; j++) {
                    if (posX + width >= 1152 || GameMap.getMapData(xTileRight, yTileTop + j) != 3) {
                        System.out.println("2");
                        return true;
                    }
                }
            }
        }

                /*
                if (posY <= 0 || GameMap.getMapData(xTileLeft + i, yTileTop) != 3) {
                    System.out.println("3");
                    return 3;
                }
                if (posY + height >= 704 || GameMap.getMapData(xTileLeft + i, yTileBot) != 3) {
                    System.out.println("4");
                    return 4;
                }

                if (posX <= 0 || GameMap.getMapData(xTileLeft, yTileTop + j) != 3) {
                    System.out.println("1");
                    return 1;

                }
                if (posX + width >= 1152 || GameMap.getMapData(xTileRight, yTileTop + j) != 3) {
                    System.out.println("2");
                    return 2;
                }

                 */


        System.out.println("0");
        return false;

    }

    public void jump () {
        if (collision(posX, posY, width, height, 2)==true) {
            velocityY = jumpForce;
        }


    }


}
