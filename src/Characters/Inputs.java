package Characters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Window.Panel;

public class Inputs implements KeyListener{
    private Panel panel;

    //konstruktor för Input-klassen
    public Inputs(Panel panel) {
        this.panel = panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    //kollar när tangent trycks ned
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                panel.getGame().getPlayer().moveRight(true);
                break;
            case KeyEvent.VK_LEFT:
                panel.getGame().getPlayer().moveLeft(true);
                break;
            case KeyEvent.VK_DOWN:
                panel.getGame().getPlayer().moveDown(true);
                break;
            case KeyEvent.VK_UP:
                panel.getGame().getPlayer().moveUp(true);
                break;
            case KeyEvent.VK_SHIFT:
                panel.getGame().getPlayer().attack(true);
                break;
        }
    }

    //kollar när en tangent släpps
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                panel.getGame().getPlayer().moveRight(false);
                break;
            case KeyEvent.VK_LEFT:
                panel.getGame().getPlayer().moveLeft(false);
                break;
            case KeyEvent.VK_DOWN:
                panel.getGame().getPlayer().moveDown(false);
                break;
            case KeyEvent.VK_UP:
                panel.getGame().getPlayer().moveUp(false);
                break;
            case KeyEvent.VK_SHIFT:
                panel.getGame().getPlayer().attack(false);
                break;
        }
    }
}

