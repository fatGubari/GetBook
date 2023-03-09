import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaMethod;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.sql.*;

public class JavaProject8 extends JFrame implements ActionListener {
    JLabel bill,bookName,username,bookPrice,date,card,location,city,total;
    String billID,billTotal;
    JButton download;
    Connection con;
    ResultSet result;
    PreparedStatement ps;
    Border border = BorderFactory.createLineBorder(new Color(0x3EA61B));

    public void connect(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://src//DB//DB.accdb");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    JavaProject8(){
        super("GetBook");
        setContentPane(new JLabel(new ImageIcon("src\\Java Project images\\three.jpg")));
        connect();
        selectBil();

        bill = new JLabel("Bill ID: "+billID);
        bill.setBounds(330, 40, 250, 30);
        bill.setFont(new Font("Fo", Font.BOLD, 25));
        bill.setForeground(Color.WHITE);
        add(bill);

        bookName = new JLabel("Book Name: "+SavedData.BOOKNAME);
        bookName.setBounds(100,100,550,20);
        bookName.setFont(new Font("Fo", Font.ITALIC, 18));
        bookName.setForeground(Color.WHITE);
        add(bookName);

        username = new JLabel("Username: "+SavedData.USERNAME);
        username.setBounds(100,140,250,20);
        username.setFont(new Font("Fo", Font.ITALIC, 18));
        username.setForeground(Color.WHITE);
        add(username);

        bookPrice = new JLabel("Price: "+SavedData.BOOKPRICE);
        bookPrice.setBounds(100,180,250,20);
        bookPrice.setFont(new Font("Fo", Font.ITALIC, 18));
        bookPrice.setForeground(Color.WHITE);
        add(bookPrice);

        date = new JLabel("Date: "+SavedData.DATE);
        date.setBounds(100,220,250,20);
        date.setFont(new Font("Fo", Font.ITALIC, 18));
        date.setForeground(Color.WHITE);
        add(date);

        card = new JLabel("Credit Card: "+SavedData.CREDIT);
        card.setBounds(100,270,250,20);
        card.setFont(new Font("Fo", Font.ITALIC, 18));
        card.setForeground(Color.WHITE);
        add(card);

        city = new JLabel("City: "+SavedData.CITY);
        city.setBounds(100,320,250,20);
        city.setFont(new Font("Fo", Font.ITALIC, 18));
        city.setForeground(Color.WHITE);
        add(city);

        location = new JLabel("Location: "+SavedData.LOCATION);
        location.setBounds(100,370,550,20);
        location.setFont(new Font("Fo", Font.ITALIC, 18));
        location.setForeground(Color.WHITE);
        add(location);

        total = new JLabel("The Total: "+billTotal);
        total.setBounds(100,420,250,20);
        total.setFont(new Font("Fo", Font.ITALIC, 18));
        total.setForeground(Color.WHITE);
        add(total);

        download = new JButton("Download");
        download.setBounds(100,470,100,25);
        download.setForeground(Color.WHITE);
        download.setBackground(Color.GREEN);
        download.setBorder(border);
        add(download);
        download.addActionListener(this);
    }


    public void selectBil(){
        try {
            String sql = "SELECT * FROM invoice WHERE card ="+SavedData.CREDIT+"";
            ps = con.prepareStatement(sql);
            result = ps.executeQuery();
            while(result.next())
            {
                billID = result.getString("Bill_ID");
                billTotal = result.getString("total");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
        JavaProject8 obj = new JavaProject8();
        obj.setVisible(true);
        obj.setLayout(null);
        obj.setSize(800,600);
        obj.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\Java Project images\\2.png");
        obj.setIconImage(icon);
    }*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==download){
            try {
                FileWriter fw = new FileWriter("C:\\Users\\USERWD\\Documents\\Bill.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Bill ID: " + billID);
                bw.newLine();
                bw.write("Book Name: " + SavedData.BOOKNAME);
                bw.newLine();
                bw.write("Username: " + SavedData.USERNAME);
                bw.newLine();
                bw.write("Book Price: " + SavedData.BOOKPRICE);
                bw.newLine();
                bw.write("Date: " + SavedData.DATE);
                bw.newLine();
                bw.write("Credit Card: " + SavedData.CREDIT);
                bw.newLine();
                bw.write("City: " + SavedData.CITY);
                bw.newLine();
                bw.write("Location: " + SavedData.LOCATION);
                bw.newLine();
                bw.write("Total: " + billTotal);
                bw.newLine();
                bw.close();
                fw.close();
                JOptionPane.showMessageDialog(null,"The Bill Will Be Saved In Documents");
                this.dispose();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}