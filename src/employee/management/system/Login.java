package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername, tfpassword;
    JButton login;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 150, 20);
        lblusername.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 25);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 150, 20);
        lblpassword.setFont(new Font("arial", Font.PLAIN, 20));
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 25);
        add(tfpassword);
        
        login = new JButton("LOG IN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Employees.png"));
        Image i2 = i1.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 170, 170);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            System.out.print(""+username+" "+password);
            
            ConnectionClass c = new ConnectionClass();
            String query = "select * from ems.login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password!");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}