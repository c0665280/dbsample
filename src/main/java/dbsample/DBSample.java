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

        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String name = "dbsample";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        return DriverManager.getConnection(url, username, password);
    }
    
    public static String getTable() {
        
        String output = "";
        
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from people");
            
            while(rs.next()){
//                String name = rs.getString("name");
//                String Bio = rs.getString("bio");
//                output += "<p>"+name+" : "+Bio+" </p>"; 
                output += "<h2>" +rs.getString("name")+"</h2>";
                output += "<h2>" +rs.getString("bio")+"</h2>";
            }
            
            conn.close();
            
        } catch (SQLException ex) {
            output=ex.getMessage();
        }
        return output;
        
    }
}
