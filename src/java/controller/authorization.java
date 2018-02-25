/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@ManagedBean(name="auth")
@SessionScoped
public class authorization {
    public boolean authStatus = false;
    public int PersonInfoId;
    public int UserType;
    public int UserId;
    public ResultSet UserPerms;
    public String username, password;
    
    public authorization(){
        username="";
        password="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // if auth result isnt success, PersonInfo etc. wont defined.
    public String getAuthorized(){
        String result = "index";
        try{
             ConnectionClass connect = new ConnectionClass();
            PreparedStatement  stm = (PreparedStatement) connect.connection.prepareStatement("SELECT UserType, UserId, PersonId FROM Users WHERE Username=? AND Password=?");
            stm.setString(1,username);
            stm.setString(2,password);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                    stm.clearParameters();
                    authStatus = true;
                    UserType = rs.getInt(1);
                    UserId = rs.getInt(2);
                    PersonInfoId = rs.getInt(3);
                    stm = (PreparedStatement) connect.connection.prepareStatement("SELECT P.PermName, P.PermLink PemVisual, PermSet FROM UserPerms UP  " 
                            + "INNER JOIN Perms P ON P.PermId = UP.PermissionId "
                            + "WHERE UserIdNum=?");
                    stm.setInt(1, PersonInfoId);
                    UserPerms = stm.executeQuery();
       
                    result =  "main";
                    System.out.println("Giriş");
            }
        } catch (Exception ex)
        {
           ex.printStackTrace();
        }
        return result;
    }

    
    public boolean isAuthStatus() {
        return authStatus;
    }

    public int getPersonInfoId() {
        return PersonInfoId;
    }


    public int getUserType() {
        return UserType;
    }

    public ResultSet getUserPerms() {
        return UserPerms;
    }

    
}
