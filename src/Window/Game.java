package Window;

import Characters.Player;

import java.awt.*;

public class Game implements Runnable {
    private Window window;
    private Panel panel;
    Player player;
    private Thread thread;

    public Game() {
        player = new Player(200, 200);
        panel = new Panel(this);
        window = new Window(panel);
        thread = new Thread(this);
        thread.start();
    }


    public void render(Graphics g) {
        player.render(g);
    }


    public void run() {

        double frameTime = 1000000000 / 120;
        double updateTime = 1000000000 / 200;

        long startTime = System.nanoTime();
        long currentTime;

        double frameDelta = 0;
        double timeDelta = 0;



        while (true) {

            currentTime = System.nanoTime();

            frameDelta += (currentTime - startTime) / frameTime;
            timeDelta += (currentTime - startTime) / updateTime;
            startTime = currentTime;

            if (frameDelta >= 1) {
                panel.repaint();
                frameDelta --;
            }

            if (timeDelta >= 1) {
                player.move();
                player.animationLoop();
                timeDelta --;
            }

        }




    }
    public Player getPlayer() {
        return player;
    }


}
