package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

    JButton view, add, update, remove;
    
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1000, 600);
        add(image);
        
        JLabel heading = new JLabel("Operations");
        heading.setBounds(20, 20, 250, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 40));
        heading.setForeground(Color.BLUE);
        image.add(heading);
        
        add = new JButton("Add Employee");
        add.setBounds(20, 80, 180, 40);
        add.setFont(new Font("arial", Font.BOLD, 15));
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLUE);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(230, 80, 180, 40);
        view.setFont(new Font("arial", Font.BOLD, 15));
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLUE);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(20, 140, 180, 40);
        update.setFont(new Font("arial", Font.BOLD, 15));
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLUE);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(230, 140, 180, 40);
        remove.setFont(new Font("arial", Font.BOLD, 15));
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLUE);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1000, 600);
        setLocation(250, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployees();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployees();
        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}