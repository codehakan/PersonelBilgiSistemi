/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Syste
 */
public class ConnectionClass {
    

    public Connection Connect() {

        Connection c =null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfosystem?user=root&password=1234");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            System.out.println(ex.getMessage());
        }
        return c;
    }

}
