import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class JavaProject10 extends JFrame implements ActionListener{
    JLabel cityBill,locationBill,creditBill,dateBill;
    JTextField billC_text,credit_text,date_text;
    JTextArea location_text;
    JButton confirmInfo;
    Border border = BorderFactory.createLineBorder(new Color(0x6BA64E1B));
    Connection con;
    PreparedStatement ps;

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src//DB//DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject10(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\three.jpg")));
        connect();

        cityBill = new JLabel("Name of City");
        cityBill.setBounds(10, 40, 100, 20);
        cityBill.setFont(new Font("Fo", Font.ITALIC, 15));
        cityBill.setForeground(Color.WHITE);
        add(cityBill);
        billC_text = new JTextField(15);
        billC_text.setBounds(130, 40, 200, 20);
        billC_text.setBorder(border);
        add(billC_text);

        creditBill = new JLabel("Credit_NO");
        creditBill.setBounds(10, 80, 100, 20);
        creditBill.setFont(new Font("Fo", Font.ITALIC, 15));
        creditBill.setForeground(Color.WHITE);
        add(creditBill);
        credit_text=new JTextField(15);
        credit_text.setBounds(130, 80, 200, 20);
        credit_text.setBorder(border);
        add(credit_text);

        dateBill = new JLabel("Date");
        dateBill.setBounds(10, 120, 100, 20);
        dateBill.setFont(new Font("Fo", Font.ITALIC, 15));
        dateBill.setForeground(Color.WHITE);
        add(dateBill);
        date_text = new JTextField(15);
        date_text.setBounds(130, 120, 200, 20);
        date_text.setBorder(border);
        add(date_text);

        locationBill = new JLabel("Location");
        locationBill.setBounds(10, 160, 100, 20);
        locationBill.setFont(new Font("Fo", Font.ITALIC, 15));
        locationBill.setForeground(Color.WHITE);
        add(locationBill);
        location_text = new JTextArea(20,40);
        location_text.setBounds(130, 160,200, 100);
        location_text.setBorder(border);
        add(location_text);

        confirmInfo = new JButton("Confirm");
        confirmInfo.setBounds(130, 280, 100, 30);
        confirmInfo.setForeground(Color.WHITE);
        confirmInfo.setBackground(Color.GREEN);
        confirmInfo.setFont(new Font("Fo", Font.ITALIC, 15));
        confirmInfo.setBorder(border);
        add(confirmInfo);
        confirmInfo.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmInfo) {
            JOptionPane.showMessageDialog(null, "The Transaction Cost is 10$");
            SavedData.CITY = billC_text.getText();
            SavedData.CREDIT = Integer.parseInt(credit_text.getText());
            SavedData.DATE = date_text.getText();
            SavedData.LOCATION = location_text.getText();
            try {
               // String sql = "INSERT INTO invoice VALUES(1,'"+SavedData.BOOKNAME+"','"+SavedData.LOCATION+"',"+Integer.parseInt(SavedData.CREDIT)+",'"+SavedData.USERNAME+"','"+SavedData.CITY+"','"+SavedData.DATE+"',10,"+Double.parseDouble(SavedData.BOOKPRICE)+","+(Double.parseDouble(SavedData.BOOKPRICE)+10)+")";
                String sql = "INSERT INTO invoice VALUES(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, 1);
                ps.setString(2, SavedData.BOOKNAME);
                ps.setString(3, SavedData.USERNAME);
                ps.setString(4, SavedData.CITY);
                ps.setString(5, SavedData.LOCATION);
                ps.setInt(6, SavedData.CREDIT);
                ps.setDouble(7, Double.parseDouble(SavedData.BOOKPRICE));
                ps.setInt(8, 10);
                ps.setDouble(9, (Double.parseDouble(SavedData.BOOKPRICE)+10));
                ps.executeUpdate();
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

  /*  public static void main(String[] args) {
        JavaProject10 obj = new JavaProject10();
        obj.setSize(400,450);
        obj.setVisible(true);
        obj.setLayout(null);
        obj.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
        obj.setIconImage(icon);
    }*/
}
