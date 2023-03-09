import javax.swing.*;
import java.awt.*;

public class JavaProject7 extends JFrame {
    Dimension size;

    JavaProject7(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\seven.jpg")));

        JLabel about = new JLabel();
        about.setIcon(new ImageIcon("src\\Java Project images\\about us.png"));
        size = about.getPreferredSize();
        about.setBounds(230, 100, size.width, size.height);
        add(about);
    }
}
