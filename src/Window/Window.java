package Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window extends JFrame {


    public Window() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        addPanel();
    }

    private void addPanel() {
        Panel panel = new Panel();
        this.add(panel);
        this.setBounds(10, 10, 1000, 1000);

    }
}
