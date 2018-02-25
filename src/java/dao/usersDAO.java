/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConnectionClass;
import entity.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class usersDAO {
    
    // veritabanında bulunan bütün kullanıcıları listeleyen method
    public List<users> getUsers()
    {
        List<users> clist = new ArrayList();
        ConnectionClass db = new ConnectionClass();
        Connection c = db.Connect();
        
        try {
               Statement st = c.createStatement();
               ResultSet rs = st.executeQuery("select * from users");
               while ( rs.next() )
               {
                   users tmp = new users(rs.getInt("UserId"),rs.getString("Username"),rs.getString("Password"),rs.getInt("UserType"),rs.getInt("PersonId"));
                   clist.add(tmp);
               }
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
        return clist;
    }
    
    // belirtilen kullanıcı adına göre kullanıcıyı silen method
    public void getUsers(String UserName)
    {
        ConnectionClass db = new ConnectionClass();
        Connection c = db.Connect();
        
        try {
            Statement st = c.createStatement();
            PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE Username=?");
            ps.setString(1, UserName);
            ps.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
