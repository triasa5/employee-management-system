package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    
    Splash() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(50, 30, 1210, 60);
        heading.setFont(new Font("arial", Font.BOLD, 60));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 200, 50);
        clickhere.setBackground(Color.WHITE);
        clickhere.setForeground(Color.BLUE);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
     }
    
    public static void main(String args[]) {
        new Splash();
    }
}
