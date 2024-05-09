package Window;

import java.awt.*;

import javax.swing.JPanel;

import Characters.Inputs;
import Game.Game;


public class Panel extends JPanel {
    //hantering av inmatning av tangentbord och spel
    private Inputs inputs;
    private Game game;

    //konstruktor för Panel-klassen
    public Panel(Game game) {
        inputs = new Inputs(this);
        this.game = game;
        setPreferredSize(new Dimension(1152, 704));
        this.setFocusable(true);
        addKeyListener(inputs);

    }

    //ritar spellement, rutnät och spelinstruktioner
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        grid(g);
        text(g);

    }

    //ritar textinstruktioner för spelkontrollerna
    private void text (Graphics g) {
        Font font = new Font("monospaced", Font.BOLD, 36);
        g.setFont(font);
        g.drawString("> - Gå höger", 100, 80);
        g.drawString("< - Gå vänster", 100, 110);
        g.drawString("^ - Hoppa", 100, 140);
        g.drawString("Shft - Attack", 100, 170);
    }

    //ritar rutnät för alla tiles
    private void grid(Graphics g) {
        int x;
        int y;
        for (int i = 0; i < 22; i++) {
            y = i * 32;
            g.drawLine(0, y, 1152, y);

        }
        for (int j = 0; j < 36; j++) {
            x = j * 32;
            g.drawLine(x, 0, x, 704);

        }

    }

    //getter metod för game instansen
    public Game getGame() {
        return game;
    }

}

