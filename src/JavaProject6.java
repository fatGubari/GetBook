import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JavaProject6 extends JFrame {
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

    JavaProject6(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\seven.jpg")));
        connect();

        JLabel rom = new JLabel("Romantic Book");
        rom.setBounds(600,0,500,70);
        rom.setFont(new Font("Fo",Font.PLAIN,25));
        rom.setForeground(Color.WHITE);
        add(rom);

        JLabel rom1 = new JLabel();
        rom1.setIcon(new ImageIcon("src\\Java Project images\\rom1.jpg"));
        size = rom1.getPreferredSize();
        rom1.setBounds(50, 90, size.width, size.height);
        add(rom1);
        price_k = new JLabel("12.50$");
        price_k.setBounds(220, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro1 = new JButton("Buy");
        buy_ro1.setBackground(Color.GREEN);
        buy_ro1.setBounds(220, 190,55,30);
        add(buy_ro1);
        buy_ro1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro1) {
                    try {
                        string = "select * from book_table where book_name='dark witch'";
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

        JLabel rom2 = new JLabel();
        rom2.setIcon(new ImageIcon("src\\Java Project images\\rom2.jpg"));
        size = rom2.getPreferredSize();
        rom2.setBounds(50, 360, size.width, size.height);
        add(rom2);
        price_k = new JLabel("34.11$");
        price_k.setBounds(220, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro4 = new JButton("Buy");
        buy_ro4.setBackground(Color.GREEN);
        buy_ro4.setBounds(220, 440,55,30);
        add(buy_ro4);
        buy_ro4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro4) {
                    try {
                        string = "select * from book_table where book_name='this woven kingdom'";
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

        JLabel rom3 = new JLabel();
        rom3.setIcon(new ImageIcon("src\\Java Project images\\rom3.jpg"));
        size = rom3.getPreferredSize();
        rom3.setBounds(500, 90, size.width, size.height);
        add(rom3);
        price_k = new JLabel("10.01$");
        price_k.setBounds(640, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro2 = new JButton("Buy");
        buy_ro2.setBackground(Color.GREEN);
        buy_ro2.setBounds(640, 190,55,30);
        add(buy_ro2);
        buy_ro2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro2) {
                    try {
                        string = "select * from book_table where book_name='weather girl'";
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

        JLabel rom4 = new JLabel();
        rom4.setIcon(new ImageIcon("src\\Java Project images\\rom4.jpg"));
        size = rom4.getPreferredSize();
        rom4.setBounds(500, 360, size.width, size.height);
        add(rom4);
        price_k = new JLabel("6.99$");
        price_k.setBounds(650, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro5 = new JButton("Buy");
        buy_ro5.setBackground(Color.GREEN);
        buy_ro5.setBounds(650, 440,55,30);
        add(buy_ro5);
        buy_ro5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro5) {
                    try {
                        string = "select * from book_table where book_name='it ends with us'";
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

        JLabel rom5 = new JLabel();
        rom5.setIcon(new ImageIcon("src\\Java Project images\\rom5.jpg"));
        size = rom5.getPreferredSize();
        rom5.setBounds(915, 90, size.width, size.height);
        add(rom5);
        price_k = new JLabel("11.19$");
        price_k.setBounds(1080, 120,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro3 = new JButton("Buy");
        buy_ro3.setBackground(Color.GREEN);
        buy_ro3.setBounds(1080, 190,55,30);
        add(buy_ro3);
        buy_ro3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro3) {
                    try {
                        string = "select * from book_table where book_name='reminders of him'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                            SavedData.BOOKNAME=bookN;
                            SavedData.BOOKPRICE=bookP;
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");;
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel rom6 = new JLabel();
        rom6.setIcon(new ImageIcon("src\\Java Project images\\rom6.jpg"));
        size = rom6.getPreferredSize();
        rom6.setBounds(915, 360, size.width, size.height);
        add(rom6);
        price_k = new JLabel("18.05$");
        price_k.setBounds(1080, 370,90,60);
        price_k.setForeground(Color.WHITE);
        price_k.setFont(new Font("Fo",Font.PLAIN,20));
        add(price_k);
        JButton buy_ro6 = new JButton("Buy");
        buy_ro6.setBackground(Color.GREEN);
        buy_ro6.setBounds(1080, 440,55,30);
        add(buy_ro6);
        buy_ro6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy_ro6) {
                    try {
                        string = "select * from book_table where book_name='book lovers'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            String bookN = resultSet.getString("book_name");
                            String bookP = resultSet.getString("book_price");
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
