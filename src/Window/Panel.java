package Window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panel extends JPanel {

    public static final int Height = 480;
    public static final int Width = 640;

    public Panel() {
        this.setBackground(new Color(0, 33, 153));

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.drawRect(10, 10, 200, 200);
    }


}
