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
        Connect();
    }

    public Connection Connect() {

        com.mysql.jdbc.Connection result = null;
        try {
            Class.forName("com.mysql.jdbc.Connection");
            this.connection = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3340/employeeinfoaystem?user=root&password=1234");
        } catch (Exception err) {
            System.out.println(err.toString());
        }
        return result;
    }

}
