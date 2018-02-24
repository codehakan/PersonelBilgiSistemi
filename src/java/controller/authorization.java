/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@Named(value="auth")
@SessionScoped
public class authorization {
    public boolean authStatus = false;
    public int PersonInfoId;
    public int UserType;
    public int UserId;
    public ResultSet UserPerms;

    // if auth result isnt success, PersonInfo etc. wont defined.
    public String getAuthorized(String Username, String Password){
        String result = "login";
        try{
             ConnectionClass connect = new ConnectionClass();
            PreparedStatement  stm = (PreparedStatement) connect.connection.prepareStatement("SELECT UserType, UserId, PersonId FROM Users WHERE Username=? AND Password=?");
            stm.setString(1,Username);
            stm.setString(2,Password);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                while(rs.next())
                {
                    stm.clearParameters();
                    authStatus = true;
                    UserType = rs.getInt(1);
                    UserId = rs.getInt(2);
                    PersonInfoId = rs.getInt(3);
                    stm = (PreparedStatement) connect.connection.prepareStatement("SELECT PermissionId, PemVisual, PermSet FROM UserPerms WHERE UserIdNum=?");
                    stm.setInt(1, PersonInfoId);
                    UserPerms = stm.executeQuery();
                }   
                    result =  "main";
            }
            else{
            }
        } catch (Exception ex)
        {
            System.out.println("Error: " + ex.getStackTrace());
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
