package Characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Window.Panel;
import Window.Game;

public class Inputs implements KeyListener{
    private Panel panel;

    public Inputs(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("CLick");
        switch (e.getKeyCode()) {

            case KeyEvent.VK_RIGHT:
                panel.getGame().getPlayer().moveRight(true);

                break;
            case KeyEvent.VK_LEFT:
                panel.getGame().getPlayer().posX -= 10;
                break;
            case KeyEvent.VK_DOWN:
                panel.getGame().getPlayer().posY += 10;
                break;
            case KeyEvent.VK_UP:
                panel.getGame().getPlayer().posY -= 10;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
