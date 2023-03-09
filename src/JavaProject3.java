import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JavaProject3 extends JFrame {
    Dimension size;
    JLabel price_k;
    Connection con;
    String string,bookN,bookP;
    PreparedStatement pst;
    ResultSet resultSet;
    JavaProject10[] listInfo = new JavaProject10[1];

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src/DB/DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject3(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\seven.jpg")));
        connect();

        JLabel kids = new JLabel("Children's Book");
        kids.setBounds(600,0,500,70);
        kids.setFont(new Font("Fo",Font.PLAIN,25));
        kids.setForeground(Color.WHITE);
        add(kids);

        JLabel kids1 = new JLabel();
        kids1.setIcon(new ImageIcon("src\\Java Project images\\kids1.jpg"));
        size = kids1.getPreferredSize();
        kids1.setBounds(50, 90, size.width, size.height);
        add(kids1);
        price_k = new JLabel("12.50$");
        price_k.setBounds(220, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k1 = new JButton("Buy");
        buy_k1.setBackground(Color.GREEN);
        buy_k1.setBounds(220, 190,55,30);
        add(buy_k1);
        buy_k1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k1) {
                    try {
                        string = "select * from book_table where book_name='books children love'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel kids2 = new JLabel();
        kids2.setIcon(new ImageIcon("src\\Java Project images\\kids2.png"));
        size = kids2.getPreferredSize();
        kids2.setBounds(50, 360, size.width, size.height);
        add(kids2);
        price_k = new JLabel("34.11$");
        price_k.setBounds(220, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k4 = new JButton("Buy");
        buy_k4.setBackground(Color.GREEN);
        buy_k4.setBounds(220, 440,55,30);
        add(buy_k4);
        buy_k4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k4) {
                    try {
                        string = "select * from book_table where book_name='the cat in the hat'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel kids3 = new JLabel();
        kids3.setIcon(new ImageIcon("src\\Java Project images\\kids3.jpg"));
        size = kids3.getPreferredSize();
        kids3.setBounds(500, 90, size.width, size.height);
        add(kids3);
        price_k = new JLabel("10.01$");
        price_k.setBounds(640, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k2 = new JButton("Buy");
        buy_k2.setBackground(Color.GREEN);
        buy_k2.setBounds(640, 190,55,30);
        add(buy_k2);
        buy_k2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k2) {
                    try {
                        string = "select * from book_table where book_name='the srylarks war'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel kids4 = new JLabel();
        kids4.setIcon(new ImageIcon("src\\Java Project images\\kids4.jpg"));
        size = kids4.getPreferredSize();
        kids4.setBounds(500, 360, size.width, size.height);
        add(kids4);
        price_k = new JLabel("6.99$");
        price_k.setBounds(650, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k5 = new JButton("Buy");
        buy_k5.setBackground(Color.GREEN);
        buy_k5.setBounds(650, 440,55,30);
        add(buy_k5);
        buy_k5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k5) {
                    try {
                        string = "select * from book_table where book_name='charlottes web'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                         JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel kids5 = new JLabel();
        kids5.setIcon(new ImageIcon("src\\Java Project images\\kids5.jpg"));
        size = kids5.getPreferredSize();
        kids5.setBounds(915, 90, size.width, size.height);
        add(kids5);
        price_k = new JLabel("11.19$");
        price_k.setBounds(1080, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k3 = new JButton("Buy");
        buy_k3.setBackground(Color.GREEN);
        buy_k3.setBounds(1080, 190,55,30);
        add(buy_k3);
        buy_k3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k3) {
                    try {
                        string = "select * from book_table where book_name='the most beautiful child'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel kids6 = new JLabel();
        kids6.setIcon(new ImageIcon("src\\Java Project images\\kids6.jpg"));
        size = kids6.getPreferredSize();
        kids6.setBounds(915, 360, size.width, size.height);
        add(kids6);
        price_k = new JLabel("18.05$");
        price_k.setBounds(1080, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_k6 = new JButton("Buy");
        buy_k6.setBackground(Color.GREEN);
        buy_k6.setBounds(1080, 440,55,30);
        add(buy_k6);
        buy_k6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_k6) {
                    try {
                        string = "select * from book_table where book_name='the most beautiful thing'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
