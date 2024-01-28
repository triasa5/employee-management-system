package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmpId;
    JButton delete, back;
    
    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Remove Employee");
        heading.setBounds(200, 30, 300, 40);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/DeleteEmployee.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 20, 80, 80);
        add(image);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 150, 150, 20);
        labelempId.setFont(new Font("arial", Font.BOLD, 20));
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 150, 150, 20);
        add(cEmpId);
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from ems.employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 200, 150, 20);
        labelname.setFont(new Font("arial", Font.BOLD, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 200, 150, 15);
        lblname.setFont(new Font("arial", Font.PLAIN, 15));
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 250, 150, 20);
        labelphone.setFont(new Font("arial", Font.BOLD, 20));
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 250, 150, 15);
        lblphone.setFont(new Font("arial", Font.PLAIN, 15));
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 20);
        labelemail.setFont(new Font("arial", Font.BOLD, 20));
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 300, 150, 15);
        lblemail.setFont(new Font("arial", Font.PLAIN, 15));
        add(lblemail);
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from ems.employee where empId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    ConnectionClass c = new ConnectionClass();
                    String query = "select * from ems.employee where empId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 350, 100, 30);
        delete.setBackground(Color.BLUE);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 350, 100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(700, 500);
        setLocation(300, 150);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                ConnectionClass c = new ConnectionClass();
                String query = "delete from ems.employee where empId = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully.");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}