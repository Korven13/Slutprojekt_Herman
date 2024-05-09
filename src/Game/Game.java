package Game;

import Characters.Player;
import Window.Panel;
import Window.Window;

import java.awt.*;

public class Game implements Runnable {
    //instanser av window, panel, player, thread, gameMap
    private Window window;
    private Panel panel;
    private Player player;
    private Thread thread;
    private GameMap gameMap;

    //konstruktor för Game-klassen
    public Game() {
        //skapar instanser av spelkartan, spelare, panel, fönster, thread, samt startar en thread
        gameMap = new GameMap(this);
        player = new Player(200, 200, 86, 80, 100);
        panel = new Panel(this);
        window = new Window(panel);
        thread = new Thread(this);
        thread.start();
    }

    //ritar spelkartan och spelarkaraktären
    public void render(Graphics g) {
        gameMap.drawMap(g);
        player.render(g);

    }

    //loop för uppdater och rita spelet
    public void run() {
        //deklarerar spelets tick
        double frameTime = 1000000000 / 120;
        double updateTime = 1000000000 / 200;
        //variabler för tiden
        long startTime = System.nanoTime();
        long currentTime;
        //
        double frameDelta = 0;
        double timeDelta = 0;

        //huvudloop
        while (true) {
            //hämtar nuvarande tiden
            currentTime = System.nanoTime();
            //räknar tidsdeltat mellan senaste uppdatering
            frameDelta += (currentTime - startTime) / frameTime;
            timeDelta += (currentTime - startTime) / updateTime;
            startTime = currentTime;

            //kollar om det ska ritas ny bild
            if (frameDelta >= 1) {
                //ritar panelen på nytt
                panel.repaint();
                frameDelta--;
            }

            //kollar om spelets ska uppdateras
            if (timeDelta >= 1) {
                //låter spelaren röra sig, uppdaterar karaktärs-animation
                player.move();
                player.animationLoop();
                timeDelta--;
            }
        }
    }
    //getter för spelare
    public Player getPlayer() {
        return player;
    }

}
