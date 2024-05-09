package Window;

import javax.swing.JFrame;


public class Window extends JFrame {
    private JFrame jframe;

    //konstruktor för Window-klassen
    public Window(Panel Panel) {
        //lägger till panelen till fönstret, samt specifikationer för fönstret.
        jframe = new JFrame();
        jframe.add(Panel);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);


    }


}
