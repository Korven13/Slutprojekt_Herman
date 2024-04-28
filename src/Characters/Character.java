package Characters;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import Game.GameMap;

public class Character {
    public float posX;
    public float posY;
    public int width;
    public int height;
    public Rectangle2D.Float hitbox;

    public Character(float posX, float posY, int width, int height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

    }

    public void hitbox(float posX, float posY, int width, int height) {
        hitbox = new Rectangle2D.Float(posX, posY, width, height);
    }

    public void hitboxDraw(Graphics g) {
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int)hitbox.width, (int) hitbox.height);
    }

    public boolean collision(float posX, float posY, int width, int height) {
        int xTile = (int) posX/32;
        int yTile = (int) posY/32;
        int widthTiles =  1+ width/32;
        int heightTiles =  1+ height/32;

        System.out.println("xTile: " + xTile);
        System.out.println("yTile: " + yTile);
        System.out.println("widthTiles: " + widthTiles);
        System.out.println("heightTiles: " + heightTiles);

        for (int i = 0; i < widthTiles; i++) {
            if (GameMap.getMapData(xTile+i, yTile)!=3 || GameMap.getMapData(xTile+i, yTile+ height/32)!=3) {
                return true;
            }

        }

        for (int i = 0; i < heightTiles; i++) {
            if (GameMap.getMapData(xTile, yTile+i)!=3 || GameMap.getMapData(xTile+ width/32, yTile+i)!=3) {
                return true;
            }
        }


        if (posX <=0 || posX+width >= 1152 || posY <=0 || posY+height >= 704) {
            return true;
        }
        else {
            return false;
        }
    }

}
