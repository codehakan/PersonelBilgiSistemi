/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Syste
 */
public class ConnectionClass {
    
      public Connection connection;

    public ConnectionClass() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3340/employeeinfosystem?user=root&password=1234");
        } catch (Exception err) {
            System.out.println(err.toString());
        }
    }
    
    
}
