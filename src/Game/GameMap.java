package Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameMap {
    private int[][] mapData = {
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,0,1,1,1,2,3,3,3,3,3,3},
            {3,3,3,3,3,3,3,3,3,3,3,3,3,16,17,17,17,18,3,3,3,3,3,3},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,98,17,17,17,96,1,1,1,1,1,1},
            {17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17},
        };
    private BufferedImage[] mapTile;
    private Game game;

    public GameMap(Game game) {
        this.game = game;
        splitMap();

    }

    private void splitMap() {
        try {
            BufferedImage mapImg = ImageIO.read(new File("src/Sprites/TX Tileset Ground.png"));
            mapTile = new BufferedImage[256];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    mapTile[i*16+j] = mapImg.getSubimage(j * 32, i * 32, 32, 32);
                }
            }

        } catch (IOException e) {
            System.out.println("fel");
            throw new RuntimeException(e);
        }
    }

    public void drawMap(Graphics g) {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 24; j++) {
                g.drawImage(mapTile[mapData[i][j]], 32 * j, 32 * i, 32, 32, null);
            }
        }

    }
    public void update() {

    }

}
