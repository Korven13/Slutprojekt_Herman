package Window;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Characters.Inputs;
import Game.Game;


public class Panel extends JPanel {
    private Inputs inputs;
    private Game game;

    public Panel(Game game) {
        inputs = new Inputs(this);
        this.game = game;
        setPreferredSize(new Dimension(1152, 704));
        this.setFocusable(true);
        addKeyListener(inputs);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        grid(g);
        //g.drawImage(image, 100, 100, null);

    }

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

    public Game getGame() {
        return game;
    }

    /*
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("CLick");
        switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT:

                game.player.posX += 10;
                break;
            case KeyEvent.VK_LEFT:
                game.player.posX -= 10;
                break;
            case KeyEvent.VK_DOWN:
                game.player.posY += 10;
                break;
            case KeyEvent.VK_UP:
                game.player.posY -= 10;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
     */

}

