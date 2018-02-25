/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DatabaseData.AdminPage;
import Util.ConnectionClass;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Syste
 */
@Named(value="AdminPage")
@SessionScoped
public class AdminPageController {
   
    public static AdminPage adminpage = new AdminPage();
    
    public void findPersonalId(String CTNumber)
    {
        try{
            ConnectionClass connection = new ConnectionClass();
            PreparedStatement stm = (PreparedStatement) connection.connection.prepareStatement("SELECT PInfoId, EName, ESurname FROM PesonalInfo WHERE 	CitizensShipNumber = ?");
            stm.setString(1, CTNumber);
          ResultSet rs = stm.executeQuery();
          while(rs.next())
          {
              adminpage.PersonalId = rs.getInt("PInfoId");
              adminpage.PersonalName = rs.getString("EName");
              adminpage.PersonalSurname = rs.getString("ESurname");
          }
        }
        catch(Exception Ex)
        {
          Ex.printStackTrace();
        }
    }
    
}
