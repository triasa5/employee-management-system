package employee.management.system;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {
    
    Connection con;
    Statement s;

    ConnectionClass () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Triasa@05");
            s = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new ConnectionClass();
    }
}