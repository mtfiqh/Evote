/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import com.mysql.jdbc.Connection;
//import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mtauf
 */
public class DatabaseConnection {
    String host,username,pass;
    public DatabaseConnection(){
        FileDataDatabase filedata = new FileDataDatabase();
        filedata.LoadSettings();
        this.host=filedata.getHost();
        this.username=filedata.username;
        this.pass=filedata.getPassword();
    }

   
    public Connection getConnection(){
        Connection con;
        try{
            con=(Connection) DriverManager.getConnection("jdbc:mysql://"+host, username, pass);
            System.out.println("Connect!");
            return con;
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, host);
            JOptionPane.showMessageDialog(null, "Database not connected!");
            return null;
        }
    }
}
