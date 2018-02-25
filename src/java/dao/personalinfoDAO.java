/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.ConnectionClass;
import entity.personalinfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HakanBey
 */
public class personalinfoDAO {
    public List<personalinfo> getPersonalInfo()
    {
        List<personalinfo> clist = new ArrayList();
        ConnectionClass db = new ConnectionClass();
        Connection c = db.Connect();
        
        try {
               Statement st = c.createStatement();
               ResultSet rs = st.executeQuery("select * from personalinfo");
               while ( rs.next() )
               {
                   //System.out.println(rs.getString("EName"));
                   personalinfo tmp = new personalinfo(rs.getInt("PInfoId"),rs.getString("EName"),rs.getString("ESurname"),rs.getString("SocialSecurityNumber"),rs.getString("CitizensShipNumber"),rs.getInt("Adress"),rs.getDate("BirthDate"),rs.getInt("Communication"),rs.getBoolean("Gender"),rs.getInt("MaritalStatus"));
                   clist.add(tmp);
               }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }
}
