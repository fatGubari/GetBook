import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;

public class JavaProject extends JFrame implements ActionListener {
    JLabel login_form,name_label ,password_label,new_account,new_name,new_email,new_password,re_password,create_form,arrow,forget_password;
    JTextField name_text,password_text,new_textN,new_textE,new_textP,new_textRP,password_textFP;
    JButton login, confirm, change;
    JPanel p1,p2;
    int j = 3;
    Font font = new Font("F", Font.PLAIN,18);
    Border border = BorderFactory.createLineBorder(new Color(0x6BA64E1B));
    Connection con;
    String str,str1,str2,userDB,passDB;
    Statement st1;
    ResultSet result;
    PreparedStatement ps;

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src//DB//DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject() {
        super("GetBook");
        setLayout(new FlowLayout());
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\six.jpg")));

        p1 = new JPanel(null);
        p1.setBounds(290, 155, 250, 350);
        p1.setBackground(new Color(0, 0, 0, 107));
        add(p1);

        login_form = new JLabel("Login");
        login_form.setBounds(100, 20, 150, 30);
        login_form.setFont(new Font("Fo", Font.BOLD, 25));
        login_form.setForeground(Color.WHITE);
        p1.add(login_form);

        name_label = new JLabel("Username");
        name_label.setBounds(50, 60, 150, 20);
        name_label.setFont(font);
        name_label.setForeground(new Color(0x6BA64E1B));
        p1.add(name_label);
        name_text = new JTextField(15);
        name_text.setBounds(50, 85, 160, 20);
        name_text.setBorder(border);
        p1.add(name_text);

        password_label = new JLabel("Password");
        password_label.setBounds(50, 120, 150, 20);
        password_label.setFont(font);
        password_label.setForeground(new Color(0x6BA64E1B));
        p1.add(password_label);
        password_text = new JPasswordField(15);
        password_text.setBounds(50, 145, 160, 20);
        password_text.setBorder(border);
        p1.add(password_text);

        forget_password = new JLabel("Forget Password");
        forget_password.setBounds(80, 180, 180, 15);
        forget_password.setFont(new Font("F", Font.PLAIN, 13));
        forget_password.setForeground(Color.WHITE);
        forget_password.setVisible(false);
        p1.add(forget_password);
        forget_password.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                forgetPassword();
                p1.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        login = new JButton("LOGIN");
        login.setBounds(80, 210, 100, 30);
        login.setBackground(new Color(0x6BA64E1B));
        login.setForeground(Color.WHITE);
        login.setBorder(border);
        login.setFont(new Font("F", Font.PLAIN, 16));
        p1.add(login);
        login.addActionListener(this);

