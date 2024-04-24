package Window;

import javax.swing.JFrame;


public class Window extends JFrame {
    private JFrame jframe;

    public Window(Panel Panel) {
        jframe = new JFrame();
        jframe.add(Panel);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);


    }


}
