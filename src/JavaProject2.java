import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaProject2 extends JFrame implements ActionListener {
    JLabel adv, popular , trend,request,price;
    JTextField request_text;
    JButton send,confirm;
    JPanel p1,p2;
    JMenu cat,saved,about_program;
    JMenuBar bar;
    JMenuItem children, /*religion,*/ psychology,romantic,about_us,exit,bought,delete;
    Dimension size;
    Connection con;
    String string,bookN,bookP;
    PreparedStatement pst;
    ResultSet resultSet;

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src/DB/DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject2(){
        super("GetBook");
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
        setIconImage(icon);
        setLayout(null);
        connect();

        p1 = new JPanel(null);
        p1.setBounds(0,0,1400,100);
        p1.setBackground(new Color(0x79381A));
        add(p1);

        bar = new JMenuBar();
        setJMenuBar(bar);
        cat = new JMenu("Categories");
        children = new JMenuItem("Children's");
        //religion = new JMenuItem("Religion");
        psychology = new JMenuItem("Psychology");
        romantic = new JMenuItem("Romantic");
        cat.add(children);
        //cat.add(religion);
        cat.add(psychology);
        cat.add(romantic);
        bar.add(cat);
        saved = new JMenu("Bill");
        bought = new JMenuItem("Bought");
        saved.add(bought);
        bar.add(saved);
        about_program = new JMenu("Other Options");
        about_us = new JMenuItem("About Us");
        exit = new JMenuItem("Exit");
        delete = new JMenuItem("Delete Account");
        about_program.add(about_us);
        about_program.add(exit);
        about_program.add(delete);
        bar.add(about_program);
        setAction();

        adv = new JLabel("If You Feel Alone Just GetBook");
        adv.setBounds(50,5,500,90);
        adv.setFont(new Font("Fo",Font.HANGING_BASELINE,30));
        adv.setForeground(Color.WHITE);
        p1.add(adv);

        home_book();

        request = new JLabel("Write The Name Of The Book You Did Not Find And We Will Offer It For You");
        request.setBounds(700,5,510,40);
        request.setFont(new Font("Fo",Font.ITALIC,15));
        request.setForeground(Color.WHITE);
        p1.add(request);
        request_text = new JTextField();
        request_text.setBounds(705,50,300,25);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        request_text.setBorder(border);
        p1.add(request_text);
        send = new JButton("Send");
        send.setBounds(1000,50,100,25);
        send.setForeground(Color.WHITE);
        send.setBackground(Color.BLACK);
        send.setBorder(border);
        p1.add(send);

        confirm = new JButton("Confirm");
        confirm.setBounds(1240,10,100,25);
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(Color.GREEN);
        confirm.setBorder(border);
        p1.add(confirm);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JavaProject10 obj = new JavaProject10();
                obj.setSize(400,450);
                obj.setVisible(true);
                obj.setLayout(null);
                obj.setLocationRelativeTo(null);
                Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
                obj.setIconImage(icon);
            }
        });
    }

  /*  public static void main(String[] args) {
        JavaProject2 obj = new JavaProject2();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        obj.setSize(screenSize.width,screenSize.height);
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
        obj.setIconImage(icon);
        obj.connect();
    }*/

    public void home_book(){
        p2 = new JPanel(null);
        p2.setBounds(0,100,1400,600);
        p2.setBackground(new Color(0x94EAD1A5, true));
        add(p2);

        popular = new JLabel("Most Popular");
        popular.setBounds(600,0,500,70);
        popular.setFont(new Font("Fo",Font.PLAIN,25));
        popular.setForeground(Color.BLACK);
        p2.add(popular);

        JLabel img1 = new JLabel();
        img1.setIcon(new ImageIcon("src\\Java Project images\\book1.jpg"));
        size = img1.getPreferredSize();
        img1.setBounds(50, 70, size.width, size.height);
        p2.add(img1);
        price = new JLabel("2.05$");
        price.setBounds(60, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy1 = new JButton("Buy");
        buy1.setBackground(Color.GREEN);
        buy1.setBounds(112, 255,55,30);
        p2.add(buy1);
        buy1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy1) {
                    try {
                        string = "select * from book_table where book_name='the secret'";
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

        JLabel img2 = new JLabel();
        img2.setIcon(new ImageIcon("src\\Java Project images\\book2.jpg"));
        size = img2.getPreferredSize();
        img2.setBounds(235, 70, size.width, size.height);
        p2.add(img2);
        price = new JLabel("5.05$");
        price.setBounds(250, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy2 = new JButton("Buy");
        buy2.setBackground(Color.GREEN);
        buy2.setBounds(295, 255,55,30);
        p2.add(buy2);
        buy2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy2) {
                    try {
                        string = "select * from book_table where book_name='a litter devil in amebica'";
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

        JLabel img3 = new JLabel();
        img3.setIcon(new ImageIcon("src\\Java Project images\\book3.jpg"));
        size = img3.getPreferredSize();
        img3.setBounds(420, 70, size.width, size.height);
        p2.add(img3);
        price = new JLabel("2.00$");
        price.setBounds(440, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy3 = new JButton("Buy");
        buy3.setBackground(Color.GREEN);
        buy3.setBounds(488, 255,55,30);
        p2.add(buy3);
        buy3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy3) {
                    try {
                        string = "select * from book_table where book_name='rich dad poor dad'";
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

        JLabel img4 = new JLabel();
        img4.setIcon(new ImageIcon("src\\Java Project images\\book4.jpg"));
        size = img4.getPreferredSize();
        img4.setBounds(605, 70, size.width, size.height);
        p2.add(img4);
        price = new JLabel("2.00$");
        price.setBounds(625, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy4 = new JButton("Buy");
        buy4.setBackground(Color.GREEN);
        buy4.setBounds(670,255,55,30);
        p2.add(buy4);
        buy4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy4) {
                    try {
                        string = "select * from book_table where book_name='the da vinci code'";
                        pst = con.prepareStatement(string);
                        resultSet = pst.executeQuery();
                        while (resultSet.next()) {
                            bookN = resultSet.getString("book_name");
                            bookP = resultSet.getString("book_price");
                        }
                        JOptionPane.showMessageDialog(null,"You Just Bought "+bookN+" With "+bookP+"");
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JLabel img5 = new JLabel();
        img5.setIcon(new ImageIcon("src\\Java Project images\\book5.jpg"));
        size = img5.getPreferredSize();
        img5.setBounds(800, 70, size.width, size.height);
        p2.add(img5);
        price = new JLabel("3.01$");
        price.setBounds(815, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy5 = new JButton("Buy");
        buy5.setBackground(Color.GREEN);
        buy5.setBounds(860,255,55,30);
        p2.add(buy5);
        buy5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy5) {
                    try {
                        string = "select * from book_table where book_name='death traiv to boston'";
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

        JLabel img6 = new JLabel();
        img6.setIcon(new ImageIcon("src\\Java Project images\\book6.jpg"));
        size = img6.getPreferredSize();
        img6.setBounds(980, 70, size.width, size.height);
        p2.add(img6);
        price = new JLabel("7.30$");
        price.setBounds(980, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy6 = new JButton("Buy");
        buy6.setBackground(Color.GREEN);
        buy6.setBounds(1030,255,55,30);
        p2.add(buy6);
        buy6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy6) {
                    try {
                        string = "select * from book_table where book_name='east west street'";
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

        JLabel img7 = new JLabel();
        img7.setIcon(new ImageIcon("src\\Java Project images\\book7.jpg"));
        size = img7.getPreferredSize();
        img7.setBounds(1155, 70, size.width, size.height);
        p2.add(img7);
        price = new JLabel("4.08$");
        price.setBounds(1160, 230,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy7 = new JButton("Buy");
        buy7.setBackground(Color.GREEN);
        buy7.setBounds(1210,255,55,30);
        p2.add(buy7);
        buy7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy7) {
                    try {
                        string = "select * from book_table where book_name='poor people knowledge'";
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

        trend = new JLabel("Trending");
        trend.setBounds(620,260,500,100);
        trend.setFont(new Font("Fo",Font.PLAIN,25));
        trend.setForeground(Color.BLACK);
        p2.add(trend);

        JLabel img8 = new JLabel();
        img8.setIcon(new ImageIcon("src\\Java Project images\\book8.jpg"));
        size = img8.getPreferredSize();
        img8.setBounds(50, 340, size.width, size.height);
        p2.add(img8);
        price = new JLabel("13.04$");
        price.setBounds(440, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy8 = new JButton("Buy");
        buy8.setBackground(Color.GREEN);
        buy8.setBounds(488, 530,55,30);
        p2.add(buy8);
        buy8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy8) {
                    try {
                        string = "select * from book_table where book_name='scenarios for future'";
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

        JLabel img9 = new JLabel();
        img9.setIcon(new ImageIcon("src\\Java Project images\\book9.jpg"));
        size = img9.getPreferredSize();
        img9.setBounds(235, 340, size.width, size.height);
        p2.add(img9);
        price = new JLabel("10.05$");
        price.setBounds(55, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy9 = new JButton("Buy");
        buy9.setBackground(Color.GREEN);
        buy9.setBounds(110, 530,55,30);
        p2.add(buy9);
        buy9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy9) {
                    try {
                        string = "select * from book_table where book_name='the other mrs'";
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

        JLabel img10 = new JLabel();
        img10.setIcon(new ImageIcon("src\\Java Project images\\book10.jpg"));
        size = img10.getPreferredSize();
        img10.setBounds(420, 340, size.width, size.height);
        p2.add(img10);
        price = new JLabel("7.09$");
        price.setBounds(250, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy10 = new JButton("Buy");
        buy10.setBackground(Color.GREEN);
        buy10.setBounds(295, 530,55,30);
        p2.add(buy10);
        buy10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy10) {
                    try {
                        string = "select * from book_table where book_name='1776'";
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

        JLabel img11 = new JLabel();
        img11.setIcon(new ImageIcon("src\\Java Project images\\book11.jpg"));
        size = img11.getPreferredSize();
        img11.setBounds(605, 340, size.width, size.height);
        p2.add(img11);
        price = new JLabel("8.11$");
        price.setBounds(625, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy11 = new JButton("Buy");
        buy11.setBackground(Color.GREEN);
        buy11.setBounds(670,530,55,30);
        p2.add(buy11);
        buy11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy11) {
                    try {
                        string = "select * from book_table where book_name='the sleep experiment'";
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

        JLabel img12 = new JLabel();
        img12.setIcon(new ImageIcon("src\\Java Project images\\book12.jpg"));
        size = img12.getPreferredSize();
        img12.setBounds(800, 340, size.width, size.height);
        p2.add(img12);
        price = new JLabel("10.08$");
        price.setBounds(815, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy12 = new JButton("Buy");
        buy12.setBackground(Color.GREEN);
        buy12.setBounds(860,530,55,30);
        p2.add(buy12);
        buy12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy12) {
                    try {
                        string = "select * from book_table where book_name='to heaven and back'";
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

        JLabel img13 = new JLabel();
        img13.setIcon(new ImageIcon("src\\Java Project images\\book13.jpg"));
        size = img13.getPreferredSize();
        img13.setBounds(980, 340, size.width, size.height);
        p2.add(img13);
        price = new JLabel("16.01$");
        price.setBounds(980, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy13 = new JButton("Buy");
        buy13.setBackground(Color.GREEN);
        buy13.setBounds(1030,530,55,30);
        p2.add(buy13);
        buy13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy13) {
                    try {
                        string = "select * from book_table where book_name='scythe'";
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

        JLabel img14 = new JLabel();
        img14.setIcon(new ImageIcon("src\\Java Project images\\book14.jpg"));
        size = img14.getPreferredSize();
        img14.setBounds(1155, 340, size.width, size.height);
        p2.add(img14);
        price = new JLabel("5.00$");
        price.setBounds(1160, 505,80,80);
        price.setForeground(Color.black);
        price.setFont(new Font("Fo",Font.PLAIN,15));
        p2.add(price);
        JButton buy14 = new JButton("Buy");
        buy14.setBackground(Color.GREEN);
        buy14.setBounds(1210,530,55,30);
        p2.add(buy14);
        buy14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ec) {
                if (ec.getSource()==buy14) {
                    try {
                        string = "select * from book_table where book_name='death the way home'";
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

    public void setAction(){
        children.addActionListener(this);
        //religion.addActionListener(this);
        psychology.addActionListener(this);
        romantic.addActionListener(this);
        about_us.addActionListener(this);
        exit.addActionListener(this);
        bought.addActionListener(this);
        delete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==children){
            JavaProject3 obj = new JavaProject3();
            obj.setVisible(true);
            obj.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            obj.setSize(screenSize.width,screenSize.height);
            obj.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        /*else if (e.getSource()==religion){
            JavaProject4 obj = new JavaProject4();
            obj.setVisible(true);
            obj.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            obj.setSize(screenSize.width,screenSize.height);
            obj.setLocationRelativeTo(null);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }*/
        else if (e.getSource()==psychology){
            JavaProject5 obj = new JavaProject5();
            obj.setVisible(true);
            obj.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            obj.setSize(screenSize.width,screenSize.height);
            obj.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        else if (e.getSource()==romantic){
            JavaProject6 obj = new JavaProject6();
            obj.setVisible(true);
            obj.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            obj.setSize(screenSize.width,screenSize.height);
            obj.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        else if (e.getSource()==about_us){
            JavaProject7 obj = new JavaProject7();
            obj.setVisible(true);
            obj.setLayout(null);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            obj.setSize(screenSize.width,screenSize.height);
            obj.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        else if (e.getSource()==bought){
            JavaProject8 obj = new JavaProject8();
            obj.setVisible(true);
            obj.setLayout(null);
            obj.setSize(800,600);
            obj.setLocationRelativeTo(null);
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        else if (e.getSource()==delete){
            JavaProject9 obj= new JavaProject9();
            obj.setVisible(true);
            obj.setSize(800,600);
            obj.setLocationRelativeTo(null);
            obj.connect();
            Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
            obj.setIconImage(icon);
        }
        else if (e.getSource()==exit){
            this.dispose();
        }
    }
}