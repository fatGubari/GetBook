import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JavaProject5 extends JFrame {
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

    JavaProject5(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\seven.jpg")));
        connect();

        JLabel psy = new JLabel("Psychology Book");
        psy.setBounds(600,0,500,70);
        psy.setFont(new Font("Fo",Font.PLAIN,25));
        psy.setForeground(Color.WHITE);
        add(psy);

        JLabel psy1 = new JLabel();
        psy1.setIcon(new ImageIcon("src\\Java Project images\\phy1.jpg"));
        size = psy1.getPreferredSize();
        psy1.setBounds(50, 90, size.width, size.height);
        add(psy1);
        price_k = new JLabel("12.50$");
        price_k.setBounds(220, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p1 = new JButton("Buy");
        buy_p1.setBackground(Color.GREEN);
        buy_p1.setBounds(220, 190,55,30);
        add(buy_p1);
        buy_p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p1) {
                    try {
                        string = "select * from book_table where book_name='the everything'";
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

        JLabel psy2 = new JLabel();
        psy2.setIcon(new ImageIcon("src\\Java Project images\\phy2.jpg"));
        size = psy2.getPreferredSize();
        psy2.setBounds(50, 360, size.width, size.height);
        add(psy2);
        price_k = new JLabel("34.11$");
        price_k.setBounds(220, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p4 = new JButton("Buy");
        buy_p4.setBackground(Color.GREEN);
        buy_p4.setBounds(220, 440,55,30);
        add(buy_p4);
        buy_p4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p4) {
                    try {
                        string = "select * from book_table where book_name='the litter book of psychology'";
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

        JLabel psy3 = new JLabel();
        psy3.setIcon(new ImageIcon("src\\Java Project images\\phy3.jpg"));
        size = psy3.getPreferredSize();
        psy3.setBounds(500, 90, size.width, size.height);
        add(psy3);
        price_k = new JLabel("10.01$");
        price_k.setBounds(670, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p2 = new JButton("Buy");
        buy_p2.setBackground(Color.GREEN);
        buy_p2.setBounds(670, 190,55,30);
        add(buy_p2);
        buy_p2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p2) {
                    try {
                        string = "select * from book_table where book_name='the psychology of learning'";
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

        JLabel psy4 = new JLabel();
        psy4.setIcon(new ImageIcon("src\\Java Project images\\phy4.jpg"));
        size = psy4.getPreferredSize();
        psy4.setBounds(500, 360, size.width, size.height);
        add(psy4);
        price_k = new JLabel("6.99$");
        price_k.setBounds(650, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p5 = new JButton("Buy");
        buy_p5.setBackground(Color.GREEN);
        buy_p5.setBounds(650, 440,55,30);
        add(buy_p5);
        buy_p5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p5) {
                    try {
                        string = "select * from book_table where book_name='patriarchy blues'";
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

        JLabel psy5 = new JLabel();
        psy5.setIcon(new ImageIcon("src\\Java Project images\\phy5.jpg"));
        size = psy5.getPreferredSize();
        psy5.setBounds(915, 90, size.width, size.height);
        add(psy5);
        price_k = new JLabel("11.19$");
        price_k.setBounds(1080, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p3 = new JButton("Buy");
        buy_p3.setBackground(Color.GREEN);
        buy_p3.setBounds(1080, 190,55,30);
        add(buy_p3);
        buy_p3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p3) {
                    try {
                        string = "select * from book_table where book_name='the power of habit'";
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

        JLabel psy6 = new JLabel();
        psy6.setIcon(new ImageIcon("src\\Java Project images\\phy6.jpg"));
        size = psy6.getPreferredSize();
        psy6.setBounds(915, 360, size.width, size.height);
        add(psy6);
        price_k = new JLabel("18.05$");
        price_k.setBounds(1080, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_p6 = new JButton("Buy");
        buy_p6.setBackground(Color.GREEN);
        buy_p6.setBounds(1080, 440,55,30);
        add(buy_p6);
        buy_p6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_p6) {
                    try {
                        string = "select * from book_table where book_name='dark psychology'";
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
