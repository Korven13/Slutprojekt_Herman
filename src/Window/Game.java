package Window;

import Window.Window;
import Window.Panel;
import Characters.Player;

import java.awt.*;

public class Game {
    private Window window;
    private Panel panel;
    Player player;

    public Game() {
        player = new Player(200, 200);
        panel = new Panel(this);
        window = new Window(panel);

    }

    public void render(Graphics g) {
        player.render(g);
    }


}
