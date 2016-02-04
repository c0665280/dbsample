/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsample;

import java.sql.*;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author c0665280
 */
public class DBSample {

    private static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSample.class.getName()).log(Level.SEVERE, null, ex);
        }

        String host = System.getenv("OPENHOST_MYSQL_DB_HOST");
        String port = System.getenv("OPENHOST_MYSQL_DB_port");
        String username = System.getenv("OPENHOST_MYSQL_DB_username");
        String password = System.getenv("OPENHOST_MYSQL_DB_password");
        String name = "dbsample";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + username;
        return DriverManager.getConnection(url, username, password);
    }
    
    public static String getTable() {
        
        String output = "";
        
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from people");
            
            while(rs.next()){
                String name = rs.getString("name");
                String Bio = rs.getString("Bio");
                output += "<p>"+name+" : "+Bio+" </p>"; 
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSample.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
        
    }
}
