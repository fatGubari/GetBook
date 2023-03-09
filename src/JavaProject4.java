import javax.swing.*;
import java.awt.*;

public class JavaProject4 extends JFrame {
    Dimension size;
    JLabel price_k;
    JavaProject4(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\seven.jpg")));

        JLabel rel = new JLabel("Religion Book");
        rel.setBounds(600,0,500,70);
        rel.setFont(new Font("Fo",Font.PLAIN,25));
        rel.setForeground(Color.WHITE);
        add(rel);

        JLabel rel1 = new JLabel();
        rel1.setIcon(new ImageIcon("src\\Java Project images\\religion1.png"));
        size = rel1.getPreferredSize();
        rel1.setBounds(50, 70, size.width, size.height);
        add(rel1);
        price_k = new JLabel("12.50$");
        price_k.setBounds(220, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r1 = new JButton("Buy");
        buy_r1.setBackground(Color.GREEN);
        buy_r1.setBounds(220, 190,55,30);
        add(buy_r1);

        JLabel rel2 = new JLabel();
        rel2.setIcon(new ImageIcon("src\\Java Project images\\religion2.jpg"));
        size = rel2.getPreferredSize();
        rel2.setBounds(50, 340, size.width, size.height);
        add(rel2);
        price_k = new JLabel("34.11$");
        price_k.setBounds(220, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r4 = new JButton("Buy");
        buy_r4.setBackground(Color.GREEN);
        buy_r4.setBounds(220, 440,55,30);
        add(buy_r4);

        JLabel rel3 = new JLabel();
        rel3.setIcon(new ImageIcon("src\\Java Project images\\religion3.jpg"));
        size = rel3.getPreferredSize();
        rel3.setBounds(500, 70, size.width, size.height);
        add(rel3);
        price_k = new JLabel("10.01$");
        price_k.setBounds(640, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r2 = new JButton("Buy");
        buy_r2.setBackground(Color.GREEN);
        buy_r2.setBounds(640, 190,55,30);
        add(buy_r2);

        JLabel rel4 = new JLabel();
        rel4.setIcon(new ImageIcon("src\\Java Project images\\religion4.jpg"));
        size = rel4.getPreferredSize();
        rel4.setBounds(500, 340, size.width, size.height);
        add(rel4);
        price_k = new JLabel("6.99$");
        price_k.setBounds(650, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r5 = new JButton("Buy");
        buy_r5.setBackground(Color.GREEN);
        buy_r5.setBounds(650, 440,55,30);
        add(buy_r5);

        JLabel rel5 = new JLabel();
        rel5.setIcon(new ImageIcon("src\\Java Project images\\religion5.jpg"));
        size = rel5.getPreferredSize();
        rel5.setBounds(915, 70, size.width, size.height);
        add(rel5);
        price_k = new JLabel("11.19$");
        price_k.setBounds(1080, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r3 = new JButton("Buy");
        buy_r3.setBackground(Color.GREEN);
        buy_r3.setBounds(1080, 190,55,30);
        add(buy_r3);

        JLabel rel6 = new JLabel();
        rel6.setIcon(new ImageIcon("src\\Java Project images\\religion6.jpg"));
        size = rel6.getPreferredSize();
        rel6.setBounds(915, 340, size.width, size.height);
        add(rel6);
        price_k = new JLabel("18.05$");
        price_k.setBounds(1080, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_r6 = new JButton("Buy");
        buy_r6.setBackground(Color.GREEN);
        buy_r6.setBounds(1080, 440,55,30);
        add(buy_r6);
    }
}
