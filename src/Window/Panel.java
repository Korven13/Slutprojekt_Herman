package Window;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Characters.Player;

import static Characters.Player.image;

public class Panel extends JPanel implements KeyListener {

    private Game game;

    public Panel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        //g.drawImage(image, 100, 100, null);

    }

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

}

