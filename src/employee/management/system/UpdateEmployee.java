package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation, tfage, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/UpdateEmployee.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 20, 100, 100);
        add(image);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        lblname.setFont(new Font("arial", Font.ITALIC, 15));
        add(lblname);
        
        JLabel labelage = new JLabel("Age");
        labelage.setBounds(400, 150, 150, 30);
        labelage.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelage);
        
        tfage = new JTextField();
        tfage.setBounds(600, 150, 150, 30);
        add(tfage);
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("arial", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        lbldob.setFont(new Font("arial", Font.ITALIC, 15));
        add(lbldob);
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("arial", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 170, 30);
        labeleducation.setFont(new Font("arial", Font.PLAIN, 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("arial", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelaadhar);
        
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        lblaadhar.setFont(new Font("arial", Font.ITALIC, 15));
        add(lblaadhar);
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("arial", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("arial", Font.ITALIC, 15));
        add(lblempId);
        
        try {
            ConnectionClass c = new ConnectionClass();
            String query = "select * from ems.employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tfage.setText(rs.getString("age"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLUE);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String age = tfage.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            try {
                ConnectionClass conn = new ConnectionClass();
                String query = "update ems.employee set age = '"+age+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
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
        new UpdateEmployee("");
    }
}