        new_account = new JLabel("Create Account");
        new_account.setBounds(85, 245, 200, 20);
        new_account.setFont(new Font("F", Font.ITALIC,13));
        new_account.setForeground(Color.WHITE);
        p1.add(new_account);
        new_account.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                p1.setVisible(false);
                create_account();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==login) {
            try {
                str ="select user_ID,username,password from login_form where (username='"+name_text.getText()+"' and Password='"+password_text.getText()+"') ";
                ps = con.prepareStatement(str);
                result = ps.executeQuery();
                if (result.next())
                {
                    userDB = result.getString("username");
                    passDB = result.getString("password");
                   if ( passDB.equals(password_text.getText()) && userDB.equalsIgnoreCase(name_text.getText()) ) {
                       SavedData.USERNAME = userDB;
                       this.setVisible(false);
                       JavaProject2 obj1 = new JavaProject2();
                       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                       obj1.setSize(screenSize.width, screenSize.height);
                       obj1.setVisible(true);
                       obj1.setLocationRelativeTo(null);
                       obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                   }
                }
                else {
                    j--;
                    if (j == 2) {
                        forget_password.setVisible(true);
                        JOptionPane.showMessageDialog(null,"Make Sure That The Password And Username Are Correct");
                    }
                    if (j == 1) {
                        JOptionPane.showMessageDialog(null, "You Still Have " + j + " trie left");
                    }
                    if (j == 0) {
                        this.dispose();
                    }
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource()==confirm && check_create_password() ==1) {
            try {
                str1 = "insert into login_form values( 1 ,'"+new_textN.getText()+"','"+new_textP.getText()+"','"+new_textE.getText()+"')";
                st1 = con.createStatement();
                st1.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "You Have Sign up Successfully");
                p2.setVisible(false);
                p1.setVisible(true);
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JavaProject obj = new  JavaProject();
        obj.setVisible(true);
        obj.setSize(800,600);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.connect();
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
        obj.setIconImage(icon);
    }

    public void create_account(){
        p2 = new JPanel(null);
        p2.setVisible(true);
        p2.setBounds(290,150,250,350);
        p2.setBackground(new Color(0, 0, 0, 107));
        add(p2);

        arrow = new JLabel("<<");
        arrow.setBounds(10,10,150,30);
        arrow.setFont(new Font("Fo",Font.PLAIN,20));
        arrow.setForeground(Color.WHITE);
        p2.add(arrow);
        arrow.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                p2.setVisible(false);
                p1.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        create_form = new JLabel("Create Form");
        create_form.setBounds(65,10,150,30);
        create_form.setFont(new Font("Fo",Font.BOLD,20));
        create_form.setForeground(Color.WHITE);
        p2.add(create_form);

        new_name = new JLabel("Username");
        new_name.setBounds(40, 35, 150, 30);
        new_name.setFont(font);
        new_name.setForeground(new Color(0x6BA64E1B));
        p2.add(new_name);
        new_textN = new JTextField(20);
        new_textN.setBounds(40, 65,160, 20);
        new_textN.setBorder(border);
        p2.add(new_textN);

        new_email = new JLabel("Email");
        new_email.setBounds(40, 90,150, 20);
        new_email.setFont(font);
        new_email.setForeground(new Color(0x6BA64E1B));
        p2.add(new_email);
        new_textE = new JTextField(20);
        new_textE.setBounds(40, 115, 160, 20);
        new_textE.setBorder(border);
        p2.add(new_textE);

        new_password = new JLabel("Password");
        new_password.setBounds(40, 140,150, 20);
        new_password.setFont(font);
        new_password.setForeground(new Color(0x6BA64E1B));
        p2.add(new_password);
        new_textP = new JPasswordField(20);
        new_textP.setBounds(40, 165, 160, 20);
        new_textP.setBorder(border);
        p2.add(new_textP);

        re_password = new JLabel("Re-Password");
        re_password.setBounds(40, 190,150, 20);
        re_password.setFont(font);
        re_password.setForeground(new Color(0x6BA64E1B));
        p2.add(re_password);
        new_textRP = new JPasswordField(20);
        new_textRP.setBounds(40, 215, 160, 20);
        new_textRP.setBorder(border);
        p2.add(new_textRP);

        confirm = new  JButton("Confirm");
        confirm.setBounds(80, 250, 100, 30);
        confirm.setBackground(new Color(0x6BA64E1B));
        confirm.setForeground(Color.WHITE);
        confirm.setBorder(border);
        confirm.setFont(new Font("F", Font.PLAIN,16));
        p2.add(confirm);
        confirm.addActionListener(this);
    }

    public int check_create_password(){
        String password = new_textP.getText();
        char[] check = password.toCharArray();
        int number=0;
        int valid = 0;
        if(password.length()<=8){
            for(int i=0;i<password.length();i++){
                if((check[i]>= 'A' && check[i] <= 'Z')||(check[i]>= 'a' && check[i] <= 'z')){
                    valid=1;
                }
                else if(check[i]>= '0' && check[i] <= '9'){
                    number++;
                }
            }
        }
        if(number>=2){
            valid =1;
        }
        else {
            valid =0;
            JOptionPane.showMessageDialog(null,"Your Password Should Contain 8 Characters of  Letters And At Least Two Digit");
        }
        if (!new_textRP.getText().equals(new_textP.getText())) {
            JOptionPane.showMessageDialog(null, "Your Passwords Should be Match");
            valid=0;
        }
        return valid;
    }

    public void forgetPassword(){
        JPanel p3 = new JPanel(null);
        p3.setVisible(true);
        p3.setBounds(290,150,250,310);
        p3.setBackground(new Color(0, 0, 0, 107));
        add(p3);

        new_email = new JLabel("Email");
        new_email.setBounds(50, 60, 150, 20);
        new_email.setFont(font);
        new_email.setForeground(new Color(0x6BA64E1B));
        p3.add(new_email);
        new_textE = new JTextField(20);
        new_textE.setBounds(50, 85, 160, 20);
        new_textE.setBorder(border);
        p3.add(new_textE);

        password_label = new JLabel("New Password");
        password_label.setBounds(50, 120, 150, 20);
        password_label.setFont(font);
        password_label.setForeground(new Color(0x6BA64E1B));
        p3.add(password_label);
        password_textFP = new JPasswordField(15);
        password_textFP.setBounds(50, 145, 160, 20);
        password_textFP.setBorder(border);
        p3.add(password_textFP);

        change = new JButton("Change");
        change.setBounds(80, 190, 100, 30);
        change.setBackground(new Color(0x6BA64E1B));
        change.setForeground(Color.WHITE);
        change.setBorder(border);
        change.setFont(new Font("F", Font.PLAIN, 16));
        p3.add(change);
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==change){
                    try {
                        str2 = "update login_form set password ='"+password_textFP.getText()+"' where email ='"+new_textE.getText()+"' ";
                        st1 = con.createStatement();
                        st1.executeUpdate(str2);
                        JOptionPane.showMessageDialog(null,"You Changed The Password");
                        p3.setVisible(false);
                        p1.setVisible(true);
                    }
                    catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        });
    }
}