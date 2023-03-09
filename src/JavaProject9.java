import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaProject9 extends JFrame implements ActionListener {
    JLabel delete_form,name_label,password_label;
    JButton delete;
    JPanel p;
    JTextField name_text,password_text;
    Font font = new Font("F", Font.PLAIN,18);
    Border border = BorderFactory.createLineBorder(new Color(0x6BA64E1B));
    Connection con;
    Statement st;

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src//DB//DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject9(){
        super("GetBook");
        setLayout(new FlowLayout());
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\six.jpg")));

        p = new JPanel(null);
        p.setBounds(290, 155, 250, 350);
        p.setBackground(new Color(0, 0, 0, 107));
        add(p);



        delete_form = new JLabel("Sign out");
        delete_form.setBounds(80, 20, 150, 30);
        delete_form.setFont(new Font("Fo", Font.BOLD, 25));
        delete_form.setForeground(Color.WHITE);
        p.add(delete_form);

        name_label = new JLabel("Username");
        name_label.setBounds(50, 60, 150, 20);
        name_label.setFont(font);
        name_label.setForeground(new Color(0x6BA64E1B));
        p.add(name_label);
        name_text = new JTextField(15);
        name_text.setBounds(50, 85, 160, 20);
        name_text.setBorder(border);
        p.add(name_text);

        password_label = new JLabel("Password");
        password_label.setBounds(50, 120, 150, 20);
        password_label.setFont(font);
        password_label.setForeground(new Color(0x6BA64E1B));
        p.add(password_label);
        password_text = new JPasswordField(15);
        password_text.setBounds(50, 145, 160, 20);
        password_text.setBorder(border);
        p.add(password_text);

        delete = new JButton("Sign out");
        delete.setBounds(80, 210, 100, 30);
        delete.setBackground(new Color(0x6BA64E1B));
        delete.setForeground(Color.WHITE);
        delete.setBorder(border);
        delete.setFont(new Font("F", Font.PLAIN, 16));
        p.add(delete);
        delete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==delete){
            try {
                String str = "delete * from login_form Where username='"+password_text.getText()+"'";
                st = con.createStatement();
                st.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Are You Sure You Want To Sign Out");
                this.dispose();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
