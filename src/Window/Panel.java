package Window;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import Characters.Inputs;


public class Panel extends JPanel {
    private Inputs inputs;
    private Game game;

    public Panel(Game game) {
        inputs = new Inputs(this);
        this.game = game;
        setPreferredSize(new Dimension(1000, 600));
        this.setFocusable(true);
        addKeyListener(inputs);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
        //g.drawImage(image, 100, 100, null);

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

